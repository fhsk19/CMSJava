package com.hexaware.FTP105.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;

/**
  * Test class for Vendor.
*/
@RunWith(JMockit.class)
public class VendorTest {
/**
  * setup method.
 */
  @Before
public void initInput() {
  }
/**
  * Tests the equals/hashcode methods of the employee class.
 */
  @Test
public final void testVendor() {
    Vendor ven = new Vendor();
    Vendor v500 = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    assertNotEquals(v500, null);
    v500.setVId(3000);
    assertEquals(3000, v500.getVId());
    v500.setVName("varun");
    assertEquals("varun", v500.getVName());
    v500.setVUserName("varunabc");
    assertEquals("varunabc", v500.getVUserName());
    v500.setVPassword("abcd");
    assertEquals("abcd", v500.getVPassword());
    v500.setVPhone("97901156");
    assertEquals("97901156", v500.getVPhone());
    assertNotEquals(3001, v500.getVId());
    assertNotEquals("aaaa", v500.getVName());
    assertNotEquals(97564566, v500.getVPhone());
    assertNotEquals("abcd", v500.getVUserName());
    assertEquals(v500.hashCode(), new Vendor(3000, "varun", "varunabc", "abcd", "97901156").hashCode());

    Vendor actual = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    Vendor expected = new Vendor(3000, "varun", "varunabc", "abcd", "97901156");
    assertEquals(actual, expected);
    System.out.println(v500);
    Date d1 = new Date();
    assertEquals(false, v500.equals(d1));
    assertEquals(false, v500.equals(ven));
  }
}

