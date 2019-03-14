package com.hexaware.FTP105.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.FTP105.factory.CustomerFactory;
import com.hexaware.FTP105.factory.OrdersFactory;
import com.hexaware.FTP105.model.OStatus;
import com.hexaware.FTP105.model.Orders;


/**
 * This class status.
 */
class Status {
  private String msg;

/**
 * This constructor..
 */
  Status() {

  }

/**
 * This class.
 * @return .
 */
  public final String getMsg() {
    return msg;
  }

/**
 * This class .
 * @param st .
 */
  public final void setMsg(final String st) {
    msg = st;
  }
}

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orders")
public class OrdersRest {
   /**
    * Returns Order details.
    * @return the order details.
    * @param cId for cutomerId.
    */
  @GET
  @Path("/chistory/{cId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] getAllOrders(@PathParam("cId") final int cId) {
    Orders[] orders =  OrdersFactory.cHis(cId);
    return orders;
  }
/**
 * This class.
 * @param oId .
 * @param ord .
 * @return .
 */
  @PUT
  @Path("/update/{oId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)

  public final Status updateOStatusUsingOId(
      @PathParam("oId") final int oId, final Orders ord) {
    Status st = new Status();
    String retVal = "";
    System.out.println("order id" +  oId);
    System.out.println("order " +  ord);
    if (ord != null && oId == ord.getOId()) {
      OrdersFactory.updateStatus(ord.getOStatus().name(), oId);
      OrdersFactory.updateCom(ord.getOComment(), oId);
      if (ord.getOStatus() == OStatus.CANCELLED) {
        CustomerFactory.revertBal(oId);
        retVal = "Cancelled Order";
        st.setMsg(retVal);
        return st;
      } else {
        retVal = "Delivered Order";
        st.setMsg(retVal);
        return st;
      }
    }
    return st;
  }
/**
  * Returns Order details.
  * @param vId vid.
  * @throws NotFoundException for exception.
  * @return the order details
 */
  @GET
  @Path("/vhistory/{vId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] getVendorHis(
      @PathParam("vId") final int vId) throws NotFoundException {
    Orders[] orders = OrdersFactory.vHis(vId);
    if (orders == null) {
      throw new NotFoundException("no such vid" + vId);
    }
    return orders;
  }
  /**
  * Returns Order details.
  * @param vId vid.
  * @throws NotFoundException for exception.
  * @return the order details
 */
  @GET
  @Path("/placed/{vId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] getPlacedHis(
      @PathParam("vId") final int vId) throws NotFoundException {
    Orders[] orders = OrdersFactory.pHis(vId);
    if (orders == null) {
      throw new NotFoundException("no such vid" + vId);
    }
    return orders;
  }
}
