package com.hexaware.FTP105.integration.test;
import java.util.Arrays;
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

    public class VendorRestTest{
    @Test
    public void testRestVendorlogin() throws AssertionError, URISyntaxException {
    //{"vname":"SURESH","vuserName":"SURESHP","vpassword":"VENDOR500","vphone":"9915382411","vid":500}
    Vendor res = given().when().accept(ContentType.JSON).get(CommonUtil.getURI("/api/vendor?vUserName=SURESHP&vPassword=VENDOR500")).getBody().as(Vendor.class);
    assertEquals("SURESH", res.getVName());
    assertEquals("SURESHP", res.getVUserName());
    assertEquals("VENDOR500", res.getVPassword());
    assertEquals("9915382411", res.getVPhone());
    assertEquals(500, res.getVId());

    }
}