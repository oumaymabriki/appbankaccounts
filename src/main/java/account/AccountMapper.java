package account;

import org.springframework.stereotype.Component;
import user.User;
@Component
public class AccountMapper {

    public Account ToAccount(AccountRequest request){

        return Account.builder()
                .id(request.getIban())
                .user(
                        User.builder()
                                .id(request.getUserId())
                                .build()
                )
                .build();
    }

    public ResponseAccount ToResponse(Account account) {
        return ResponseAccount.builder()
                .id(account.getId())
                .Iban(account.getIban())
                .firstname(account.getUser().getFirstName())
                .lastname(account.getUser().getLastname())
                .build();
    }
}
