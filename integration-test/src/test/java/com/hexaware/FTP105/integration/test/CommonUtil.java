package com.hexaware.FTP105.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP105");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

/**
 * Menu class used to display menu information.
 * @author hexware
 */
    class Vendor {
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




    class Menu {
        /**
         * foodId to store foodId.
         */
          private int foodId;
          private int vId;
          private String foodName;
          private Float price;
          private String foodCategory;
          private String foodDescription;
        /**
         * Default Constructor.
         */
          public Menu() {
        
          }
        /**
         * @param argFoodId to initialize FoodId.
         * used to get details through constructor.
         * @param argVId to initialize VId.
         * used to get details through constructor.
         * @param argFoodName to initialize FoodName.
         * used to get details through constructor.
         * @param argPrice to initialize gPrice.
         * used to get details through constructor.
         * @param argFoodCategory to initialize argFoodCategory.
         * used to get details through constructor.
         * @param argFoodDescription to initialize FoodDescription.
         * used to get details through constructor.
         */
          public Menu(final int argFoodId, final int argVId,
              final String argFoodName, final Float argPrice, final String argFoodCategory,
              final String argFoodDescription) {
            this.foodId = argFoodId;
            this.vId = argVId;
            this.foodName = argFoodName;
            this.price = argPrice;
            this.foodCategory = argFoodCategory;
            this.foodDescription = argFoodDescription;
          }
          @Override
          public final boolean equals(final Object obj) {
            if (obj == null) {
              return false;
            }
            if (getClass() != obj.getClass()) {
              return false;
            }
            Menu menu = (Menu) obj;
            if (Objects.equals(foodId, menu.foodId)
                && Objects.equals(vId, menu.vId)
                && Objects.equals(foodName, menu.foodName)
                && Objects.equals(price, menu.price)
                && Objects.equals(foodCategory, menu.foodCategory)
                && Objects.equals(foodDescription, menu.foodDescription)) {
              return true;
            }
            return false;
          }
          @Override
          public final int hashCode() {
            return Objects.hash(foodId, vId, foodName, price, foodCategory, foodDescription);
          }
        /**
         * @return this food ID.
         */
          public final int getFoodId() {
            return foodId;
          }
        /**
         * @return this V ID.
         */
          public final int getVId() {
            return vId;
          }
        /**
         * @return this FoodName.
         */
          public final String getFoodName() {
            return foodName;
          }
        /**
         * @return this Price.
         */
          public final Float getPrice() {
            return price;
          }
        /**
         * @return this FoodCategory.
         */
          public final String getFoodCategory() {
            return foodCategory;
          }
        /**
         * @return this FoodDescription.
         */
          public final String getFoodDescription() {
            return foodDescription;
          }
        /**
         * @param argFoodId gets the food id.
         */
          public final void setFoodId(final int argFoodId) {
            this.foodId = argFoodId;
          }
        /**
         * @param argVId gets the food id.
         */
          public final void setVId(final int argVId) {
            this.vId = argVId;
          }
        /**
         * @param argFoodName gets the food id.
         */
          public final void setFoodName(final String argFoodName) {
            this.foodName = argFoodName;
          }
        /**
         * @param argPrice gets the food id.
         */
          public final void setPrice(final Float argPrice) {
            this.price = argPrice;
          }
        /**
         * @param argFoodCategory gets the food id.
         */
          public final void setFoodCategory(final String argFoodCategory) {
            this.foodCategory = argFoodCategory;
          }
        /**
         * @param argFoodDescription gets the food id.
         */
          public final void setFoodDescription(final String argFoodDescription) {
            this.foodDescription = argFoodDescription;
          }
          @Override public final String toString() {
            return String.format(this.foodId + "\t" + this.vId + "\t" + this.foodName
                + "\t" + this.price + "\t" + this.foodCategory + "\t" + this.foodDescription);
          }
        }







/**
  * Orders class used to display menu information.
  * @author hexware
 * @param <OStatus>
**/
 class Orders<OStatus> {
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
    
/**
 * Menu class used to display menu information.
 * @author hexware
 */
// class Customer {
//   /**
//    * foodId to store foodId.
//    */
//    private int cId;
//     private String cName;
//     private Float wallet;
//     private String cUserName;
//     private String cPassword;
//     /**
//      * Default Constructor.
//      */
//     public Customer() {
  
//     }
//   /**
//    * @param argCId to initialize food id.
//    * @param argCName to initialize food id.
//    * @param argWallet to initialize food id.
//    * @param argCUserName to initialize food id.
//    * @param argCPassword to initialize food id.
//    * used to get details through constructor.
//    */
//     public Customer(final int argCId, final String argCName, final Float argWallet, final String argCUserName, final String argCPassword) {
//       this.cId = argCId;
//       this.cName = argCName;
//       this.wallet = argWallet;
//       this.cUserName = argCUserName;
//       this.cPassword = argCPassword;
//     }
//     @Override
//       public final boolean equals(final Object obj) {
//       if (obj == null) {
//         return false;
//       }
//       if (getClass() != obj.getClass()) {
//         return false;
//       }
//       Customer cust = (Customer) obj;
//       if (Objects.equals(cId, cust.cId) && Objects.equals(cName, cust.cName) && Objects.equals(wallet, cust.wallet)
//           && Objects.equals(cUserName, cust.cUserName) && Objects.equals(cPassword, cust.cPassword)) {
//         return true;
//       }
//       return false;
//     }
//     @Override
//       public final int hashCode() {
//       return Objects.hash(cId, cName, wallet, cUserName, cPassword);
//     }
//       /**
//        * @return  this food ID.
//        */
//     public final int getCId() {
//       return cId;
//     }
//      /**
//        * @return  this food ID.
//        */
//     public final String getCName() {
//       return cName;
//     }
//      /**
//        * @return  this food ID.
//        */
//     public final Float getWallet() {
//       return wallet;
//     }
//      /**
//        * @return  this food ID.
//        */
//     public final String getCUserName() {
//       return cUserName;
//     }
//      /**
//        * @return  this food ID.
//        */
//     public final String getCPassword() {
//       return cPassword;
//     }
//       /**
//        * @param argCId gets the customer id.
//        */
//     public final void setCId(final int argCId) {
//       this.cId = argCId;
//     }
//     /**
//        * @param argCName gets the customer id.
//        */
//     public final void setCName(final String argCName) {
//       this.cName = argCName;
//     }
//     /**
//        * @param argWallet gets the customer id.
//        */
//     public final void setWallet(final float argWallet) {
//       this.wallet = argWallet;
//     }
//     /**
//        * @param argCUserName gets the customer id.
//        */
//     public final void setcUserName(final String argCUserName) {
//       this.cUserName = argCUserName;
//     }
//     /**
//        * @param argCPassword gets the customer id.
//        */
//     public final void setcPassword(final String argCPassword) {
//       this.cPassword = argCPassword;
//     }
  
//     @Override public final String toString() {
//       return String.format(this.cId + "\t" + this.cName + "\t" + this.wallet
//           + "\t" + this.cUserName + "\t" + this.cPassword);
//     }
//   }
  