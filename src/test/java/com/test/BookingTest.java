package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BookingTest {


    @Test
    public void getBooking() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    String tokenId = given()
            .contentType(ContentType.JSON)
            .body("{\n"
                    + "    \"username\" : \"admin\",\n"
                    + "    \"password\" : \"password123\"\n"
                    + "}")
            .when()
            .post("/auth")
            .then()
            .assertThat()
            .statusCode(200)
            .extract()
            .path("token");


		System.out.println(tokenId);
		Assert.assertNotNull(tokenId);


}
}
