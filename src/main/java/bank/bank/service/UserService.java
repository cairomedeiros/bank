package bank.bank.service;

import bank.bank.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String userame) throws UsernameNotFoundException;

    List<User> findAllUsers();

    Optional<User> findById(Long id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
