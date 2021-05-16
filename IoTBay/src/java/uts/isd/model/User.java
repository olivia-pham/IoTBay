/*
 * Customer is a JavaBean that stores name, email, password, date of birth
 * 
 */
package uts.isd.model;

/**
 *
 * @author olivi
 */
public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private char accountType; //User can be of 2 types staff = 's' or customer = 'c'
    
    //insert constructor that initializes the fields

    public User(String name, String email, String password, String phone, char accountType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone= phone;
        this.accountType = accountType; 
    }
    
    //insert getters/setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   
    public char getAccountType() {
        return accountType;
    }

    public void setAccountType(char type) {
        this.accountType = type;
    }
    
    
    
}
