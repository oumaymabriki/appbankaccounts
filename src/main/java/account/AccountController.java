package account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public Integer save(@RequestBody AccountRequest accountRequest){
        return accountService.save(accountRequest);
    }
    @GetMapping()
    public ResponseEntity<List<ResponseAccount>> get(){
        return ResponseEntity.ok(accountService.getaccounts());
    }
    @GetMapping("{/account_id}")
    public ResponseAccount getById(@PathVariable Integer account_id){
        return accountService.getAccountById(account_id);
    }
    @DeleteMapping("/{account_id}")
    public void delete(@PathVariable Integer account_id){
        accountService.deleteAccount(account_id);
    }
}