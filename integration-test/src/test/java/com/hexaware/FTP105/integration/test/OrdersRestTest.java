package com.hexaware.FTP105.integration.test;
import java.util.Arrays;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class OrdersRestTest {
   @Test
    public void testOrdersvhistory() throws AssertionError, URISyntaxException {

        
    Time ort=new Time(13,55,27);
    Time est=new Time(13,55,27);
    String str="2019-03-13";
    Date od3=Date.valueOf(str);
    Orders[] res = given()
                  .when()
                  .accept(ContentType.JSON)
                  .get(CommonUtil.getURI("/api/orders/vhistory/500"))
                  .getBody()
                  .as(Orders[].class);

    assertEquals(1011, res[4].getFoodId());
    assertEquals(4, res[4].getQty());
    assertEquals(120.8, res[4].getTotalPrice(), 0.1);
    assertEquals(est, res[4].getEstimatedTime());
    assertEquals(ort, res[4]. getOrderTime());
    assertEquals(od3, res[4]. getOrderDate());
    assertEquals("DELIVERED", res[4].getOStatus());
    assertEquals(309, res[4]. getOId());
    assertEquals("Thanks for visiting", res[4].getOComment());
    assertEquals(1, res[4].getCId());
    assertEquals(500, res[4].getVId());
 }
    @Test
    public void testOrderschistory() throws AssertionError, URISyntaxException {
      
        Time ort=new Time(13,55,27);
        Time est=new Time(13,55,27);
        String str="2019-03-13";
    Date od=Date.valueOf(str);
    Orders[] res = given().when().accept(ContentType.JSON)
        .get(CommonUtil.getURI("/api/orders/chistory/1"))
        .getBody().as(Orders[].class);

    assertEquals(1011, res[8].getFoodId());
    assertEquals(4, res[8].getQty());
    assertEquals(120.8, res[8].getTotalPrice(), 0.1);
    assertEquals(est, res[8].getEstimatedTime());
    assertEquals(ort, res[8]. getOrderTime());
    assertEquals(od, res[8]. getOrderDate());
    assertEquals("DELIVERED", res[8].getOStatus());
    assertEquals(309, res[8]. getOId());
    assertEquals("Thanks for visiting", res[8].getOComment());
    assertEquals(1, res[8].getCId());
    assertEquals(500, res[8].getVId());
}

@Test
    public void testPlacedOrders() throws AssertionError, URISyntaxException {
    Time ort=new Time(12,57,35);
    Time est=new Time(12,57,35);
        String str="2019-03-13";
    Date od1=Date.valueOf(str);
    Orders[] res = given().when().accept(ContentType.JSON)
                  .get(CommonUtil.getURI("/api/orders/placed/501"))
                  .getBody().as(Orders[].class);

    assertEquals(1003, res[0].getFoodId());
    assertEquals(3, res[0].getQty());
    assertEquals(90.0, res[0].getTotalPrice(), 0.1);
    assertEquals(est, res[0].getEstimatedTime());
    assertEquals(ort, res[0]. getOrderTime());
    assertEquals("PLACED", res[0].getOStatus());
    assertEquals(od1, res[0].getOrderDate());
    assertEquals(303, res[0]. getOId());
    assertEquals(null, res[0].getOComment());
    assertEquals(1, res[0].getCId());
    assertEquals(501, res[0].getVId());
}

@Test
public void testInsertOrder() throws AssertionError, URISyntaxException {
    Time et=new Time(13,54,31);
    Time ot=new Time(13,54,31);
    String st="2019-03-13";
    Date od = Date.valueOf(st);
   
Orders expOrder = new Orders(306, 1, 1000, 2, (float) 121.18, et, ot, 500,  od , "DELIVERED", "see you tomorrow");
String str = given()
             .contentType("application/json")
             .accept(ContentType.JSON)
             .body(expOrder).when()
             .put(CommonUtil.getURI("/api/orders/update/306"))
             .getBody().asString();

             System.out.println(str);
             String estr = "{\"msg\":\"Delivered Order\"}";
             assertEquals(estr,str);
}

@Test
public void testPlaceOrder() throws AssertionError, URISyntaxException {
Time et = new Time(15,53,24);
Time ot = new Time(15,53,24);
String st = "2019-03-13";
Date od = Date.valueOf(st);

Orders expOrder = new Orders(365, 1, 1003, 3, (float) 90, et, ot, 501,  od , "PLACED", "thank you");
String str = given()
         .contentType("application/json")
         .accept(ContentType.JSON)
         .body(expOrder).when()
         .post(CommonUtil.getURI("/api/customer/placeorder/1"))
         .getBody().asString();

         System.out.println(str);
         String estr = "{\"msg\":\"Order Placed\"}";
         assertEquals(estr,str);
}

} 
