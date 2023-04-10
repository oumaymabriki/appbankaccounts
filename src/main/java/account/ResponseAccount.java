package account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseAccount {
    private Integer id;
    private String Iban;
    private String firstname;
    private String lastname;

}
