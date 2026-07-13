package tests;

import dto.request.IssueRequest;
import factory.IssueFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        issueService.deleteIssue(issueId);

        issueService.getDeletedIssue(issueId);

    }
}