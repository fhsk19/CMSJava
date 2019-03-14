package com.hexaware.FTP105.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Time;
/**
  * Orders class used to display menu information.
  * @author hexware
**/
public class Orders {
/**
  * order Id to store Id.
  * food Id to store Id
  * customer Id to store Id
  * quatity to store quantity
  * order status to store order Status
  * total price to store total Price
  * estimated time to store estimated time
  * order time to store time of order
  * vendor id to store Id
  * order date to store date
  * @param argOId to initialize order id.
  * @param argFoodId to store Id
  * @param argCustomerId to store Id
  * @param argQty to store quantity
  * @param argoStatus to store order Status
  * @param argTotalPrice to store total Price
  * @param argEstimatedTime to store estimated time
  * @param argOrderTime to store time of order
  * @param VId to store Id
  * @param OrderDate to store date
  * @param oComment to comment.
  * used to get details through constructor
**/
  @JsonProperty("oid")
  private int oId;
  @JsonProperty("cid")
  private int cId;
  private int foodId;
  private int qty;
  private float totalPrice;
  private Time estimatedTime;
  private Time orderTime;

  @JsonProperty("vid")
  private int vId;
  private Date orderDate;

  @JsonProperty("ostatus")
  private OStatus oStatus;

  @JsonProperty("ocomment")
  private String oComment;
  /**
    * Default Constructor.
  **/
  public Orders() {
  }
/**
  * @param argOId to initialize order id.
  * @param argFoodId to store Id.
  * @param argCId to store Id.
  * @param argQty to store quantity.
  * @param argTotalPrice to store total Price.
  * @param argEstimatedTime to store estimated time.
  * @param argOrderTime to store time of order.
  * @param argVId to store Id.
  * @param argOrderDate to store date.
  * @param argOStatus to store order Status.
  * @param argOComment to store comment.
  * used to get details through constructor.
  */
  public  Orders(final int argOId, final int argCId, final int argFoodId, final int argQty,
      final float argTotalPrice, final Time argEstimatedTime,
      final Time argOrderTime, final int argVId, final Date argOrderDate, final OStatus argOStatus, final String argOComment) {
    this.oId = argOId;
    this.cId = argCId;
    this.foodId = argFoodId;
    this.qty = argQty;
    this.totalPrice = argTotalPrice;
    this.estimatedTime = argEstimatedTime;
    this.orderTime = argOrderTime;
    this.vId = argVId;
    this.orderDate = (Date) argOrderDate.clone();
    this.oStatus = argOStatus;
    this.oComment = argOComment;
  }

  @Override
      public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(oId, orders.oId)
        && Objects.equals(cId, orders.cId)
        && Objects.equals(foodId, orders.foodId)
        && Objects.equals(totalPrice, orders.totalPrice)
        && Objects.equals(estimatedTime, orders.estimatedTime)
        && Objects.equals(orderTime, orders.orderTime)
        && Objects.equals(vId, orders.vId)
        && Objects.equals(orderDate, orders.orderDate)
        && Objects.equals(oStatus, orders.oStatus)
        && Objects.equals(oComment, orders.oComment)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(oId, cId, foodId,
    totalPrice, estimatedTime, orderTime, vId, orderDate, oStatus, oComment);
  }
    /**
     * @return this Order ID.
    **/
  public final int getOId() {
    return oId;
  }
  /**
    * @return this Customer ID.
  **/
  public final int getCId() {
    return cId;
  }
  /**
    * @return this food ID.
  **/
  public final int getFoodId() {
    return foodId;
  }
  /**
    * @return this quantity.
  **/
  public final int getQty() {
    return qty;
  }
  /**
    * @return this total price.
  **/
  public final float getTotalPrice() {
    return totalPrice;
  }
  /**
    * @return this estimated time.
  **/
  public final Time getEstimatedTime() {
    return estimatedTime;
  }
  /**
    * @return this order time.
  **/
  public final Time getOrderTime() {
    return orderTime;
  }
  /**
    * @return this food ID.
  **/
  public final int getVId() {
    return vId;
  }
  /**
    * @return this food ID.
  **/
  public final Date getOrderDate() {
    return (Date) orderDate.clone();
  }
  /**
    * @return this order status.
  **/
  public final OStatus getOStatus() {
    return oStatus;
  }
  /**
    * @return this order status.
 **/
  public final String getOComment() {
    return oComment;
  }
  /**
    * @param argOId gets the Order id.
  **/
  public final void setOId(final int argOId) {
    this.oId = argOId;
  }
  /**
    * @param argCId gets the Customer id.
  **/
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }
  /**
    * @param argFoodId gets the Food id.
  **/
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
    * @param argQty gets the Quantity.
  **/
  public final void setQty(final int argQty) {
    this.qty = argQty;
  }
  /**
    * @param argTotalPrice gets the Total price.
  **/
  public final void setTotalPrice(final float argTotalPrice) {
    this.totalPrice = argTotalPrice;
  }
  /**
    * @param argEstimatedTime gets the Estimated time.
   */
  public final void setEstimatedTime(final Time argEstimatedTime) {
    this.estimatedTime = argEstimatedTime;
  }
  /**
    * @param argOrderTime gets the Order time.
  **/
  public final void setOrderTime(final Time argOrderTime) {
    this.orderTime = argOrderTime;
  }
  /**
    * @param argVId gets the Vendor id.
  **/
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
  /**
    * @param argOrderDate gets the Order date.
  **/
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = (Date) argOrderDate.clone();
  }
  /**
    * @param argOStatus gets the Order status.
   */
  public final void setOStatus(final OStatus argOStatus) {
    this.oStatus =  argOStatus;
  }

  /**
    * @param argOComment gets the Comment.
   */
  public final void setOComment(final String argOComment) {
    this.oComment =  argOComment;
  }

  @Override public final String toString() {
    return String.format(this.oId + "\t" + this.cId + "\t" + this.foodId + "\t" + this.qty + "\t" + this.totalPrice + "\t"
     + this.estimatedTime + "\t" + this.orderTime + "\t" + this.vId + "\t" + this.orderDate + "\t" + this.oComment);
  }
}



