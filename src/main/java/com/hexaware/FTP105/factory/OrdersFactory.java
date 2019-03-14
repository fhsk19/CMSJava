package com.hexaware.FTP105.factory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hexaware.FTP105.model.OStatus;
import com.hexaware.FTP105.model.Orders;
import com.hexaware.FTP105.persistence.DbConnection;
import com.hexaware.FTP105.persistence.OrdersDAO;

/**
 * MenuFactory class used to fetch menu data from database.
 *
 * @author hexware
 */
public class OrdersFactory {
  /**
   * Protected constructor.
   */
  protected OrdersFactory() {

  }

  /**
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().show();
    return orders.toArray(new Orders[orders.size()]);
  }
  /**
   * Call the data base connection.
   * @return the orders.
   * @param fId returns foodId.
   * @param vId returns quantity.
   * @param cId returns quantity.
   * @param qty returns quantity.
   * @param totalPrice returns totalprice.
   * @param date returns LocalDate.
   */
  public static int orderQuery(final int fId, final int vId, final int cId, final int qty,
        final float totalPrice, final LocalDateTime date) {
    OStatus o = OStatus.valueOf("PLACED");
    DateTimeFormatter tf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String od = date.format(tf3);

    DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
    String ot1 = date.format(tf1);

    OrdersDAO dao = dao();
    int ret = dao.insertQuery(cId, fId, qty, o.name(), totalPrice, ot1, ot1, vId, od);
    return ret;
  }
/**
   * Call the data base connection.
   * @param b returns oId.
   * @param ordStatus returns cId.
   * @return returns true.
   */
  public static int updateStatus(final String ordStatus, final int b) {
    dao().showUpdateStatus(ordStatus, b);
    return 1;
  }
/**
  * Call the data base connection.
  * @param oid returns cId.
  * @return the connection object.
  *  @param ostatus returns cId.
  */
  public static Orders[] orderStatus1(final int oid, final String ostatus) {
    List<Orders> orders = dao().showOrderStatus(oid, ostatus);
    return orders.toArray(new Orders[orders.size()]);
  }
/**
  * Call the data base connection.
  * @param vid returns vid.
  * @return the connection object.
  */
  public static Orders[] vHis(final int vid) {
    int c = vid;
    List<Orders> order = dao().showVHis(c);
    return order.toArray(new Orders[order.size()]);
  }
/**
  * Call the data base connection.
  * @param cid returns cid.
  * @return the connection object.
  */
  public static Orders[] cHis(final int cid) {
    int c = cid;
    List<Orders> order = dao().showCHis(c);
    return order.toArray(new Orders[order.size()]);
  }
/**
  * Call the data base connection.
  * @param comment returns comment.
  * @param oid returns comment.
  * @return returns true.
  */
  public static int updateCom(final String comment, final int oid) {
    dao().updateCom(comment, oid);
    return 1;
  }
/**
  * Call the data base connection.
  * @param foodId returns comment.
  * @return the objects.
  */
  public static Orders[] fId(final int foodId) {
    List<Orders> orders = dao().showFId(foodId);
    return orders.toArray(new Orders[orders.size()]);
  }
/**
  * Call the data base connection.
  * @param vid returns vid.
  * @return the connection object.
  */
  public static Orders[] pHis(final int vid) {
    int c = vid;
    List<Orders> order = dao().showPHis(c);
    return order.toArray(new Orders[order.size()]);
  }
}
