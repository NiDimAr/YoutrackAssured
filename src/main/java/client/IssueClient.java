package client;

import config.ApiEndpoints;
import config.ApiFields;
import dto.request.IssueRequest;
import io.restassured.response.Response;
import spec.Specifications;

import static io.restassured.RestAssured.given;

public class IssueClient {

    public Response createIssue(IssueRequest issueRequest) {

        return given()
                .spec(Specifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES);
    }


    public Response getIssue(String issueId) {

        return given()
                .spec(Specifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .when()
                .get(ApiEndpoints.ISSUES + "/" + issueId);
    }


    public Response updateIssue(String issueId, IssueRequest issueRequest) {

        return given()
                .spec(Specifications.requestSpecification())
                .queryParam("fields", ApiFields.ISSUE)
                .body(issueRequest)
                .when()
                .post(ApiEndpoints.ISSUES + "/" + issueId);
    }


    public Response deleteIssue(String issueId) {

        return given()
                .spec(Specifications.requestSpecification())
                .when()
                .delete(ApiEndpoints.ISSUES + "/" + issueId);
    }
}