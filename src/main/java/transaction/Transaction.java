package transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import user.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal Amount;
    private String destination;
    private LocalDate transactionDate;
    @Enumerated(EnumType.STRING)
    private EnemuratedType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
