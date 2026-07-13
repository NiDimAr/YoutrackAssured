package tests;

import dto.request.IssueRequest;
import factory.IssueFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Epic("Управление задачами")
@Feature("Создание задач")
@DisplayName("Негативное создание")
@Owner("Дмитрий")
public class IssueNegativeTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/negative_issues.csv", numLinesToSkip = 1)
    @Story("Пользователь не может создать задачу с невалидными данными")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Негативное создание задачи")
    void shouldNotCreateIssue(String summary, String description) {

        IssueRequest request = IssueFactory.create(
                summary,
                description
        );

        Response response = issueService.createIssueWithoutValidation(request);

        response.then()
                .log()
                .all()
                .statusCode(400);
    }
}