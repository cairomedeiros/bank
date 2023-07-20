package bank.bank.dto;

import bank.bank.entities.UserRole;

public record RegisterDTO(String userName, String password, UserRole role) {
}
