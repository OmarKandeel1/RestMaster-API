package com.qacart.todo.apis;

import com.qacart.todo.base.Specs;
import com.qacart.todo.data.Route;
import com.qacart.todo.models.Todo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApi {

    public static Response addToDo(Todo todo, String token) {
        return given()
                .spec(Specs.getReqestSpec())
                .auth().oauth2(token)
                .body(todo)

                .when()
                .post(Route.TODOS_ROUTE)

                .then()
                .log().all()
                .extract().response();
    }

    public static Response getToDO(String taskID, String token) {
        return given()
                .spec(Specs.getReqestSpec())
                .auth().oauth2(token)



                .when()
                .get(Route.TODOS_ROUTE + "/" + taskID)

                .then()
                .log().all()
                .extract().response();
    }

    public static Response deleteToDo(String taskID, String token)
    {
        return given()
                .spec(Specs.getReqestSpec())
                .auth().oauth2(token)



                .when()
                .delete(Route.TODOS_ROUTE + "/" + taskID)

                .then()
                .log().all()
                .extract().response();
    }


}
