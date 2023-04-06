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
    @NotNull(message="id should not be null")
    private Integer id;

}
