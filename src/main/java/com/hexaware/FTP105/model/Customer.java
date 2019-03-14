package com.hexaware.FTP105.model;
//import com.hexaware.FTP105.persistence.DbConnection;
//import com.hexaware.FTP105.persistence.CustomerDAO;
import java.util.Objects;
//import java.util.List;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Customer {
/**
 * foodId to store foodId.
 */
  private int cId;
  private String cName;
  private Float wallet;
  private String cUserName;
  private String cPassword;
  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argCId to initialize food id.
 * @param argCName to initialize food id.
 * @param argWallet to initialize food id.
 * @param argCUserName to initialize food id.
 * @param argCPassword to initialize food id.
 * used to get details through constructor.
 */
  public Customer(final int argCId, final String argCName, final Float argWallet, final String argCUserName, final String argCPassword) {
    this.cId = argCId;
    this.cName = argCName;
    this.wallet = argWallet;
    this.cUserName = argCUserName;
    this.cPassword = argCPassword;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer cust = (Customer) obj;
    if (Objects.equals(cId, cust.cId) && Objects.equals(cName, cust.cName) && Objects.equals(wallet, cust.wallet)
        && Objects.equals(cUserName, cust.cUserName) && Objects.equals(cPassword, cust.cPassword)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cId, cName, wallet, cUserName, cPassword);
  }
    /**
     * @return  this food ID.
     */
  public final int getCId() {
    return cId;
  }
   /**
     * @return  this food ID.
     */
  public final String getCName() {
    return cName;
  }
   /**
     * @return  this food ID.
     */
  public final Float getWallet() {
    return wallet;
  }
   /**
     * @return  this food ID.
     */
  public final String getCUserName() {
    return cUserName;
  }
   /**
     * @return  this food ID.
     */
  public final String getCPassword() {
    return cPassword;
  }
    /**
     * @param argCId gets the customer id.
     */
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }
  /**
     * @param argCName gets the customer id.
     */
  public final void setCName(final String argCName) {
    this.cName = argCName;
  }
  /**
     * @param argWallet gets the customer id.
     */
  public final void setWallet(final float argWallet) {
    this.wallet = argWallet;
  }
  /**
     * @param argCUserName gets the customer id.
     */
  public final void setcUserName(final String argCUserName) {
    this.cUserName = argCUserName;
  }
  /**
     * @param argCPassword gets the customer id.
     */
  public final void setcPassword(final String argCPassword) {
    this.cPassword = argCPassword;
  }

  @Override public final String toString() {
    return String.format(this.cId + "\t" + this.cName + "\t" + this.wallet
        + "\t" + this.cUserName + "\t" + this.cPassword);
  }
}
