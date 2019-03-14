package com.hexaware.FTP105.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP105.model.Customer;
import com.hexaware.FTP105.model.Menu;
import com.hexaware.FTP105.model.OStatus;
import com.hexaware.FTP105.model.Orders;
import com.hexaware.FTP105.persistence.CustomerDAO;
import com.hexaware.FTP105.persistence.DbConnection;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for customerfactory.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
/**
 * show Customer factory method.
 */
/**
  * tests that empty employee list is handled correctly.
  * @param dao mocking the dao class
  * @throws NullPointerException checks exception.
 */
  @Test
  public final void showCLoginTes(@Mocked final CustomerDAO dao) throws NullPointerException {
  //final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Customer c = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");

    new Expectations() { {
        System.out.println("mocked");

        dao.showCLogin("varunabc", "abcd");
        result = c;
      } };
    new MockUp<CustomerFactory>() {
      @Mock CustomerDAO dao() {
        System.out.println("mocked data");
        return dao;
      } };
    Customer vf = CustomerFactory.cLogin("varunabc", "abcd");
    assertEquals(c, vf);
  }
  /**
    * tests that showOrders is handled correctly.
    * @param cdao mocking the dao class.
   */
  @Test
  public final void showCustomerTest(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked Show Customers");
        cdao.showC(3000);
        result = lstexp;
      }
      };

    new MockUp<CustomerFactory>() {
      @Mock
          CustomerDAO dao() {
        System.out.println("mocked Customer show DAO");
        return cdao;
      }
      };

    Customer[] cfA = CustomerFactory.showCustomer(3000);
    List<Customer> stArr = new ArrayList<Customer>();
    for (Customer c : cfA) {
      stArr.add(c);
    }
    assertEquals(lstexp, stArr);
  }

/**
  * tests that showOrders is handled correctly.
  * @param cdao mocking the dao class.
 */
  @Test
  public final void showCustomer1Test(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked Show Customers");
        cdao.show();
        result = lstexp;
      }
      };

    new MockUp<CustomerFactory>() {
      @Mock
          CustomerDAO dao() {
        System.out.println("mocked Customer show DAO");
        return cdao;
      }
      };

    Customer[] cfA = CustomerFactory.showCustomer1();
    List<Customer> stArr = new ArrayList<Customer>();
    for (Customer c : cfA) {
      stArr.add(c);
    }
    assertEquals(lstexp, stArr);
  }

/**
  * tests that constructor is handled correctly.
  * @param cdao mocking the dao class.
 */
  @Test
  public final void constructorTest(@Mocked final CustomerDAO cdao) {
    CustomerFactory cf = new CustomerFactory();
    assertNotNull(cf);
  }
/**
  * tests that empty employee list is handled correctly.
  * @param cdao mocking the dao class.
 */
  @Test
    public final void getWalletValueTest(@Mocked final CustomerDAO cdao) {

    final Customer cus = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    new Expectations() {
      {
        System.out.println("mocked wallet");
        result = cdao.getWallet(3000);
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked wallet DAO");
        return cdao;
      }
    };
    float cfA = CustomerFactory.getWalletValue(3000);
    assertNotEquals(cfA, cus.getWallet(), 0.001);
  }
  /**
  * tests that empty employee list is handled correctly.
  * @param cdao mocking the dao class.
 */
  @Test
    public final void revertBalTest(@Mocked final CustomerDAO cdao) {
    int expected = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final int cId = 3000;
    final int oId = 2000;
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(oId, cId, 4000, 100, 1500.0f, t, t, 3000, od, os, value);
    ord.add(o);
    new Expectations() {
      {
        System.out.println("mocked wallet");
        cdao.updateWallet(cId, 1500.0f);
        result = 1;
        System.out.println("get det mocked");
        cdao.getdet(oId);
        result = ord;
        System.out.println("get wallet");
        cdao.getWallet(cId);
      }
        };
    new MockUp<CustomerFactory>() {
      @Mock
            CustomerDAO dao() {
        System.out.println("mocked DAO");
        return cdao;
      }
        };
    int cfA = CustomerFactory.revertBal(oId);
    assertEquals(expected, cfA);
  }
/**
  * tests that empty employee list is handled correctly.
 */
 // @Test
   /* public final void testMapper() {
    Customer[] c = CustomerFactory.showCustomer();
    assertNotNull(c);
  }*/
  /**
  * tests that empty employee list is handled correctly.
  * @param cdao mocking the dao class.

 */
  @Test
    public final void testConnection(@Mocked final CustomerDAO cdao) {
    final DbConnection dc = new DbConnection();
    new Expectations() {
        {
          System.out.println("mocked dbconnection");
          dc.getConnect().onDemand(CustomerDAO.class);
          result = dc;
        }
    };
    new MockUp<CustomerFactory>() {
        @Mock CustomerDAO dao() {
          System.out.println("Mocked dao");
          return cdao;
      }
    };
    assertNotNull(dc);
    assertNotEquals(dc, null);
    assertFalse(dc.equals(""));
  }

/**
  * tests that empty employee list is handled correctly.
  * @param cdao mocking the dao class.
  * @param odao mocking the dao class.
  * @param mdao mocking the dao class.
 */
  @Test
    public final void placeOrderTest(@Mocked final CustomerDAO cdao, @Mocked final OrdersFactory odao, @Mocked final MenuFactory mdao) {
    final int cId = 3000;
    final Customer cus = new Customer(3000, "varun", (float) 250, "varunabc", "abcd");
    final Menu m = new Menu(4005, 3002, "rice", (float) 50, "non veg", "veg special rice");
    LocalDateTime date = LocalDateTime.now();
    String expected = "Order Not Placed";
    new Expectations() {
        {
          System.out.println("mocked place order");
          cdao.getWallet(cId);
          result = cus;
        }
    };

    new MockUp<CustomerFactory>() {
        @Mock CustomerDAO dao() {
            System.out.println("mocked place order1 DAO");
            return cdao;
        }
    };
    new MockUp<OrdersFactory>() {
        @Mock OrdersFactory odao() {
            System.out.println("mocked order query");
            return odao;
        }
    };

    String actRes = CustomerFactory.placeOrder(3000, 4005, 2, date);
    assertEquals(expected, actRes);
    int i = OrdersFactory.orderQuery(4005, 3002, 3000, 2, (float) 100, date);
    assertEquals(0, i);
  }
}
