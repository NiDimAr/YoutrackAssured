package client;

import config.ApiEndpoints;
import config.ApiFields;
import dto.request.IssueRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class IssueClient {

    public Response createIssue(IssueRequest issueRequest) {

        return given()
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES);
    }

    public Response getIssue(String issueId) {

        return given()
                .queryParam("fields", ApiFields.ISSUE)
                .when()
                .get(ApiEndpoints.ISSUES + "/" + issueId);
    }


    public Response updateIssue(String issueId, IssueRequest issueRequest) {

        return given()
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES + "/" + issueId);
    }

    public Response deleteIssue(String issueId) {

        return given()
                .when()
                .delete(ApiEndpoints.ISSUES + "/" + issueId);
    }
}