package bank.bank.dto;

import bank.bank.entities.UserRole;

public record RegisterDTO(String name, String userName, String email, String password, String cpf, String cnpj, UserRole role) {
}
