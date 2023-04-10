package account;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user.User;
import validator.ValidateObject;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
     @Autowired
    private AccountRepository accountRepository;
     @Autowired
     private AccountMapper mapper;
      @Autowired
      private ValidateObject<AccountRequest> validator;

    public Integer save(AccountRequest accountRequest){
         validator.Validate(accountRequest);
         //une transformation d'objet request to an entity db a travers un mapper
       return accountRepository.save(mapper.ToAccount(accountRequest)).getId();
     }

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
}
