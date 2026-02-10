package com.qacart.todo.base;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Specs {

   public static String getEnv() {
       String env = System.getProperty("env", "PRODUCTION");
       String baseURL;
       switch (env) {
           case "PRODUCTION":
               baseURL = "https://todo.qacart.com/api/v1";
               break;

           case "LOCAL":
               baseURL = "http://localhost:8080";
               break;

           default:
               throw new RuntimeException("Enivronment is not supported");
       }
               return baseURL;

       }


    public static RequestSpecification getReqestSpec()
    {
        return given()
                .baseUri(getEnv())
                .contentType(ContentType.JSON)
                .log().all();
    }
}
