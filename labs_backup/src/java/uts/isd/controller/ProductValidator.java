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
 * @author User
 */
public class ProductValidator implements Serializable{
     
   //private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   //private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   //private String passwordPattern = "[0-9]*";  
    private String idPattern = "[0-9]*"; 
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";;
    private String pricePattern = "([0-9]*)(.)([0-9]*)";;
    private String descPattern;
    private String quantPattern = "[0-9]*"; ;
    private String typePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";;
              
   public ProductValidator(){    
   }       

   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }      
   
   public boolean validateId(String id){                       
      return validate(idPattern, id);   
   }
    
   public boolean validateName(String name){
      return validate(namePattern, name); 
   }       

   public boolean validatePrice(String price){
      return validate(pricePattern, price); 
   }
   
   public boolean validateQuant(String quant){
      return validate(quantPattern, quant); 
   }
    
   public boolean validatePassword(String type){
      return validate(typePattern, type); 
   }
   
   public void clear(HttpSession session){
       //session.setAttribute("emailErr", "Enter email");
       //session.setAttribute("passErr", "Enter password");
       //session.setAttribute("existErr", "");
       //session.setAttribute("nameErr", "Enter name");
   }
    
}
