package user;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private Integer id;
    @NotNull(message = "firstName is mondatory")
    private String fistrname;
    @NotNull(message = "lastname is mondatory")
    private String lastname;
    @NotNull(message = "email is mondatory")
    @Email(message = "email should be a valid adress")
    private String email;
    @NotNull(message = "password is mondatory")
    @Size(min = 4, max = 16, message = "password should be between 4 and 16")
    private String password;

}
