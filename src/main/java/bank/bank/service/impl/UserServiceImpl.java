package bank.bank.service.impl;

import bank.bank.entities.User;
import bank.bank.repository.UserRepository;
import bank.bank.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository accountRepository;

    @Override
    public List<User> findAllUsers() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return accountRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return accountRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        accountRepository.deleteById(id);
    }
}
