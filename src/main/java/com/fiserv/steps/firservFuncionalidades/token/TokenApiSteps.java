package com.fiserv.steps.firservFuncionalidades.token;

import com.fiserv.model.fiservFuncionalidades.token.request.TokenCatRequestModel;
import com.fiserv.model.fiservFuncionalidades.token.request.TokenUatRequestModel;
import com.fiserv.model.fiservFuncionalidades.token.response.Token200ResponseModel;
import com.fiserv.utils.ApiKey;
import com.fiserv.utils.ClientSecret;
import com.fiserv.utils.Hmac;
import com.fiserv.utils.Uuid;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class TokenApiSteps {

    Uuid uuid = new Uuid();

    private Response validarResponse;

    @When("prencho todos os campos obrigatorios do endpoint token cat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_token_cat() throws Exception {

        String timestamp = String.valueOf(System.currentTimeMillis());

        String rawData = String.format("%s:%s:%s", ApiKey.getApiKey(), timestamp, uuid.getRequestUuid());

        String signature = Hmac.generateHmac(ClientSecret.getClientSecret(), rawData);

        validarResponse = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .header("client_secret", ClientSecret.getClientSecret())
                .header("User-Agent", "PostmanRuntime/7.49.0")
                .header("apikey", ApiKey.getApiKey())
                .header("Connection", "keep-alive")
                .header("Timestamp", timestamp)
                .header("x-hmac-signature", signature)
                .header("x-client-request-id", uuid.getRequestUuid())
                .formParam("grant_type", TokenCatRequestModel.getGrantType())
                .formParam("client_id", TokenCatRequestModel.getClientId())
                .formParam("username", TokenCatRequestModel.getUsername())
                .formParam("password", TokenCatRequestModel.getPassword())
                .log().all()
                .post("/token")
                .prettyPeek();

    }

    @When("prencho todos os campos obrigatorios do endpoint token uat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_token_uat() {

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.URLENC)
                .log().all()
                .headers("apikey", ApiKey.getApiKey())
                .formParam("grant_type", TokenUatRequestModel.getGrantType())
                .formParam("client_id", TokenUatRequestModel.getClientId())
                .formParam("username", TokenUatRequestModel.getUsername())
                .formParam("password", TokenUatRequestModel.getPassword())
                .post("/token")
                .prettyPeek();

    }

    @Then("a Api do endpoint token devera retornar status code {int} com os dados esperados no corpo da resposta")
    public void a_api_do_endpoint_token_devera_retornar_status_code_com_os_dados_esperados_no_corpo_da_resposta(Integer statusCodeEsperado) {

        assertEquals((int) statusCodeEsperado, validarResponse.getStatusCode());

        if (statusCodeEsperado == 200) {

            Token200ResponseModel token200ResponseModel =
                    validarResponse.as(Token200ResponseModel.class);

            assertEquals("Bearer", token200ResponseModel.getTokenType());
            assertEquals(1800, token200ResponseModel.getExpiresIn());
            assertEquals(3600, token200ResponseModel.getRefreshExpiresIn());

            assertNotNull(token200ResponseModel.getAccessToken());
            assertNotNull(token200ResponseModel.getRefreshToken());
            assertFalse(token200ResponseModel.getRefreshToken().isEmpty());

        }

    }

}
