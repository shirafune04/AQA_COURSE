import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

class PostmanEchoRequestMethodsTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        var response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();

        // ИСПРАВЛЕНО: JUnit assert'ы вместо Hamcrest matchers
        assertEquals("bar1", response.path("args.foo1"));
        assertEquals("bar2", response.path("args.foo2"));
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2",
                response.path("url"));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "{\"test\":\"value\"}";

        var response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();

        String data = response.path("data");
        assertTrue(data.contains("test"));
        assertTrue(data.contains("value"));

        String contentType = response.path("headers.content-type");
        assertTrue(contentType.contains("text/plain"));

        assertEquals("https://postman-echo.com/post", response.path("url"));
    }

    @Test
    public void testPostFormData() {
        var response = given()
                .contentType(ContentType.MULTIPART)
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();
        assertEquals("bar1", response.path("form.foo1"));
        assertEquals("bar2", response.path("form.foo2"));
        assertEquals("https://postman-echo.com/post", response.path("url"));
    }
    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        var response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();

        assertEquals(requestBody, response.path("data"));
        assertEquals("https://postman-echo.com/put", response.path("url"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        var response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();

        assertEquals(requestBody, response.path("data"));
        assertEquals("https://postman-echo.com/patch", response.path("url"));
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        var response = given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract();

        // ИСПРАВЛЕНО: JUnit assert'ы
        assertEquals(requestBody, response.path("data"));
        assertEquals("https://postman-echo.com/delete", response.path("url"));
    }
}
