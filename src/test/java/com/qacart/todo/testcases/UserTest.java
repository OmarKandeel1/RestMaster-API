package com.qacart.todo.testcases;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.qacart.todo.apis.UserApi;
import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.User;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Feature("User Feature")
public class UserTest {

    @Story( "Should be Able to Register for first time!")
    @Test(description = "Should be Able to Register for first time!")
    public void shouldBeAbleToRegister() {


        User user = UserSteps.generateUser();

        Response response = UserApi.register(user);

        User returnedUser = response.body().as(User.class);

        assertThat(response.statusCode(), is(201));
        assertThat(returnedUser.getAccessToken(), notNullValue());
        assertThat(returnedUser.getFirstName(), is(user.getFirstName()));
        assertThat(returnedUser.getUserID(), notNullValue());


    }

    @Test
    public void shouldNotBeAbleToRegisterWithTheSameEmail() {

        User user = UserSteps.getRegisteredUser();

        Response response = UserApi.register(user);

        Error returnedError = response.body().as(Error.class);


        assertThat(response.statusCode(), is(400));
        assertThat(returnedError.getMessage(), is(ErrorMessages.EMAIL_IS_ALREADY_RESGISTERED));


    }

    @Test
    public void shouldBeAbleToLogin() {

        User user = UserSteps.getRegisteredUser();
        User loginData = new User(user.getEmail(), user.getPassword());
        Response response = UserApi.login(loginData);


        User returnedUser = response.body().as(User.class);

        assertThat(response.statusCode(), is(200));
        assertThat(returnedUser.getUserID(), notNullValue());
        assertThat(returnedUser.getFirstName(), is(user.getFirstName()));
        assertThat(returnedUser.getAccessToken(), notNullValue());


    }

    @Test
    public void shouldNotBeAbleToLoginIfPasswordNotCorrect() {

        User user = UserSteps.getRegisteredUser();
        User loginData = new User(user.getEmail(), user.getPassword() + "1");

        Response response = UserApi.login(loginData);

        Error returnedError = response.body().as(Error.class);

        assertThat(response.statusCode(), is(401));
        assertThat(returnedError.getMessage(), is(ErrorMessages.LOGIN_CREDENTIALS_INVALID));

    }


}
