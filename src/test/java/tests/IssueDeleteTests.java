package tests;

import dto.request.IssueRequest;
import factory.IssueFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueDeleteTests extends BaseTest {

    @Test
    void shouldDeleteIssue() {

        IssueRequest request = IssueFactory.create(
                "Delete Test " + java.util.UUID.randomUUID(),
                "Will be deleted"
        );


        String issueId = issueService.createIssue(request);


        Response deleteResponse = issueClient.deleteIssue(issueId);


        deleteResponse.then()
                .statusCode(200);


        Response getResponse = issueClient.getIssue(issueId);


        assertEquals(
                404,
                getResponse.statusCode()
        );
    }
}