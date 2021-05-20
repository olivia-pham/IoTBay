/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivi
 * Created: 19/05/2021
 */

ALTER TABLE ORDERS
ADD FOREIGN KEY (USER_EMAIL)
REFERENCES USERS (EMAIL);

ALTER TABLE ORDER_LINE
ADD FOREIGN KEY (ORDER_ID)
REFERENCES ORDERS (ID);

ALTER TABLE ORDER_LINE
ADD FOREIGN KEY (PRODUCT_ID)
REFERENCES PRODUCTS (ID);
