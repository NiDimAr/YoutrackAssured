package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import factory.IssueFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Управление задачами")
@Feature("Создание задач")
@DisplayName("Создание")
@Owner("Дмитрий")
public class IssueCreateTests extends BaseTest {

    @Story("Пользователь создает новую задачу")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание задачи с валидными данными")
    @ParameterizedTest
    @CsvFileSource(resources = "/issues.csv", numLinesToSkip = 1)
    void shouldCreateIssue(String summary, String description) {

        String uniqueSummary = summary + " " + java.util.UUID.randomUUID();

        IssueRequest request = IssueFactory.create(
                uniqueSummary,
                description
        );

        String issueId = issueService.createIssue(request);

        Response response = issueService.getIssue(issueId);

        response.then()
                .statusCode(200);

        IssueResponse issue = response.as(IssueResponse.class);

        assertEquals(uniqueSummary, issue.getSummary());
    }
}