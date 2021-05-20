/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 10/05/2021
 */
CREATE TABLE CUSTOMERS (
    "NAME" VARCHAR (50),
    "EMAIL" VARCHAR (50) NOT NULL,
    PASSWORD VARCHAR(20),
    DOB VARCHAR(10),
    
    PRIMARY KEY("EMAIL")
);

