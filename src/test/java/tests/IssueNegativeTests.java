package tests;

import dto.request.IssueRequest;
import factory.IssueFactory;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class IssueNegativeTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/negative_issues.csv", numLinesToSkip = 1)
    void shouldNotCreateIssue(String summary, String description) {

        IssueRequest request = IssueFactory.create(
                summary,
                description
        );


        Response response = issueClient.createIssue(request);


        response.then()
                .log()
                .all()
                .statusCode(400);
    }
}