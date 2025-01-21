import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

class ApiUtils {

    public static RequestSpecification createRequest() {
        return RestAssured.given();
    }

    public static void printResponseDetails(Response response) {
        System.out.println("Response status code: " + response.getStatusCode());
        Headers headers = response.getHeaders();
        System.out.println("Headers: " + headers);
        ResponseBody body = response.getBody();
        body.prettyPrint();
        System.out.println("Response Body: " + body.asString());
    }

    public static void setBaseUri(String baseUri) {
        RestAssured.baseURI = baseUri;
    }
}