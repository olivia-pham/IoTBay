/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  olivi
 * Created: 19/05/2021
 */

INSERT INTO ORDERS (ID, USER_EMAIL, TOTAL, STATUS, CREATED_DATE, MODIFIED_DATE)
VALUES (1, 'a@gmail.com', 30.00, 'Pending', '2008-11-11', '2008-11-11')
;

INSERT INTO ORDER_LINE (ID, ORDER_ID, QUANTITY, PRODUCT_ID, PRICE)
VALUES (1, 2, 1, 1, 10.00),
       (1, 1, 2, 2, 10.00)
;

