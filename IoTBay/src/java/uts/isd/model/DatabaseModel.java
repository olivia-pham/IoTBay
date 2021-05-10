/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.util.ArrayList;

/**
 *
 * @author Junghyun
 */
public class DatabaseModel 
{
    //Customer
    String[] customerAttributes = new String[] {"customerId", "password", "dateOfBirth","userId"};
    ArrayList<String[]> customerList = new ArrayList<String[]>();
    
    //Staff
    String[] staffAttributes = new String[] {"staffId", "staffName", "emailAddress","password", "phoneNumber", "address", "dateOfBirth", "staffPosition", "InventoryID"};
    ArrayList<String[]> staffList = new ArrayList<String[]>();
    
    //User
    String[] userAttributes = new String[] {"userId", "userName", "emailAddress","password", "phoneNumber","address","creditCardNumber", "NameOnCreditCard","creditCardExpiryDate","CVV","staffId"};
    ArrayList<String[]> userList = new ArrayList<String[]>();
    
    //Product
    String[] productAttributes = new String[] {"productId", "productName", "productPrice","productDescription", "inventoryId"};
    ArrayList<String[]> productList = new ArrayList<String[]>();

    //Inventory
    String[] inventoryAttributes = new String[] {"inventoryId", "inventoryItems", "inventoryCapacity"};
    ArrayList<String[]> inventoryList = new ArrayList<String[]>();
    
    //Shopping Cart
    String[] shoppingCartAttributes = new String[] {"cartId", "quantity", "dateAdded","productId","userId"};
    ArrayList<String[]> shoppingCartList = new ArrayList<String[]>();
    
    //Order
    String[] orderAttributes = new String[] {"oderId", "dateCreated", "dateshipped","userName","status","userId","shipmentId"};
    ArrayList<String[]> orderList = new ArrayList<String[]>();
    
    //OderLineItem
    String[] orderLineItemAttributes = new String[] {"OrderId","productId", "productName","Quantitiy", "unitCost","subTotal"};
    ArrayList<String[]> orderLineItemList = new ArrayList<String[]>();
    
    
    //Shipment
    String[] shipmentAttributes = new String[] {"shipmentId", "shipmentType", "shipmentCost","shipemntRegion","deliveryTime"};
    ArrayList<String[]> shipmentList = new ArrayList<String[]>();

    //Payment
    String[] paymentAttributes = new String[] {"paymentId", "paymentDate", "paymentCost","paymentDescription","userId"};
    ArrayList<String[]> paymentList = new ArrayList<String[]>();
    
    //Invoice
    String[] invoiceAttributes = new String[] {"invocieId", "invoiceDate", "productPurchased","paymentCost","paymentId","userId"};
    ArrayList<String[]> invoiceList = new ArrayList<String[]>();
    
    public void addCustomer()
    {
        customerList.add(new String[] 
        {
            this.customerAttributes[0],this.customerAttributes[1],this.customerAttributes[2],this.customerAttributes[3]
        });
    }
    
    public void addStaff()
    {
        staffList.add(new String[]
        {
                this.staffAttributes[0],this.staffAttributes[1],this.staffAttributes[2],this.staffAttributes[3],this.staffAttributes[4],this.staffAttributes[5],this.staffAttributes[6],this.staffAttributes[7],this.staffAttributes[8]});
    }
    
    public void addUser()
    {
        userList.add(new String[]{
           this.userAttributes[0], this.userAttributes[1], this.userAttributes[2], this.userAttributes[3], this.userAttributes[4], this.userAttributes[5], this.userAttributes[6], this.userAttributes[7], this.userAttributes[8], this.userAttributes[9], this.userAttributes[9], this.userAttributes[10], this.userAttributes[11]
        });
    }
    
    public void addProduct()
    {
        productList.add(new String[]
        {
            this.productAttributes[0], this.productAttributes[1], this.productAttributes[2], this.productAttributes[3], this.productAttributes[4]
        });
    }

    public void addInventory()
    {
        inventoryList.add(new String[]
        {
            this.inventoryAttributes[0],this.inventoryAttributes[1],this.inventoryAttributes[2]
        });
        
    }
    
    public void addShoppingCart()
    {
        shoppingCartList.add(new String[]
        {        
            this.shoppingCartAttributes[0], this.shoppingCartAttributes[1], this.shoppingCartAttributes[2], this.shoppingCartAttributes[3], this.shoppingCartAttributes[4]
        });
    }
    
    
    public void addOrder()
    {
        orderList.add(new String[]
        {
            this.orderAttributes[0], this.orderAttributes[1], this.orderAttributes[2], this.orderAttributes[3], this.orderAttributes[4], this.orderAttributes[5], this.orderAttributes[6]
            
        });
    }
    
    public void addOrderLineItem()
    {
        orderLineItemList.add(new String[]
        {
            this.orderLineItemAttributes[0], this.orderLineItemAttributes[1],this.orderLineItemAttributes[2],this.orderLineItemAttributes[3],this.orderLineItemAttributes[4],this.orderLineItemAttributes[5]
        });
    }
    
    public void addShipment()
    {
        shipmentList.add(new String[]
        {
            this.shipmentAttributes[0], this.shipmentAttributes[1], this.shipmentAttributes[2], this.shipmentAttributes[3] ,this.shipmentAttributes[4] 
        });
    }
    
    public void addPayment()
    {
        paymentList.add(new String[]
        {
            this.paymentAttributes[0], this.paymentAttributes[1], this.paymentAttributes[2], this.paymentAttributes[3], this.paymentAttributes[4]
        });
    }
    
    public void addInvoice()
    {
        invoiceList.add(new String[]
        {
            this.invoiceAttributes[0], this.invoiceAttributes[1], this.invoiceAttributes[2], this.invoiceAttributes[3], this.invoiceAttributes[4], this.invoiceAttributes[5]
        });
    }
}
