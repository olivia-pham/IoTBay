/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 10/05/2021
 */

CREATE TABLE PRODUCTS (
    "ID" INT NOT NULL,
    "NAME" VARCHAR (50),
    PRICE DECIMAL (4, 2),
    DESCRIPTION VARCHAR(255),
    "QUANTITY" INT,
    "TYPE" VARCHAR(50),
    
    PRIMARY KEY("ID")
);
