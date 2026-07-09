package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import factory.IssueFactory;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueCreateTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv", numLinesToSkip = 1)
    void shouldCreateIssue(String summary, String description) {


        String uniqueSummary = summary + " " + java.util.UUID.randomUUID();


        IssueRequest request = IssueFactory.create(
                uniqueSummary,
                description
        );


        String issueId = issueService.createIssue(request);

        Response response = issueClient.getIssue(issueId);

        response.then()
                .statusCode(200);

        IssueResponse issue = response.as(IssueResponse.class);

        assertEquals(uniqueSummary, issue.getSummary());
    }
}