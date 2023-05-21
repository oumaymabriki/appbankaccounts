package transaction;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TransactionResponse> findByIdUser(Integer userId) {

        return (List<TransactionResponse>) transactionRepository.findById(userId)
                .stream()
                .map(mapper::ToResponse)
                .collect(Collectors.toList());
    }

}
