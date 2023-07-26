package bank.bank.repository;

import bank.bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUserName(String userName);

    UserDetails findByEmail(String email);

    UserDetails findByCpf(String cpf);

    UserDetails findByCnpj(String cnpj);
}
