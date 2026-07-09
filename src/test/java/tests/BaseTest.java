package tests;

import client.IssueClient;
import config.ConfigProvider;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import service.IssueService;

public class BaseTest {
    protected IssueClient issueClient;
    protected IssueService issueService;


    @BeforeAll
    static void setup() {

        RestAssured.baseURI = ConfigProvider.CONFIG.baseUrl();

    }


    @BeforeEach
    void init() {
        issueService = new IssueService();
        issueClient = new IssueClient();
    }
}
