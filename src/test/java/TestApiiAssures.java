import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiiAssures {

    @Test()
    public void testAss() {
        given()
                .when()
                .get("https://qauto.forstudy.space/api/cars/brands")
                .then().log().all()
                .assertThat().statusCode(200)
                 .body("data[0].id", equalTo(1))
                .body("data[0].title", equalTo("Audi"));
    }
}
