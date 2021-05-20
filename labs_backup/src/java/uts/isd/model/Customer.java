/*
 * Customer is a JavaBean that stores name, email, password, date of birth
 * 
 */
package uts.isd.model;

/**
 *
 * @author olivi
 */
public class Customer {
    private String name;
    private String email;
    private String password;
    private String dob;
    
    //insert constructor that initializes the fields

    public Customer(String name, String email, String password, String dob) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
   
    
    
}
