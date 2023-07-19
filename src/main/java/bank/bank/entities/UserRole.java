package bank.bank.entities;

public enum UserRole {
    ADMIN("admin"),
    USER("user"),
    SHOPKEEPER("shopkeeper");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
