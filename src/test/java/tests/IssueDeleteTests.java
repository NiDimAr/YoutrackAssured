package tests;

import dto.request.IssueRequest;
import factory.IssueFactory;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Управление задачами")
@Feature("Удаление задач")
@DisplayName("Удаление")
@Owner("Дмитрий")
public class IssueDeleteTests extends BaseTest {

    @Test
    @Story("Пользователь удаляет существующую задачу")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление задачи")
    void shouldDeleteIssue() {

        IssueRequest request = IssueFactory.create(
                "Delete Test " + java.util.UUID.randomUUID(),
                "Will be deleted"
        );

        String issueId = issueService.createIssue(request);

        Response deleteResponse = issueService.deleteIssue(issueId);

        deleteResponse.then()
                .statusCode(200);

        Response getResponse = issueService.getIssue(issueId);

        assertEquals(
                404,
                getResponse.statusCode()
        );
    }
}