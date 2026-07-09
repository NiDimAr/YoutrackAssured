package spec;

import config.ConfigProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class Specifications {

    private Specifications() {
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

