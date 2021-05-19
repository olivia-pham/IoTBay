/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivi
 * Created: 15/05/2021
 */

CREATE TABLE ORDERS
(
    "ID" INT NOT NULL,
    "USER_EMAIL"   VARCHAR(50),
    "TOTAL" DOUBLE,
    "STATUS" VARCHAR(10),
    "CREATED_DATE" TIMESTAMP NOT NULL,
    "MODIFIED_DATE" TIMESTAMP,
    PRIMARY KEY("ID")
);


