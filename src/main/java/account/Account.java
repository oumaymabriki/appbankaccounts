package account;

import jakarta.persistence.*;
import lombok.*;
import user.User;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String iban;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
