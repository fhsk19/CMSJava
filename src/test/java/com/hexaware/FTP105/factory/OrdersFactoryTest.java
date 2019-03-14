package com.hexaware.FTP105.factory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP105.model.OStatus;
import com.hexaware.FTP105.model.Orders;
import com.hexaware.FTP105.persistence.OrdersDAO;
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
public class OrdersFactoryTest {
  /**
    * tests that empty employee list is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException for exception.
   */
  @Test
  public final void vHisTest(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, value);
    ord.add(o);
    new Expectations() { {
        System.out.println("Mocked vendor order history");
        dao.showVHis(3000);
        result = ord;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked Vendor Order DAO");
            return dao;
          }
        };
    Orders[] stArr = OrdersFactory.vHis(3000);
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }
    /**
    * Test class for Menu.
   */
  @Test
    public final void testMapper() {
    Orders[] orders = OrdersFactory.showOrders();
    assertNotNull(orders);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException checks exception.
   */
  @Test
  public final void cHisTest(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, value);
    ord.add(o);
    new Expectations() { {
        System.out.println("Mocked customer order history");
        dao.showCHis(3000);
        result = ord;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked Customer order DAO");
            return dao;
          }
        };
    Orders[] stArr = OrdersFactory.cHis(3000);
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }

  /**
    * tests that orderStatus1 is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void orderStatus1Test(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, value);
    ord.add(o);
    new Expectations() { {
        System.out.println("Mocked order status");
        dao.showOrderStatus(3000, os.toString());
        result = ord;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked Order Status DAO");
            return dao;
          }
        };
    Orders[] stArr = OrdersFactory.orderStatus1(3000, os.toString());
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }

  /**
    * tests that showOrders is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void showOrdersTest(@Mocked final OrdersDAO dao) throws ParseException {
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final List<Orders> ord = new ArrayList<Orders>();
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, value);
    ord.add(o);
    new Expectations() { {
        System.out.println("Mocked show orders");
        dao.show();
        result = ord;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
          System.out.println("Mocked Show orders DAO");
          return dao;
      }
    };
    Orders[] stArr = OrdersFactory.showOrders();
    List<Orders> ord1 = new ArrayList<Orders>();
    for (Orders ord2 : stArr) {
      ord1.add(ord2);
    }
    assertEquals(ord, ord1);
  }

  /**
    * tests that foodId is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void fIdTest(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.PLACED;
    final String value = " ";
    Date od = new Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, value);
    ord.add(o);
    new Expectations() { {
        System.out.println("Mocked foodId");
        dao.showFId(3000);
        result = ord;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked foodId DAO");
            return dao;
          }
        };
    Orders[] stArr = OrdersFactory.fId(3000);
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }

  /**
    * tests that updateStatus is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void updateStatusTest(@Mocked final OrdersDAO dao) {
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.valueOf("PLACED");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    int expSize = 1;
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, res);
    ord.add(o);

    new Expectations() { {
            System.out.println("Mocked update Status");
            dao.showUpdateStatus(os.name(), 3500);
            result = 1;
        } };

    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked Update Status DAO");
            return dao;
        } };
    int sd = OrdersFactory.updateStatus(os.toString(), 3500);
    assertEquals(expSize, sd);
  }

  /**
    * tests that foodId is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void updateComTest(@Mocked final OrdersDAO dao) {
    final List<Orders> ord = new ArrayList<Orders>();
    final OStatus os = OStatus.valueOf("PLACED");
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final String res = " ";
    int expSize = 1;
    final Orders o = new Orders(3000, 2000, 4000, 100, 1234, t, t,
        3000, od, os, res);
    ord.add(o);

    new Expectations() { {
            System.out.println("Mocked Comment update");
            dao.updateCom(res, 3500);
            result = 1;
        } };

    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked  Comment Update DAO");
            return dao;
        } };
    int sd = OrdersFactory.updateCom(res, 3500);
    assertEquals(expSize, sd);
  }

  /**
    * tests that foodId is handled correctly.
    * @param dao mocking the dao class
    * @throws ParseException checks exception.
   */
  @Test
  public final void orderQueryTest(@Mocked final OrdersDAO dao) {
    int expectedSize = 1;
    final OStatus os = OStatus.PLACED;
    final LocalDateTime date = LocalDateTime.now();
    final int fId = 5000;
    final int vId = 4000;
    final int cId = 3000;
    final int qty = 1234;
    final float totalPrice = 1234.0f;
    new Expectations() { {
            System.out.println("Mocked insert Orders");
            DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
            String ot1 = date.format(tf1);
            DateTimeFormatter tf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String ot2 = date.format(tf2);
            dao.insertQuery(3000, 5000, 1234, os.toString(), 1234.0F, ot1, ot1, 4000, ot2);
            result = 1;
      } };

    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
            System.out.println("Mocked Insert Orders DAO");
            return dao;
        } };
    int stArr = OrdersFactory.orderQuery(fId, vId, cId, qty, totalPrice, date);
    assertEquals(expectedSize, stArr);
  }

  /**
    * tests that constructor is handled correctly.
   */
  @Test
  public final void ordersFactoryTest() {
    OrdersFactory fac = new OrdersFactory();
    assertNotNull(fac);
  }
}
