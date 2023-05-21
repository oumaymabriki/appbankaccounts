package account;

import jakarta.persistence.EntityNotFoundException;
import Exception.OperationNotPermettedException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user.User;
import validator.ValidateObject;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
     @Autowired
    private AccountRepository accountRepository;
     @Autowired
     private AccountMapper mapper;
      @Autowired
      private ValidateObject<AccountRequest> validator;

    public Integer save(AccountRequest accountRequest){
         validator.Validate(accountRequest);
       var haveAlreadyAnAccount =      accountRepository.existsById(accountRequest.getUserId());
       if(haveAlreadyAnAccount){
           throw new OperationNotPermettedException("this user have already an account");
       }
         //une transformation d'objet request to an entity db a travers un mapper
         var account=  mapper.ToAccount(accountRequest);
          account.setIban(GeneratedIban());
       return accountRepository.save(account).getId();

     }

     @Transactional //it used for an fetch lazy exception it means i need mapped or get users whitch is inside the account object
     //so in this case he will wait to the end of all the transaction get accounst and users
    public List<ResponseAccount> getaccounts() {
        return (List<ResponseAccount>) accountRepository.findAll()
                .stream()
                .map(mapper::ToResponse)
                .collect(Collectors.toList())
                ;
    }

    public ResponseAccount getAccountById(Integer _id) {
        return accountRepository.findById(_id)
                .map(mapper::ToResponse)
                .orElseThrow( () -> new EntityNotFoundException("account not found with this id:"))
                ;
    }

    public void deleteAccount(Integer account_id) {
        accountRepository.deleteById(account_id);
    }

    private   String GeneratedIban(){
        var iban = Iban.random(CountryCode.TN).toFormattedString();
        //check the iban exist or not otherwise generate another one
        if(accountRepository.existsByIban(iban)){
            GeneratedIban();
        }
        return iban;
    }
}
