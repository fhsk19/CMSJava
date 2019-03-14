package com.hexaware.FTP105.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP105.model.Vendor;
import com.hexaware.FTP105.factory.VendorFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Vendor details.
   * @return the vendor details.
   * @param vUserName vUserName.
   * @param vPassword vPassword.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor getvendorlogin(
      @QueryParam("vUserName") final String  vUserName, @QueryParam("vPassword") final String vPassword) {
    Vendor vr = VendorFactory.vLogin(vUserName, vPassword);
    if (vr == null) {
      throw new NotFoundException("enter correct vendor login" + vUserName);
    }
    return vr;
  }
}
