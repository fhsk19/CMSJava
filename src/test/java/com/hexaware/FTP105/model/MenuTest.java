package com.hexaware.FTP105.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

//import com.hexaware.FTP105.model.Menu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;


/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("welcome");
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    Menu m = null;
    assertNull(m);
    Menu m1 = new Menu();
    assertNotNull("Menu is not null", m1);
    assertNotNull(m1);
    Menu m2 = new Menu(4000, 3002, "veg briyani", (float) 250f, "veg", "veg special");
    assertNotEquals(m2, null);
    assertNotEquals(m2.getClass(), getClass());
    m2.setFoodId(4000);
    assertEquals(4000, m2.getFoodId());
    m2.setVId(3002);
    assertEquals(3002, m2.getVId());
    m2.setFoodName("veg briyani");
    assertEquals("veg briyani", m2.getFoodName());
    m2.setPrice((float) 250);
    assertEquals((float) 250, m2.getPrice(), 0.001);
    m2.setFoodCategory("veg");
    assertEquals("veg", m2.getFoodCategory());
    m2.setFoodDescription("veg special");
    assertEquals("veg special", m2.getFoodDescription());
    assertNotEquals(4001, m2.getFoodId());
    assertNotEquals(3005, m2.getVId());
    assertNotEquals("dosa", m2.getFoodName());
    assertNotEquals((float) 350, m2.getPrice(), 0.01);
    assertNotEquals("breakfast", m2.getFoodCategory());
    assertNotEquals("veg", m2.getFoodDescription());
    assertNotEquals(m2, new Menu(4001, 3005, "dosa", (float) 350, "breakfast", "veg"));
    assertEquals(m2.hashCode(), new Menu(4000, 3002, "veg briyani", (float) 250, "veg", "veg special").hashCode());
    assertEquals(m2, new Menu(4000, 3002, "veg briyani", (float) 250, "veg", "veg special"));
    System.out.println(m2);
    ArrayList a1 = new ArrayList();
    assertFalse(m2.equals(a1));
  }
   /**
   * Tests the constructor methods of the employee class.
   */
  @Test
  public final void testMenuConstructor() {
    Menu m1 = new Menu(4000, 3002, "veg briyani", (float) 250.5, "veg", "veg special");
    assertNotNull("Menu is not null");
    assertNotNull(m1);
    assertEquals(4000, m1.getFoodId());
    assertEquals(3002, m1.getVId());
    assertEquals("veg briyani", m1.getFoodName());
    assertEquals((float) 250.5, m1.getPrice(), 0.01);
    assertEquals("veg", m1.getFoodCategory());
    assertEquals("veg special", m1.getFoodDescription());
  }
   /**
   * Tests the constructor methods of the employee class.
   */
  @Test
  public final void testMenuObjects() {
    Menu expected = new Menu(4000, 3002, "veg briyani", (float) 250, "veg", "veg special");
    Menu actual = new Menu(4000, 3002, "veg briyani", (float) 250, "veg", "veg special");
    assertEquals(expected, actual);
    Menu men2 = new Menu(4001, 3005, "dosa", (float) 350.5, "breakfast", "veg");
    assertNotEquals(expected, men2);
  }
}
