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
    "CUSTOMER_EMAIL"   VARCHAR(50) REFERENCES CUSTOMERS (EMAIL) ON DELETE CASCADE,
    "SHIPPING_ADDRESS"  VARCHAR(255),
    "TOTAL" DOUBLE,
    "STATUS"    VARCHAR(30),
    "TRACKING_ID"   VARCHAR(30),
    "SHIPMENT_ID"   VARCHAR(30)
);