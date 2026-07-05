package tests;

import client.IssueClient;
import config.ConfigProvider;
import config.RestAssuredConfig;
import dto.request.IssueRequest;
import dto.request.ProjectDto;
import dto.response.IssueResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected IssueClient issueClient;


    @BeforeAll
    static void setup() {
        RestAssured.baseURI = ConfigProvider.CONFIG.baseUrl();
        RestAssured.requestSpecification =
                RestAssuredConfig.requestSpecification();
    }

    @BeforeEach
    void init() {
        issueClient = new IssueClient();
    }

    protected IssueRequest createIssueRequest(String summary, String description) {
        return new IssueRequest(
                summary,
                description,
                new ProjectDto(ConfigProvider.CONFIG.projectId())
        );
    }

    protected String createIssue(String summary, String description) {

        Response response = issueClient.createIssue(
                createIssueRequest(summary, description)
        );

        response.then().statusCode(200);

        return response.as(IssueResponse.class).getId();
    }
}
