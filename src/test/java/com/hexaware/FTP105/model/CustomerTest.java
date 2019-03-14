package com.hexaware.FTP105.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * class customerTest.
 */
public class CustomerTest {
  /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("WELCOME");
  }
  /**
   * show customer info.
   */
  @Test
  public final void testCustomerInfo() {
    Customer c = null;
    assertNull(c);

    Customer c1 = new Customer();
    assertNotNull("Customer is not null", c1);
    assertNotNull(c1);

    Customer c2 = new Customer();
    c2.setCId(2000);
    assertEquals(2000, c2.getCId());

    c2.setCName("sravan");
    assertEquals("sravan", c2.getCName());

    c2.setcUserName("sravan");
    assertEquals("sravan", c2.getCUserName());

    c2.setWallet(7000);
    assertEquals(7000, c2.getWallet(), 0.001);

    c2.setcPassword("sravan@123");
    assertEquals("sravan@123", c2.getCPassword());

    assertNotEquals("latha", c2.getCName());
    assertNotEquals(2001, c2.getCId());
    assertNotEquals("latha", c2.getCUserName());
    assertNotEquals(8000, c2.getWallet());
    assertNotEquals("latha@123", c2.getCPassword());
  }

  /**
   * show testallargConstructor.
   */
  @Test
    public final void testallargConstructor() {
    Customer c1 = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    assertNotNull("Customer is not null", c1);
    assertNotNull(c1);
    assertNotEquals(c1, null);
    assertEquals(3000, c1.getCId());
    assertEquals("varun", c1.getCName());
    assertEquals("varunabc", c1.getCUserName());
    assertEquals(250, c1.getWallet(), 0.001);
    assertEquals("abcd", c1.getCPassword());
    assertEquals(c1, new Customer(3000, "varun", (float) 250, "varunabc", "abcd"));
    assertNotEquals(c1, new Customer(3001, "arun", (float) 350, "arunabc", "abcd1"));
    assertEquals(c1.hashCode(), new Customer(3000, "varun", (float) 250, "varunabc", "abcd").hashCode());
    System.out.println(c1);

    ArrayList a = new ArrayList();
    assertFalse(c1.equals(a));
  }

  /**
   * test for object.
   */
  @Test
    public final void testCustomerObjects() {
    Customer expected = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    Customer actual = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");

    assertEquals(expected, actual);

    Customer act2 = new Customer(3001, "arun", (float) 350, "arunabc", "abcd1");
    assertNotEquals(expected, act2);
  }
}
