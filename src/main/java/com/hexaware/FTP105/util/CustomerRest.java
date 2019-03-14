package com.hexaware.FTP105.util;
import java.time.LocalDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.hexaware.FTP105.factory.CustomerFactory;
import com.hexaware.FTP105.factory.MenuFactory;
import com.hexaware.FTP105.model.Customer;
import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.model.Orders;

/**
 * This class provides a REST interface for the Customer entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @param cId .
   * @return the Customer details.
   */

  @GET
  @Path("/{cId}")
  @Produces(MediaType.APPLICATION_JSON)
    public final float getWallet(@PathParam("cId") final int cId) {
    float c = CustomerFactory.getWalletValue(cId);
    return c;
  }
 /**
   * Returns Customer details.
   * @return the Customer details.
   * @param cUserName for customername.
   * @param cPassword for customerpassword.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer getCustomerDetails(
      @QueryParam("cUserName") final String cUserName, @QueryParam ("cPassword") final String cPassword) {
    Customer cf = CustomerFactory.cLogin(cUserName, cPassword);
    if (cf == null) {
      throw new NotFoundException("No such customer");
    }
    return cf;
  }
  /**
   * Returns Menu details.
   * @param ordArr for Orders Object.
   * @param custId for cId.
   * @return the menu details.
   */
  @Path("/placeorder/{custId}")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final Status placeOrder(@PathParam("custId") final int custId, final Orders[] ordArr) {
    Status st = new Status();
    String retVal = "";
    LocalDateTime date = LocalDateTime.now();
    if (ordArr.length > 0) {
      for (Orders ord : ordArr) {
        Customer[] cust = CustomerFactory.showCustomer(custId);
        if (cust.length > 0 && ord != null) {
          Customer c = cust[0];
          if (c.getWallet() != 0) {
            Menu m = MenuFactory.getSingleMenu(ord.getFoodId());
            if (m != null && ord.getQty() >= 1) {
              String ret = CustomerFactory.placeOrder(custId, ord.getFoodId(), ord.getQty(), date);
              retVal += " Food Id: " + ord.getFoodId() + " Food quantity: " + ord.getQty();
              if (ret == "Order Placed") {
                retVal = ret;
                retVal += " Order placed\n";
              } else {
                retVal += " insufficient balance\n";
              }
            } else {
              retVal += " invalid quantity\n";
            }
          } else {
            retVal += " insufficient balance\n";
          }
        } else {
          retVal += " invalid customer id\n";
        }
      }
    }
    st.setMsg(retVal);
    return st;
  }
}
