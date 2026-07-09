package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import factory.IssueFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueReadTests extends BaseTest {

    @Test
    void shouldGetIssueById() {


        IssueRequest request = IssueFactory.create(
                "Get Issue " + java.util.UUID.randomUUID(),
                "Check GET by id"
        );


        String issueId = issueService.createIssue(request);


        Response response = issueClient.getIssue(issueId);


        response.then()
                .statusCode(200);


        IssueResponse issue = response.as(IssueResponse.class);


        assertEquals(issueId, issue.getId());
        }
    }
