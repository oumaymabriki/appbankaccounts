package contact;

import lombok.*;

@Getter
@Setter
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
