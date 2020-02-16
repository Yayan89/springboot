package contracts;

import contracts.RestBase;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.Rule;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.RestAssured.*;

@SuppressWarnings("rawtypes")
public class ContractVerifierTest extends RestBase {

	@Test
	public void validate_mocktest() throws Exception {
		// given:
			RequestSpecification request = given()
					.header("Content-Type", "application/json;charset=utf-8")
					.body("{\"client.id\":1234567890,\"loanAmount\":99999}");

		// when:
			Response response = given().spec(request)
					.put("/fraudcheck");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).isEqualTo("application/json;charset=utf-8");

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['fraudCheckStatus']").isEqualTo("FRAUD");
			assertThatJson(parsedJson).field("['rejection.reason']").isEqualTo("Amount too high");
	}

}
