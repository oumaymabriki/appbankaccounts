package contact;

import jakarta.persistence.*;
import jdk.incubator.vector.VectorOperators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CONTACTS")
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String iban;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
