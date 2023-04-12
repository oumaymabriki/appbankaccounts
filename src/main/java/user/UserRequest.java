package user;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private Integer id;
    private String fistrname;
    private String lastname;
    private String email;
    private String password;

}
