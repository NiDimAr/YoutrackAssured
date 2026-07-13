package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import factory.IssueFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Управление задачами")
@Feature("Обновление задач")
@DisplayName("Обновление")
@Owner("Дмитрий")
public class IssueUpdateTests extends BaseTest {

    @Test
    @Story("Пользователь изменяет данные существующей задачи")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Обновление задачи")
    void shouldUpdateIssue() {

        IssueRequest createRequest = IssueFactory.create(
                "Original " + java.util.UUID.randomUUID(),
                "Original description"
        );

        String issueId = issueService.createIssue(createRequest);

        IssueRequest updateRequest = IssueFactory.create(
                "Updated Summary",
                "Updated description"
        );

        Response updateResponse = issueService.updateIssue(
                issueId,
                updateRequest
        );

        updateResponse.then()
                .statusCode(200);

        Response getResponse = issueService.getIssue(issueId);

        IssueResponse updated = getResponse.as(IssueResponse.class);

        assertEquals(
                "Updated Summary",
                updated.getSummary()
        );
    }
}