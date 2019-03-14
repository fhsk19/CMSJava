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

public class MenuRestTest {

	@Test
	public void testMenuList() throws AssertionError, URISyntaxException {
	Menu[] res = given()
				 .accept(ContentType.JSON)
				 .when()
				 .get(CommonUtil.getURI("/api/menu"))
				 .getBody().as(Menu[].class);

   Menu  expMenu = new Menu (1000, 500,"RICE", (float) 60.59,"VEG","TODAY SPECIAL");

	assertEquals(1000,res[0].getFoodId());
	assertEquals(500, res[0].getVId());
	assertEquals("RICE", res[0].getFoodName());
	assertEquals(60.59, res[0].getPrice(), 0.1);
	assertEquals("VEG", res[0].getFoodCategory());
	assertEquals("TODAY SPECIAL", res[0].getFoodDescription());
	}
}
