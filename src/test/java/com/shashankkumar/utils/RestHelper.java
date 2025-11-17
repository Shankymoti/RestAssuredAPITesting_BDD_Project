package com.shashankkumar.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestHelper {

    private RequestSpecification requestSpec;
    private Response response;

    public void initRequest(String baseURI) {
        requestSpec = given().baseUri(baseURI).header("Content-Type", "application/json");
    }

    public void setBody(String body) {
        requestSpec.body(body);
    }

    public Response post(String endpoint) {
        response = requestSpec.post(endpoint);
        return response;
    }

    public Response get(String endpoint) {
        response = requestSpec.get(endpoint);
        return response;
    }

    public Response put(String endpoint) {
        response = requestSpec.put(endpoint);
        return response;
    }

    public Response delete(String endpoint) {
        response = requestSpec.delete(endpoint);
        return response;
    }

    public Response getResponse() {
        return response;
    }
}
