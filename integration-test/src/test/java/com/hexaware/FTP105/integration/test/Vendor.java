package com.hexaware.FTP105.model;
import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Vendor {
/**
 * foodId to store vendorId.
 */
  private int vId;
  /**
 * foodId to store vendorname.
 */
  private String vName;
  /**
 * foodId to store vusername.
 */
  private String vUserName;
  /**
 * foodId to store vendorpassword.
 */
  private String vPassword;
  /**
 * foodId to store vendorphoneno.
 */
  private String vPhone;
  /**
   * Default Constructor.
   */
  public Vendor() {

  }
/**
 * @param argVId to initialize food id.
 * @param argVName to initialize VName.
 * @param argVUserName to initialize VUserName.
 * @param argVPassword to initialize VPassword.
 * @param argVPhone to initialize VPhone.
 * used to get details through constructor.
 */
  public Vendor(final int argVId, final String argVName, final String argVUserName, final String argVPassword, final String argVPhone) {
    this.vId = argVId;
    this.vName = argVName;
    this.vUserName = argVUserName;
    this.vPassword = argVPassword;
    this.vPhone = argVPhone;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vend = (Vendor) obj;
    if (Objects.equals(vId, vend.vId) && Objects.equals(vName, vend.vName) && Objects.equals(vUserName, vend.vUserName)
        && Objects.equals(vPassword, vend.vPassword) && Objects.equals(vPhone, vend.vPhone)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(vId, vName, vUserName, vPassword, vPhone);
  }
  /**
     * @return this food ID.
     */
  public final int getVId() {
    return vId;
  }
  /**
     * @param argVId gets the food id.
     */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
  /**
     * @return this food ID.
     */
  public final String getVName() {
    return vName;
  }
  /**
     * @param argVName gets the food id.
     */
  public final void setVName(final String argVName) {
    this.vName = argVName;
  }
  /**
     * @return this food ID.
     */
  public final String getVUserName() {
    return  vUserName;
  }
  /**
     * @param argVUserName gets the food id.
     */
  public final void setVUserName(final String argVUserName) {
    this.vUserName = argVUserName;
  }
  /**
     * @param argVPassword gets the food id.
     */
  public final void setVPassword(final String argVPassword) {
    this.vPassword = argVPassword;
  }
   /**
     * @return this food ID.
     */
  public final String getVPassword() {
    return  vPassword;
  }
  /**
     * @param argVPhone gets the food id.
     */
  public final void setVPhone(final String argVPhone) {
    this.vPhone = argVPhone;
  }
   /**
     * @return this food ID.
     */
  public final String getVPhone() {
    return  vPhone;
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */

  @Override public final String toString() {
    return String.format(this.vId + "\t" + this.vName
        + "\t" + this.vUserName + "\t" + this.vPassword + "\t" + this.vPhone);
  }
}
