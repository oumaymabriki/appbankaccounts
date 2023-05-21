package transaction;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import validator.ValidateObject;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

  @PostMapping()
    public Integer save(@RequestBody TransactionRequest transactionRequest){
      return transactionService.saveTransaction(transactionRequest);
  }

  @GetMapping("/{user-id}")
    public ResponseEntity<List<TransactionResponse>> findAll(
            @PathVariable ("user-id") Integer id
  ){
      return ResponseEntity.ok(transactionService.findByIdUser(id));
  }
}
