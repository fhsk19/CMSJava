package com.hexaware.FTP105.factory;

import com.hexaware.FTP105.persistence.CustomerDAO;
import com.hexaware.FTP105.persistence.DbConnection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import com.hexaware.FTP105.model.Customer;
import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.model.Orders;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
/**
   * Call the data base connection.
   * @return the array of menu object.
  */
  public static Customer[] showCustomer1() {
    List<Customer> cust = dao().show();
    return cust.toArray(new Customer[cust.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   * @param cId for Customer id.
   */
  public static Customer[] showCustomer(final int cId) {
    List<Customer> cust = dao().showC(cId);
    return cust.toArray(new Customer[cust.size()]);
  }


  /**
   * Call the data base connection.
   * @param foodId returns foodId.
   * @param cId returns cId.
   * @param qty returns quantity.
   * @param date returns Date.
   * @return the array of customer object.
   */
  public static String placeOrder(final Integer cId, final int foodId, final int qty, final LocalDateTime date) {
    String msg = "Order Not Placed";
    if (qty > 0) {
      Menu menu = MenuFactory.getSingleMenu(foodId);
      if (menu != null) {
        int vId = menu.getVId();
        float price = menu.getPrice();
        float totalPrice = price * qty;
        Customer c = dao().getWallet(cId);
        float bal = c.getWallet();
        Random rand = new Random();
        int value = rand.nextInt(200);
        if (bal < totalPrice) {
          msg  = "Insufficient balance: " + bal;
          return msg;
        } else {
          bal = bal - totalPrice;
          int ret = OrdersFactory.orderQuery(foodId, vId, cId, qty, totalPrice, date);
          if (ret > 0) {
            System.out.println("Remaining balance:" + bal);
            System.out.println("Your token number is:" + value);
            int uw = dao().updateWallet(cId, bal);
            if (uw > 0) {
              msg = "Order Placed";
            }
          }
          return msg;
        }
      }
    }
    return msg;
  }
  /**
   * Call the data base connection.
   * @param cUserName customer username.
   * @param cPassword customer password.
   * @return the array of customer object.
   */
  public static Customer cLogin(final String cUserName, final String cPassword) {
    Customer c = dao().showCLogin(cUserName, cPassword);
    if (c != null) {
      String username = c.getCUserName();
      String password = c.getCPassword();
      if (password.equals(cPassword) && username.equals(cUserName)) {
        System.out.println("Valid user");
        //int id = c.getCId();
        return c;
      } else {
        System.out.println("Invalid user");
        return null;
      }
    }
    return null;
  }

  /**
  * @param oid for order oid.
 * @return i .
  */
  public static int revertBal(final int oid) {
    Orders o = dao().getdet(oid);
    float tp = o.getTotalPrice();
    int cId = o.getCId();
    Customer c = dao().getWallet(cId);
    float bal = c.getWallet();
    bal = bal + tp;
    System.out.println("Updated balance:" + bal);
    int i = dao().updateWallet(cId, bal);
    return i;
  }
/**
  * @param cid for order oid.
  * @return getWallet for return.
  */
  public static float getWalletValue(final int cid) {
    Customer c = dao().getWallet(cid);
    float val = c.getWallet();
    System.out.println("Your wallet balance is: " + val);
    return c.getWallet();
  }
}
