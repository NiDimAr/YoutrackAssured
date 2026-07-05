package tests;

import config.ConfigProvider;
import dto.request.IssueRequest;
import dto.request.ProjectDto;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IssueNegativeTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/negative_issues.csv", numLinesToSkip = 1)
    void shouldNotCreateIssue(String summary, String description) {

        IssueRequest request = new IssueRequest(
                summary,
                description,
                new ProjectDto(ConfigProvider.CONFIG.projectId())
        );

        Response response = issueClient.createIssue(request);
        response.then().log().all();
        assertTrue(response.statusCode() >= 400);
    }
}