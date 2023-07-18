package bank.bank.service;

import bank.bank.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    Optional<User> findById(Long id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
