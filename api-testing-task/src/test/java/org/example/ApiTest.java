package org.example;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTest {

    public static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void whenGetUsersValidateStatusCode() {
        logger.info(() -> "test 1 runs on thread " + Thread.currentThread().getName());
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void whenGetUsersValidateResponseHeaders() throws InterruptedException {
        logger.info(() -> "test 2 runs on thread " + Thread.currentThread().getName());
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .header("Content-Type", "application/json; charset=utf-8");
    }

    @Test
    public void whenGetUsersValidateResponseBody() throws InterruptedException {
        logger.info(() -> "test 3 runs on thread " + Thread.currentThread().getName());
        String endpoint = "https://jsonplaceholder.typicode.com/users";
        given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .body("data.size()", equalTo(10));

    }
}
