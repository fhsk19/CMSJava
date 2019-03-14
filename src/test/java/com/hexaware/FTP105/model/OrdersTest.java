package com.hexaware.FTP105.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Orders.
 */
@RunWith(JMockit.class)
public class OrdersTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for exception
   */
  @Test
  public final void testOrders() throws ParseException {

    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());

    Orders o = new Orders(5000, 2000, 4000, 4, 450.0f, t, t, 3000, (java.sql.Date) od, OStatus.PLACED, "THANK YOU");
    Orders o5000 = new Orders();


    assertEquals(5000, o.getOId());
    assertEquals(2000, o.getCId());
    assertEquals(4000, o.getFoodId());
    assertEquals(4, o.getQty());
    assertEquals(450.0f, o.getTotalPrice(), 0.001);
    assertEquals(t, o.getEstimatedTime());
    assertEquals(t, o.getOrderTime());
    assertEquals(3000, o.getVId());
    assertEquals(od, o.getOrderDate());
    OStatus os = OStatus.PLACED;
    assertEquals(os, o.getOStatus());

    assertEquals("THANK YOU", o.getOComment());
    assertNotEquals(o, null);

    assertNotEquals(o5000, null);

    o.setOId(5000);
    assertEquals(5000, o.getOId());
    o.setCId(2000);
    assertEquals(2000, o.getCId());
    o.setFoodId(4000);
    assertEquals(4000, o.getFoodId());
    o.setQty(4);
    assertEquals(4, o.getQty());
    o.setTotalPrice(450.0f);
    assertEquals(450.0f, o.getTotalPrice(), 0.001);
    o.setEstimatedTime(t);
    assertEquals(t, o.getEstimatedTime());
    o.setOrderTime(t);
    assertEquals(t, o.getOrderTime());
    o.setVId(3000);
    assertEquals(3000, o.getVId());
    o.setOrderDate((java.sql.Date) od);
    assertEquals(od, o.getOrderDate());
    o.setOStatus(os);
    assertEquals(os, o.getOStatus());
    o.setOComment("THANK YOU");
    assertEquals("THANK YOU", o.getOComment());

    ArrayList s = new ArrayList();
    assertFalse(o.equals(s));


    assertEquals(o.hashCode(), new Orders(5000, 2000, 4000, 4, 450.0f, t, t, 3000, (java.sql.Date) od, OStatus.PLACED, "THANK YOU").hashCode());
    Orders exp = new Orders(5000, 2000, 4000, 4, 450.0f, t, t, 3000, (java.sql.Date) od, os, "THANK YOU");
    Orders act = new Orders(5003, 2003, 4000, 4, 450.0f, t, t, 3000, (java.sql.Date) od, os, "THANK YOU");
    Orders ord = new Orders(5003, 2003, 4000, 4, 450.0f, t, t, 3000, (java.sql.Date) od, os, "THANK YOU");
    assertEquals(act, ord);
    assertNotEquals(act, exp);
  }

    /**
    * Tests all arg constructors.
    */
  @Test
  public final void testEqualsMethod() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/DD");
    sd.setLenient(false);
    Date ld = new java.sql.Date(new java.util.Date().getTime());
    Time ot = new Time(ld.getTime());
    Orders o1 = new Orders(5000, 2000, 4000, 4, 450.0f, ot, ot, 3000, (java.sql.Date) ld, OStatus.PLACED, "THANK YOU");
    Orders o2 = new Orders(5000, 2000, 4000, 4, 450.0f, ot, ot, 3000, (java.sql.Date) ld, OStatus.PLACED, "THANK YOU");
    assertEquals(o1, o2);
    Orders o3 = new Orders(5001, 2000, 4000, 4, 450.0f, ot, ot, 3000, (java.sql.Date) ld, OStatus.PLACED, "THANK YOU");
    Orders o4 = new Orders(5000, 2000, 4000, 4, 450.0f, ot, ot, 3000, (java.sql.Date) ld, OStatus.PLACED, "THANK YOU");
    assertNotEquals(o3, o4);
    assertNotEquals(o2, null);
    ArrayList<Orders> a = new ArrayList<Orders>();
    assertFalse(o1.equals(a));
  }
}
