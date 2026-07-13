package service;

import client.IssueClient;
import dto.request.IssueRequest;
import dto.response.IssueResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class IssueService {
    private final IssueClient issueClient;


    public IssueService() {
        this.issueClient = new IssueClient();
    }


    @Step("Создать задачу")
    public String createIssue(IssueRequest request) {

        Response response = issueClient.createIssue(request);

        return response.as(IssueResponse.class)
                .getId();
    }


    @Step("Получить задачу по id: {issueId}")
    public IssueResponse getIssueById(String issueId) {

        Response response = issueClient.getIssue(issueId);

        return response.as(IssueResponse.class);
    }


    @Step("Создать задачу с невалидными данными")
    public void createIssueExpectBadRequest(IssueRequest request) {

        issueClient.createIssueExpectBadRequest(request);
    }


    @Step("Обновить задачу с id: {issueId}")
    public void updateIssue(String issueId, IssueRequest request) {

        issueClient.updateIssue(issueId, request);
    }


    @Step("Удалить задачу с id: {issueId}")
    public void deleteIssue(String issueId) {

        issueClient.deleteIssue(issueId);
    }
    @Step("Проверить что задача не найдена: {issueId}")
    public void getDeletedIssue(String issueId) {

        issueClient.getDeletedIssue(issueId);
    }

}
