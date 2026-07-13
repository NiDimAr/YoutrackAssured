package tests;

import dto.request.IssueRequest;
import dto.response.IssueResponse;
import factory.IssueFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Управление задачами")
@Feature("Получение задач")
@DisplayName("Получение")
@Owner("Дмитрий")
public class IssueReadTests extends BaseTest {

    @Test
    @Story("Пользователь получает задачу по идентификатору")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Получение задачи по ID")
    void shouldGetIssueById() {

        IssueRequest request = IssueFactory.create(
                "Get Issue " + java.util.UUID.randomUUID(),
                "Check GET by id"
        );

        String issueId = issueService.createIssue(request);

        IssueResponse issue = issueService.getIssueById(issueId);

        assertEquals(
                issueId,
                issue.getId()
        );
    }
}