import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRequirements {

    public static final String BASE_URI = "https://petstore.swagger.io";

    public String getSamplePetPayload(String name, String status) {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
    }

    public void executePostRequest(String endpoint, String body) {
        RequestSpecification request = ApiUtils.createRequest();
        request.header("Content-Type", "application/json");
        Response response = request.body(body).post(endpoint);
        ApiUtils.printResponseDetails(response);
    }

    public void executePutRequest(String endpoint, String body) {
        RequestSpecification request = ApiUtils.createRequest();
        request.header("Content-Type", "application/json").header("accept", "application/json");
        Response response = request.body(body).put(endpoint);
        ApiUtils.printResponseDetails(response);
    }

    public void executeDeleteRequest(String endpoint) {
        RequestSpecification request = ApiUtils.createRequest();
        request.header("Content-Type", "application/json").header("accept", "application/json");
        Response response = request.delete(endpoint);
        ApiUtils.printResponseDetails(response);
    }

    public void executeFindByStatusTest(String status) {
        RequestSpecification request = ApiUtils.createRequest();
        Response response = request.request(Method.GET, "/v2/pet/findByStatus?status=" + status);
        ApiUtils.printResponseDetails(response);
    }
}
