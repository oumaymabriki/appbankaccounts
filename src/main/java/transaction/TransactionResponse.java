package transaction;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private Integer userId;
    private BigDecimal amount;
    private String DestinationIban;
    private TransactionType Type;
}
