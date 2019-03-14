package com.hexaware.FTP105.factory;

import com.hexaware.FTP105.persistence.VendorDAO;
import com.hexaware.FTP105.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP105.model.Vendor;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * Call the data base connection.
   * @param vUserName .
   * @param vPassword .
   * @return the array of menu object.
   */
  public static Vendor vLogin(final String vUserName, final String vPassword) {
    Vendor v = dao().showVLogin(vUserName, vPassword);
    if (v != null) {
      String username = v.getVUserName();
      String password = v.getVPassword();
      if (password.equals(vPassword) && username.equals(vUserName)) {
        System.out.println("Valid user");
        //int id = v.getVId();
        return v;
      } else {
        System.out.println("Invalid user");
        return null;
      }
    }
    return null;
  }
}
