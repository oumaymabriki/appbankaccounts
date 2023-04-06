package transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private Integer id;
    private String Iban;
}
