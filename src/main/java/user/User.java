package user;

import account.Account;
import contact.Contact;
import jakarta.persistence.*;
import lombok.*;
import role.Role;
import transaction.Transaction;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    private boolean active;
    @OneToMany(mappedBy = "user_id")
    private List<Contact> contacts;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "user_id")
    private List<Transaction> transactions;
    @ManyToMany
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
