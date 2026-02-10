package com.qacart.todo.steps;

import com.github.javafaker.Faker;
import com.qacart.todo.apis.TodoApi;
import com.qacart.todo.models.Todo;
import io.qameta.allure.Feature;
import io.restassured.response.Response;


public class TodoSteps {

    public static Todo generateTodo() {
        Faker faker = new Faker();

        String item = faker.app().name();
        Boolean isCompleted = false;
            return new Todo(isCompleted, item);
    }


    public static String getTodoId(Todo todo, String token) {
        Response response = TodoApi.addToDo(todo, token);
            return response.body().path("_id");
    }
}
