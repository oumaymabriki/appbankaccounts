package transaction;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private BigDecimal amount;
    private TransactionType type;
    private String destinationIban;

}
