package com.github.farias.yuri.leonardo.ifood.restaurant;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.cdi.api.DBUnitInterceptor;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.farias.yuri.leonardo.ifood.RegistrationLifecycleManager;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(RegistrationLifecycleManager.class)
public class RestaurantResourceTest {

    private RequestSpecification given() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

    @Test
    @DataSet("restaurants-scenario-01")
    public void testSearchRestaurants() {
        var result = given()
          .when().get("/restaurants")
          .then()
                .statusCode(200)
                .extract().asString();
//        Approvals.verify(result);
    }

}