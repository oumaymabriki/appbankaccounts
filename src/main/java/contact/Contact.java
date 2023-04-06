package contact;

import jakarta.persistence.*;
import jdk.incubator.vector.VectorOperators;
import user.User;

import java.io.Serializable;

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
