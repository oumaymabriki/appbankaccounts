package transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    @NotNull(message = "amount id is mondatory")
    @Positive(message="amount should be positive")
    @Min(0)
    private BigDecimal amount;
    @NotNull(message = "type id is mondatory")
    private TransactionType type;
    @NotNull(message = "destination Iban id is mondatory")
    private String destinationIban;
    @NotNull(message = "user id is mondatory")
    private Integer userId;

}
