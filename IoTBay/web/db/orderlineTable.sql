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
    "ID" INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    "ORDER_ID" INTEGER NOT NULL,
    "QUANTITY" INT, 
    "PRODUCT_ID" INTEGER NOT NULL,
    "PRODUCT_NAME" VARCHAR(50),
    "TOTAL_PRICE" DOUBLE,
    "PRICE" DOUBLE
);
