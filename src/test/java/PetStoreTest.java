import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PetStoreTest {

    TestRequirements requirements = new TestRequirements();
    private static final String BASE_URI = "https://petstore.swagger.io";

    @Test
    public void getPetTest() {
        ApiUtils.setBaseUri(BASE_URI);
        RequestSpecification request = ApiUtils.createRequest();
        Response response = request.request(Method.GET, "/v2/pet/1");
        ApiUtils.printResponseDetails(response);
    }

    @Test
    public void postPetTest() {
        ApiUtils.setBaseUri(BASE_URI);
        String requestBody = requirements.getSamplePetPayload("doggie", "available");
        requirements.executePostRequest("/v2/pet", requestBody);
    }

    @Test
    public void putPetTest() {
        ApiUtils.setBaseUri(BASE_URI);
        String requestBody = requirements.getSamplePetPayload("doggie2", "available");
        requirements.executePutRequest("/v2/pet", requestBody);
    }

    @Test
    public void getFindByStatusTestSold() {
        ApiUtils.setBaseUri(BASE_URI);
        requirements.executeFindByStatusTest("sold");
    }

    @Test
    public void getFindByStatusTestPending() {
        ApiUtils.setBaseUri(BASE_URI);
        requirements.executeFindByStatusTest("pending");
    }

    @Test
    public void getFindByStatusTestAvailable() {
        ApiUtils.setBaseUri(BASE_URI);
        requirements.executeFindByStatusTest("available");
    }

    @Test
    public void deletePetTest() {
        ApiUtils.setBaseUri(BASE_URI);
        requirements.executeDeleteRequest("/v2/pet/1");
    }
}