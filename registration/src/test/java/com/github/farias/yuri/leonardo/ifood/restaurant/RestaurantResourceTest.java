//package com.github.farias.yuri.leonardo.ifood.restaurant;
//
//import com.github.farias.yuri.leonardo.ifood.RegistrationLifecycleManager;
//import io.quarkus.test.common.QuarkusTestResource;
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//import org.junit.jupiter.api.Test;
//
//@QuarkusTest
//@QuarkusTestResource(RegistrationLifecycleManager.class)
//public class RestaurantResourceTest {
//
//    private RequestSpecification given() {
//        return RestAssured.given().contentType(ContentType.JSON);
//    }
//
//    @Test
//    public void testSearchRestaurants() {
//        var result = given()
//          .when().get("/restaurants")
//          .then()
//                .statusCode(200)
//                .extract().asString();
////        Approvals.verify(result);
//    }
//
//}