package account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    boolean existsById(Integer id);
    boolean existsByIban(String iban);
}
