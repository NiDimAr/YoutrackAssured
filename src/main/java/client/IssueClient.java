package client;

import config.ApiEndpoints;
import config.ApiFields;
import dto.request.IssueRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import spec.RequestSpecifications;
import spec.ResponseSpecifications;

import static io.restassured.RestAssured.given;

public class IssueClient {

    @Step("Отправить запрос на создание задачи")
    public Response createIssue(IssueRequest issueRequest) {

        return given()
                .spec(RequestSpecifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES)
                .then()
                .spec(ResponseSpecifications.successResponse())
                .extract()
                .response();
    }
    @Step("Отправить запрос на создание задачи без проверки")
    public void createIssueExpectBadRequest(IssueRequest issueRequest) {

        given()
                .spec(RequestSpecifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES)
                .then()
                .spec(ResponseSpecifications.badRequestResponse())
                .extract()
                .response();
    }

    @Step("Отправить запрос на получение задачи: {issueId}")
    public Response getIssue(String issueId) {

        return given()
                .spec(RequestSpecifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .when()
                .get(ApiEndpoints.ISSUES + "/" + issueId)
                .then()
                .spec(ResponseSpecifications.successResponse())
                .extract()
                .response();
    }


    @Step("Отправить запрос на обновление задачи: {issueId}")
    public Response updateIssue(String issueId, IssueRequest issueRequest) {

        return given()
                .spec(RequestSpecifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES + "/" + issueId)
                .then()
                .spec(ResponseSpecifications.successResponse())
                .extract()
                .response();
    }


    @Step("Отправить запрос на удаление задачи: {issueId}")
    public Response deleteIssue(String issueId) {

         return given()
                .spec(RequestSpecifications.requestSpecification())
                .when()
                .delete(ApiEndpoints.ISSUES + "/" + issueId)
                .then()
                .spec(ResponseSpecifications.successResponse())
                .extract()
                .response();
    }
    @Step("Проверить что задача не найдена: {issueId}")
    public void getDeletedIssue(String issueId) {

        given()
                .spec(RequestSpecifications.requestSpecification())
                .when()
                .get(ApiEndpoints.ISSUES + "/" + issueId)
                .then()
                .spec(ResponseSpecifications.notFoundResponse())
                .extract()
                .response();
    }
}