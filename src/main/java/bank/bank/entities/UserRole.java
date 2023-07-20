package bank.bank.entities;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER"),
    SHOPKEEPER("SHOPKEEPER");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
