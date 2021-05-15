/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivi
 * Created: 15/05/2021
 */
CREATE TABLE ORDER_LINE
(
    "ORDER_ID"  INT REFERENCES ORDERS (ID) ON DELETE CASCADE,
    "PRODUCT_ID"    INT REFERENCES PRODUCTS (ID) ON DELETE CASCADE,
    "QUANTITY_ORDERED"  INT,
    "PRICE" DOUBLE,
    PRIMARY KEY (ORDER_ID, PRODUCT_ID)
);
