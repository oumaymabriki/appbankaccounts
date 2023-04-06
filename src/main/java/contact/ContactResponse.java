package contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String iban;
    private String email;
}
