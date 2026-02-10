package com.qacart.todo.testcases;

import com.qacart.todo.apis.TodoApi;
import com.qacart.todo.models.Todo;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
@Feature("Todo Feature")
public class TodoTest {

@Story("AS logged in user i am able to add a Todo")
    @Test
    public void shouldBeAbleToAddTodo() {

        String token = UserSteps.getUserToken();
        Todo todo = TodoSteps.generateTodo();


        Response response = TodoApi.addToDo(todo, token);

        Todo returnedTodo = response.body().as(Todo.class);


        assertThat(response.statusCode(), is(201));
        assertThat(returnedTodo.getItem(), is(todo.getItem()));
        assertThat(returnedTodo.getIsCompleted(), is(todo.getIsCompleted()));


    }

    @Test
    public void shouldNotBeAbleToAddTodoIfIsCompletedIsMissing() {
        Todo todo = new Todo("Learn Appium");
        String token = UserSteps.getUserToken();

        Response response = TodoApi.addToDo(todo, token);

        Error returnedError = response.body().as(Error.class);

        assertThat(response.statusCode(), is(400));
        assertThat(returnedError.getMessage(), is("\"isCompleted\" is required"));


    }

    @Test
    public void shouldBeAbleToGetTodoByID() {

        String token = UserSteps.getUserToken();
        Todo todo = TodoSteps.generateTodo();
        String todoID = TodoSteps.getTodoId(todo , token);

        Response response = TodoApi.getToDO(todoID, token);

        Todo returnedTodo = response.body().as(Todo.class);
        assertThat(response.statusCode(), is(200));
        assertThat(returnedTodo.getItem(), is(todo.getItem()));

    }

    @Test
    public void shouldBeAbleToDeleteTodo() {
        String token = UserSteps.getUserToken();
        Todo todo = TodoSteps.generateTodo();

        String todoId = TodoSteps.getTodoId(todo , token);


        Response response = TodoApi.deleteToDo(todoId, token);

        Todo returnedTodo = response.body().as(Todo.class);
        assertThat(response.statusCode(), is(200));
        assertThat(returnedTodo.getItem(), is(todo.getItem()));


    }

}
