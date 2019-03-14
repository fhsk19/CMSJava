package com.hexaware.FTP105.integration.test;

import java.util.Arrays;
import java.util.Date;
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

public class CustomerRestTest{
@Test
    public void testRestCustomerWallet() throws AssertionError, URISyntaxException {
    Customer c = new Customer();
    float res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/customer/4")).getBody().as(float.class);
        c.setWallet(res);
        assertNotNull(res);
        assertEquals(1800.23, c.getWallet(),0.01);
}

@Test
public void testCustomerLogin() throws AssertionError,URISyntaxException {
Customer res = given()
              .when()
              .accept(ContentType.JSON)
              .get(CommonUtil.getURI("/api/customer?cUserName=rushi&cPassword=pass004"))
              .getBody().as(Customer.class);
assertEquals(1800.23,res.getWallet(),0.01);
assertEquals(4,res.getCId());
assertEquals("rushikesh",res.getCName());
assertEquals("rushi",res.getCUserName());
assertEquals("pass004",res.getCPassword());
}
}
