package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueDeleteTests extends BaseTest {

    @Test
    void shouldDeleteIssue() {

        String issueId = createIssue(
                "Delete Test " + java.util.UUID.randomUUID(),
                "Will be deleted"
        );

        Response deleteResponse = issueClient.deleteIssue(issueId);

        deleteResponse.then().statusCode(200);

        Response getResponse = issueClient.getIssue(issueId);

        assertEquals(404, getResponse.statusCode());
    }
}