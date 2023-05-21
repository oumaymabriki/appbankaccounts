package transaction;

import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

   public Transaction toTransaction (TransactionRequest transactionRequest){
       return Transaction
               .builder()
               .destination(transactionRequest.getDestinationIban())
               .Amount(transactionRequest.getAmount())
               .type(transactionRequest.getType())
               .build();
   }

   public TransactionResponse ToResponse (Transaction transaction){
       return TransactionResponse
               .builder()
               .amount(transaction.getAmount())
               .DestinationIban(transaction.getDestination())
               .userId(transaction.getUser().getId())
               .Type(transaction.getType())
               .build();
   }
}
