package service;

import client.IssueClient;
import dto.request.IssueRequest;
import dto.response.IssueResponse;
import io.restassured.response.Response;

public class IssueService {
    private final IssueClient issueClient;


    public IssueService() {
        this.issueClient = new IssueClient();
    }


    public String createIssue(IssueRequest request) {

        Response response = issueClient.createIssue(request);

        response.then()
                .statusCode(200);

        return response.as(IssueResponse.class)
                .getId();
    }
}
