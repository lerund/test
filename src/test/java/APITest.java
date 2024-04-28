import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class APITest {
    @Test
    public void testGetUserDetails() {
        Response response = given()
                .baseUri("https://api.github.com")
                .when()
                .get("/users/octocat")
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.then()
                .body("login", equalTo("octocat"))
                .body("name", equalTo("The Octocat"))
                .body("public_repos", greaterThan(0))
                .body("followers", greaterThan(0))
                .body("following", greaterThan(0))
                .body("created_at", notNullValue())
                .body("updated_at", notNullValue())
                .body("location", equalTo("San Francisco"));
    }
    }

