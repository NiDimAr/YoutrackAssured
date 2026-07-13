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

        response.then()
                .statusCode(200);

        return response.as(IssueResponse.class)
                .getId();
    }
    @Step("Получить задачу по id: {issueId}")
    public Response getIssue(String issueId) {

        return issueClient.getIssue(issueId);
    }
    @Step("Создать задачу с невалидными данными")
    public Response createIssueWithoutValidation(IssueRequest request) {

        return issueClient.createIssue(request);
    }

    @Step("Обновить задачу с id: {issueId}")
    public Response updateIssue(String issueId, IssueRequest request) {

        return issueClient.updateIssue(issueId, request);
    }


    @Step("Удалить задачу с id: {issueId}")
    public Response deleteIssue(String issueId) {

        return issueClient.deleteIssue(issueId);
    }
}
