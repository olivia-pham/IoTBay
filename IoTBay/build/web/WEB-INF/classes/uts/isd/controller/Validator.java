/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author olivi
 */
public class Validator implements Serializable{
     
   private final String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private final String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private final String passwordPattern = "([a-z]{4,})([0-9]*)";       
   private final String phonePattern = "[0-9]{4} [0-9]{3} [0-9]{3}";
   private boolean failed = false;
   
   public Validator(){    
   }       

   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }      
   
   public boolean validateEmail(String email){                       
      return validate(emailPattern, email);   
   }
    
   public boolean validateName(String name){
      return validate(namePattern, name); 
   }       

   public boolean validatePassword(String password){
      return validate(passwordPattern, password); 
   }
   
   
   public boolean validateContactNumber(String phone){
      return validate(phonePattern, phone); 
   }
   
   public boolean failed() { return failed; }
   
   public void clear(HttpSession session){
       session.setAttribute("emailErr", "Enter email");
       session.setAttribute("passErr", "Enter password");
       session.setAttribute("existErr", "");
       session.setAttribute("nameErr", "Enter name");
   }
}
