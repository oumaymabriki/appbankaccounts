package transaction;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransactionService {

    @Autowired
    private TransactionMapper mapper;
    @Autowired
    private TransactionRepository transactionRepository;

    public Integer saveTransaction(TransactionRequest request){

      var transaction = mapper.toTransaction(request);
       var multiplier = BigDecimal.valueOf(getTransactionMultiplier(request.getType()));
       var amountSaved = request.getAmount().multiply(multiplier);

       return transactionRepository.save(transaction).getId();
    }


    private int getTransactionMultiplier(TransactionType type){
        return TransactionType.TRANSFER == type ? -1 : 1;
    }
     /* public List<TransactionResponse> getAllTransaction(){
        return transactionRepository.findAll()
                .stream()
                .map(mapper::)
    }*/
}
