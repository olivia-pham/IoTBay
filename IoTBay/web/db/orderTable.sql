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
    "ID" INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "USER_EMAIL"   VARCHAR(50) REFERENCES USERS (EMAIL) ON DELETE CASCADE,
    "ORDER_DATE"   VARCHAR(10),
    "TOTAL" DOUBLE,
    "SHIPPING_ADDRESS"  VARCHAR(255),
    "TRACKING_ID"   VARCHAR(30)
    
);