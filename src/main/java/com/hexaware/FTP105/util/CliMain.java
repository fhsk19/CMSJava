package com.hexaware.FTP105.util;

import java.time.LocalDateTime;
import java.util.Scanner;
import com.hexaware.FTP105.model.Vendor;
import com.hexaware.FTP105.factory.CustomerFactory;
import com.hexaware.FTP105.factory.MenuFactory;
import com.hexaware.FTP105.factory.OrdersFactory;
import com.hexaware.FTP105.factory.VendorFactory;
import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.model.Orders;
import com.hexaware.FTP105.model.Customer;
/**
 * CliMain used as Client interface for java coding.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Food Menu");
    System.out.println("2. Show Customer Dashboard");
    System.out.println("3. Show Vendor Dashboard");
    System.out.println("4. Exit");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    System.out.println("Enter your choice:");
    int orderOption = option.nextInt();
    switch (orderOption) {
      case 1:
        showFullMenu();
        break;
      case 2:
        showCDashboard();
        break;
      case 3:
        showVDashboard();
        break;
      case 4:
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose from 1 to 4");
    }
    System.out.println("Enter a valid value");
    option.nextLine();
    mainMenu();
  }

  private Object showCDashboard() {
    System.out.println("Customer Dashboard");
    System.out.println("-----------------------");
    System.out.println("1. Customer Login:");
    System.out.println("2. Exit");
    System.out.println("Enter your choice:");
    int orderOption = option.nextInt();
    switch (orderOption) {
      case 1:
        cLogin();
        break;
      case 2:
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose from 1 to 2");
    }
    System.out.println("Enter valid value");
    option.nextLine();
    return showCDashboard();
  }
  private void cLogin() throws NullPointerException {
    System.out.println("Welcome to Customer Login");
    Scanner scb = new Scanner(System.in);
    System.out.println("Customer Username:");
    String cUserName = scb.next();
    System.out.println("Customer Password:");
    String cPassword = scb.next();
    try {
      Customer cid = CustomerFactory.cLogin(cUserName, cPassword);
      cid.getCId();
    } catch (NullPointerException e) {
      System.out.println("Enter valid credentials");
      showCDashboard();
    }
    cDes(getB());
  }
  private void cDes(final int cid) {

    System.out.println("Select an option from below:");
    System.out.println("1. View Customer History");
    System.out.println("2. Place Order");
    System.out.println("3. Wallet info");
    System.out.println("4. Exit");
    System.out.println("Enter your choice:");
    final int orderOption = option.nextInt();
    if (orderOption > 0 && orderOption < 5) {
      switch (orderOption) {
        case 1:
          customerhistory(cid);
          break;
        case 2:
          placeOrders();
          break;
        case 3:
          walletInfo(cid);
          break;
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose from 1 to 3");
      }
      System.out.println("Enter a valid value");
      cDes(cid);
      option.nextLine();
    } else {
      System.out.println("Choose from 1 to 3");
      cDes(cid);
    }
  }
  private void walletInfo(final int cid) {
    CustomerFactory.getWalletValue(cid);
    cDes(cid);
  }

  private Object showVDashboard() {
    System.out.println("Vendor Dashboard");
    System.out.println("-----------------------");
    System.out.println("1. Vendor Login:");
    System.out.println("2. Exit");
    System.out.println("Enter your choice:");
    int orderOption = option.nextInt();
    switch (orderOption) {
      case 1:
        vLogin();
        break;
      case 2:
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose from 1 to 2");
    }
    option.nextLine();
    return showVDashboard();
  }
  private void vLogin() throws NullPointerException {
    System.out.println("Welcome to Vendor Login");
    Scanner scv = new Scanner(System.in);
    System.out.println("Vendor Username:");
    String vUserName = scv.next();
    System.out.println("Vendor Password:");
    String vPassword = scv.next();
    try {
      Vendor v = VendorFactory.vLogin(vUserName, vPassword);
      v.getVId();
    } catch (NullPointerException e) {
      System.out.println("Enter valid credentials");
      showVDashboard();
    }
    vDes(getC());
  }

  private void vDes(final int vid) {
    System.out.println("Select an option from below:");
    System.out.println("1. View Vendor History");
    System.out.println("2. Accept/ Reject Order");
    System.out.println("3. Exit");

    System.out.println("Enter your choice:");
    int orderOption = option.nextInt();
    if (orderOption > 0 && orderOption < 4) {
      switch (orderOption) {
        case 1:
          vendorhistory(vid);
          break;
        case 2:
          orderStatus(vid);
          break;
        case 3:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose from 1 to 3");
      }
      System.out.println("Enter a valid value");
      showVDashboard();
      option.nextLine();
    } else {
      System.out.println("Choose from 1 to 4");
      vDes(vid);
    }
  }

  private void orderStatus(final Integer vid) {
    System.out.println("Order status:");
    System.out.println("O_ID \tC_ID\tFood_Id\tQty\tPrice\tStatus");
    String ostatus = "PLACED";
    Orders[] orders = OrdersFactory.orderStatus1(vid, ostatus);
    for (Orders o: orders) {
      System.out.println(o.getOId() + "\t" + o.getCId() + "\t" + o.getFoodId() + "\t" + o.getQty() + "\t" + o.getTotalPrice() + "\t" + o.getOStatus());
    }
    System.out.println("Enter OID: ");
    Scanner sc = new Scanner(System.in);
    int oid = sc.nextInt();
    boolean oidAvailable = false;
    for (Orders o: orders) {
      if (oid == o.getOId()) {
        oidAvailable = true;
      }
    }
    if (!oidAvailable) {
      System.out.println("Invalid order id");
      orderStatus(vid);
    }

    System.out.println("ACCEPT/DENY");
    String ordstatus = sc.next();
    System.out.println(ordstatus);
    if (ordstatus.equals("ACCEPT")) {
      ordstatus = "DELIVERED";
      OrdersFactory.updateStatus(ordstatus, oid);
    } else if (ordstatus.equals("DENY")) {
      ordstatus = "CANCELLED";
      OrdersFactory.updateStatus(ordstatus, oid);
      try {
        System.out.println("Select the reason:\n 1. The food is unavailable!\n 2. Entered quantity for food item not available!\n 3. Closed for the day!");
        int orderOption = option.nextInt();
        switch (orderOption) {
          case 1:
            System.out.println("The food is unavailable!");
            String com = "The food is unavailable!";
            OrdersFactory.updateCom(com, oid);
            break;
          case 2:
            System.out.println("Entered quantity for food item not available!");
            String com1 = "Food Quantity Limited!";
            OrdersFactory.updateCom(com1, oid);
            break;
          case 3:
            System.out.println("Closed for the day!");
            String com2 = "Closed for the day!";
            OrdersFactory.updateCom(com2, oid);
            break;
          default:
            System.out.println("Choose from 1 to 3");
        }
      } catch (Exception e) {
        System.out.println("Enter a valid value");
        orderStatus(vid);
      }
      CustomerFactory.revertBal(oid);
    } else {
      System.out.println("Enter a valid value!");
      orderStatus(vid);
    }
    vDes(vid);
  }
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("Food_Id  V_Id \tFood_Name\tPrice\tFood_Category\tFood_Description");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getVId() + "\t" +  m.getFoodName()
          + "\t\t" + m.getPrice() + "\t" + m.getFoodCategory() + "\t" + m.getFoodDescription());
    }
  }
  private void placeOrders() {
    showFullMenu();
    System.out.println("Enter Food_Id");
    int foodId = option.nextInt();
    boolean fidAvailable = false;
    Menu[] menu = MenuFactory.showMenu();
    for (Menu  mId: menu) {
      if (foodId == mId.getFoodId()) {
        //int vid = mId.getVId();
        fidAvailable = true;
      }
    }
    if (!fidAvailable) {
      System.out.println("Invalid FOOD Id");
      return;
    }
    int cid = getB();
    String retMsg = "";
    System.out.println("Enter the quantity: ");
    int qty = option.nextInt();
    if (qty < 1) {
      System.out.println("Enter a valid quantity");
    } else {
      LocalDateTime date = LocalDateTime.now();
      retMsg = CustomerFactory.placeOrder(cid, foodId, qty, date);
    }
    System.out.println(retMsg);
    cDes(cid);
  }

  private void vendorhistory(final Integer vid) {
    System.out.println("The Vendor History is: ");
    System.out.println("O_ID \tC_ID\tFood_Id\tQty\tPrice\tStatus");
    Orders[] order = OrdersFactory.vHis(vid);
    for (Orders o : order) {
      System.out.println(o.getOId() + "\t" + o.getCId() + "\t" + o.getFoodId() + "\t" + o.getQty() + "\t" + o.getTotalPrice() + "\t" + o.getOStatus());
    } vDes(vid);
  }

  private void customerhistory(final Integer cid) {
    System.out.println("The Customer History is: ");
    System.out.println("V_Id \tO_Id\tFood_Id\tQuantity\tPrice\tStatus");
    Orders[] order = OrdersFactory.cHis(cid);
    for (Orders o : order) {
      System.out.println(o.getVId() + "\t" + o.getOId() + "\t" + o.getFoodId() + "\t" + o.getQty() + "\t\t" + o.getTotalPrice() + "\t" + o.getOStatus());
    } cDes(cid);
  }

/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }

  private int b;
  private int c;
    /**
   * @return the b
   */
  public final Integer getB() {
    return b;
  }

  /**
   * @param argsB the b to set
   */
  public final void setB(final Integer argsB) {
    this.b = argsB;
  }

    /**
   * @return the c
   */
  public final Integer getC() {
    return c;
  }
    /**
   * @param argsC the b to set
   */
  public void setC(final Integer argsC) {
    this.c = argsC;
  }
  /**
   * @return the option
   */
  public final Scanner getOption() {
    return option;
  }

  /**
   * @param argsOption the option to set
   */
  public final void setOption(final Scanner argsOption) {
    this.option = argsOption;
  }
}
