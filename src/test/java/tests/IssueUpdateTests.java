package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueUpdateTests extends BaseTest {

    @Test
    void shouldUpdateIssue() {

        String issueId = createIssue(
                "Original " + java.util.UUID.randomUUID(),
                "Original description"
        );

        IssueRequest updateRequest = createIssueRequest(
                "Updated Summary",
                "Updated description"
        );

        Response updateResponse = issueClient.updateIssue(issueId, updateRequest);

        updateResponse.then().statusCode(200);

        Response getResponse = issueClient.getIssue(issueId);

        IssueResponse updated = getResponse.as(IssueResponse.class);

        assertEquals("Updated Summary", updated.getSummary());
    }
}