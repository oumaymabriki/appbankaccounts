package account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import user.User;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable{
    @Id
    @GeneratedValue
    private String id;
    @Column(unique = true)
    private String iban;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
