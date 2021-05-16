/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author jkmod
 */
public class Admin {
   
    private String email;
    private String password;
    
    public Admin()
    {
        this.email = "admin@gmail.com";
        this.password = "admin";                
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
}
