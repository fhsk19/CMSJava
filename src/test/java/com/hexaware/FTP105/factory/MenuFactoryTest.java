package com.hexaware.FTP105.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.persistence.MenuDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;



/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("welcome");
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   * @param mdao .
   */
  @Test
    public final void showMenuTest(@Mocked final MenuDAO mdao) {
    int expectedSize = 1;
    final List<Menu> mArr = new ArrayList<Menu>();
    final Menu men = new Menu(4005, 3002, "rice", (float) 50, "non veg", "veg special rice");
    mArr.add(men);
    new Expectations() { {
        System.out.println("mocked getMenu");
        mdao.show();
        result = mArr;
        } };
    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
        System.out.println("mocked menu dao");
        return mdao;
        }
        };
    MenuFactory md = new MenuFactory();
    Menu[] meArr = md.showMenu();
    assertEquals(expectedSize, meArr.length);
    assertEquals(men, meArr[0]);
  }
  /**
    * Test class for Menu.
   */
  @Test
    public final void testMapper() {
    Menu[] menu = MenuFactory.showMenu();
    assertNotNull(menu);
  }
   /**
   * Tests the equals/hashcode methods of the employee class.
   * @param mdao .
   */
  @Test
    public final void showSingleTest(@Mocked final MenuDAO mdao) {
    final Menu men = new Menu(4005, 3002, "rice", (float) 50, "non veg", "veg special rice");
    new Expectations() { {
        System.out.println("mocked getMenu");
        mdao.getMenu(4005);
        result = men;
      } };

    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
        System.out.println("mocked menu dao");
        return mdao;
        }
        };
    MenuFactory md = new MenuFactory();
    Menu meArr = md.getSingleMenu(4005);
    assertEquals(men, meArr);
  }
/**
   * Tests the equals/hashcode methods of the employee class.
   * @param mdao .
   */
  @Test
  public final void showMenuDAOTest(@Mocked final MenuDAO mdao) {
    MenuDAO md = MenuFactory.dao();
    assertNotNull(md);
  }
}
