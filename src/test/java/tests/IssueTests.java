package tests;

import dto.response.IssueResponse;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv", numLinesToSkip = 1)
    void shouldCreateIssue(String summary, String description) {

        String uniqueSummary = summary + " " + java.util.UUID.randomUUID();

        Response response = issueClient.createIssue(
                createIssueRequest(uniqueSummary, description)
        );

        response.then().statusCode(200);

        IssueResponse issue = response.as(IssueResponse.class);

        assertEquals(uniqueSummary, issue.getSummary());
    }
}