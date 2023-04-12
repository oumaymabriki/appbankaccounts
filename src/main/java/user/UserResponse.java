package user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String firsname;
    private String lastname;
    private String email;
    private String iban;
    private boolean active;
}
