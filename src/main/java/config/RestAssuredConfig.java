package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RestAssuredConfig {

    private RestAssuredConfig() {
    }

    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()

                .setContentType(JSON)

                .addHeader(
                        "Authorization",
                        "Bearer " + ConfigProvider.CONFIG.token()
                )

                .build();
    }
}

