package bank.bank.controller;

import bank.bank.configs.security.TokenService;
import bank.bank.dto.AuthenticationDTO;
import bank.bank.dto.LoginResponseDTO;
import bank.bank.dto.RegisterDTO;
import bank.bank.entities.User;
import bank.bank.entities.UserRole;
import bank.bank.repository.UserRepository;
import bank.bank.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> findUsersById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
            var validateCpfCnpj = false;

            if(data.role().getRole().equals(UserRole.USER)){
                validateCpfCnpj = this.userRepository.findByCpf(data.cpf()) != null;
            }else if(data.role().getRole().equals(UserRole.SHOPKEEPER)){
                validateCpfCnpj = this.userRepository.findByCnpj(data.cnpj()) != null;
            }

            if(this.userRepository.findByUserName(data.userName()) != null &&
                this.userRepository.findByEmail(data.email()) != null &&
                    validateCpfCnpj)
                return ResponseEntity.badRequest().build();

            String encryptPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.name(), data.userName(), data.email(), encryptPassword, data.cpf(), data.cnpj(), data.role());

            this.userRepository.save(newUser);

            return ResponseEntity.ok().build();
    }
    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
