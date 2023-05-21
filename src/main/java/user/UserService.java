package user;

import account.Account;
import account.AccountRequest;
import account.AccountService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import validator.ValidateObject;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ValidateObject<UserRequest> validateObject;


    public Integer save(UserRequest request){
       //validate userRequest
        validateObject.Validate(request);
        var user = mapper.ToUser(request);
        user.setActive(false);
        return userRepository.save(user).getId();
    }

    // eager because this is oneToOne fetch by default eager  don't need to another object adjacent
    public ResponseEntity<List<UserResponse>> getAll(){
        return (ResponseEntity<List<UserResponse>>) userRepository.findAll()
                .stream()
                .map(mapper::ToResponse)
                .collect(Collectors.toList())
                ;
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public UserResponse getUserById(Integer id){
        return userRepository.findById(id)
                .map(mapper::ToResponse)
                .orElseThrow(() -> new EntityNotFoundException("entity not found with this id"+id))
                ;
    }

    public Integer ValidateAccount(Integer id){
      var user=  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("entity not found with this id to activate account "+id))
        ;
        if(user.getAccount()==null){
            //create an account first
            var account = AccountRequest
                    .builder()
                    .UserId(id)
                    .build();
             var accountId= accountService.save(account);
              user.setAccount(
                      Account.builder()
                              .id(accountId)
                              .build()
              );
        }
          user.setActive(true);
        return userRepository.save(user).getId();
    }

       public Integer InactiveAccount(Integer id){
           var user=  userRepository.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("entity not found with this id to activate account "+id))
                   ;
         user.setActive(false);
         return userRepository.save(user).getId();
        }
}
