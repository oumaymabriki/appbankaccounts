package contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

    private Integer id;
    @NotNull(message = "First name is mandatory")
    private String firstname;
    @NotNull(message = "Last name is mandatory")
    private String lastname;
    @NotNull(message = "Email is mandatory")
    @Email(message = "Email should be a valid address")
    private String email;
    @NotNull(message = "IBAN is mandatory")
    private String iban;
    @NotNull(message = "User is mandatory")
    private Integer userId;
}
