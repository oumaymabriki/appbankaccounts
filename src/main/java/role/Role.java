package role;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;


import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {
    @Id
    @GeneratedValue
  private Integer id;
  private String name;
  @ManyToMany
  @JoinTable(
          name = "role_users",
          joinColumns = @JoinColumn(name = "user_id")
          , inverseJoinColumns = @JoinColumn(name = "role_id")
  )
    private List<User> users;

}
