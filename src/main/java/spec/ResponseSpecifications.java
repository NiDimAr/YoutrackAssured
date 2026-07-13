package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ResponseSpecifications {

    private ResponseSpecifications() {
    }

    public static ResponseSpecification responseSpecification() {

        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .build();
    }
}
