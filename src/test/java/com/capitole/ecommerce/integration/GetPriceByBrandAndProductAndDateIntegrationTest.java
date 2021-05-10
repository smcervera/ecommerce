package com.capitole.ecommerce.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPriceByBrandAndProductAndDateIntegrationTest {

    private final ObjectMapper objectMapper;

    public GetPriceByBrandAndProductAndDateIntegrationTest(@LocalServerPort Integer port) {
        RestAssured.port = port;
        objectMapper = new ObjectMapper();
    }

    @Test
    public void case_one() throws JsonProcessingException {

        ExtractableResponse<Response> response = RestAssured.get("/brands/1/products/35455?date=2020-06-14T10:00:00")
                .then()
                .extract();

        Map<String, Object> priceResponse = objectMapper.readValue(response.body().asString(), HashMap.class);
        Assertions.assertEquals(1, priceResponse.get("brand_id"));
        Assertions.assertEquals(35455, priceResponse.get("product_id"));
        Assertions.assertEquals(35.5, priceResponse.get("price"));
    }

    @Test
    public void case_two() throws JsonProcessingException {

        ExtractableResponse<Response> response = RestAssured.get("/brands/1/products/35455?date=2020-06-14T16:00:00")
                .then()
                .extract();

        Map<String, Object> priceResponse = objectMapper.readValue(response.body().asString(), HashMap.class);
        Assertions.assertEquals(1, priceResponse.get("brand_id"));
        Assertions.assertEquals(35455, priceResponse.get("product_id"));
        Assertions.assertEquals(25.45, priceResponse.get("price"));
    }

    @Test
    public void case_three() throws JsonProcessingException {

        ExtractableResponse<Response> response = RestAssured.get("/brands/1/products/35455?date=2020-06-14T21:00:00")
                .then()
                .extract();

        Map<String, Object> priceResponse = objectMapper.readValue(response.body().asString(), HashMap.class);
        Assertions.assertEquals(1, priceResponse.get("brand_id"));
        Assertions.assertEquals(35455, priceResponse.get("product_id"));
        Assertions.assertEquals(35.5, priceResponse.get("price"));
    }

    @Test
    public void case_four() throws JsonProcessingException {

        ExtractableResponse<Response> response = RestAssured.get("/brands/1/products/35455?date=2020-06-15T10:00:00")
                .then()
                .extract();

        Map<String, Object> priceResponse = objectMapper.readValue(response.body().asString(), HashMap.class);
        Assertions.assertEquals(1, priceResponse.get("brand_id"));
        Assertions.assertEquals(35455, priceResponse.get("product_id"));
        Assertions.assertEquals(30.5, priceResponse.get("price"));
    }

    @Test
    public void case_five() throws JsonProcessingException {

        ExtractableResponse<Response> response = RestAssured.get("/brands/1/products/35455?date=2020-06-16T21:00:00")
                .then()
                .extract();

        Map<String, Object> priceResponse = objectMapper.readValue(response.body().asString(), HashMap.class);
        Assertions.assertEquals(1, priceResponse.get("brand_id"));
        Assertions.assertEquals(35455, priceResponse.get("product_id"));
        Assertions.assertEquals(38.95, priceResponse.get("price"));
    }
}
