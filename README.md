 # **RestMaster-API** 

A simple layered API Test Automation Framework built using Java, TestNG, Rest Assured, and Maven.

# Overview📌

This project is a modular API automation framework that separates:

API requests

test logic

test data

execution

It supports authentication, environment configuration, parallel execution, and CI testing using GitHub Actions.

# Tech Stack🧰

Java

TestNG

Rest Assured

Maven

Allure Reports

Java Faker

GitHub Actions

# Project Structure🏗️
apis        → API request handling

base        → request specs & environment config

models      → request/response POJOs

steps       → reusable test flows & data generation

data        → routes & error messages

testcases   → TestNG tests


# Run Tests⚙️

Run all tests:

mvn clean test


Run on local environment:

mvn clean test -Denv=LOCAL

# Authentication🔐

Token generated dynamically during tests

No global token storage

Independent test execution

# Features🧪

Layered architecture

OAuth2 authentication

Dynamic test data

Parallel execution

Console logging

CI execution on push

# CI/CD🔄

Tests run automatically using GitHub Actions when code is pushed.

## Future Improvements📈

Retry mechanism

Data driven tests

Advanced reporting

Log files

## Author👤

Omar Kandeel
