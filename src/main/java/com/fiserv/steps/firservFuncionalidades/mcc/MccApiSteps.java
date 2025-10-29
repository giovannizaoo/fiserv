package com.fiserv.steps.firservFuncionalidades.mcc;

import com.fiserv.model.fiservFuncionalidades.mcc.request.MccRequestModel;
import com.fiserv.utils.ApiKey;
import com.fiserv.utils.AuthToken;
import com.fiserv.utils.ClientSecret;
import com.fiserv.utils.Hmac;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MccApiSteps {

    AuthToken authToken = new AuthToken();

    MccRequestModel mccRequestModel = new MccRequestModel();

    Response validarResponse;

    @When("prencho todos os campos obrigatorios do endpoint reference mcc utilizando o ambiente cat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_reference_mcc_utilizando_o_ambiente_cat() throws Exception {

        String requestUuid = UUID.randomUUID().toString();

        String timestamp = String.valueOf(System.currentTimeMillis());

        String rawData = String.format("%s:%s:%s", ApiKey.getApiKey(), timestamp, requestUuid);

        String signature = Hmac.generateHmac(ClientSecret.getClientSecret(), rawData);

        validarResponse = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .header("client_secret", ClientSecret.getClientSecret())
                .header("x-client-request-id", requestUuid)
                .header("User-Agent", "PostmanRuntime/7.49.0")
                .header("apikey", ApiKey.getApiKey())
                .header("Connection", "keep-alive")
                .header("Timestamp", timestamp)
                .header("x-hmac-signature", signature)
                .header("x-client-request-id", requestUuid)
                .header("apikey", ApiKey.getApiKey())
                .header("Authorization", "Bearer " + authToken.getAccessTokenCat())
                .queryParams(mccRequestModel.getMccRequestModel())
                .get("/api/v1/application/mcc") //Verificar Url
                .prettyPeek();

    }

    @When("prencho todos os campos obrigatorios do endpoint reference mcc utilizando o ambiente uat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_reference_mcc_utilizando_o_ambiente_uat() {

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("apikey", ApiKey.getApiKey())
                .header("Authorization", "Bearer " + authToken.getAccessTokenUat())
                .queryParams(mccRequestModel.getMccRequestModel())
                .get("/api/v1/application/mcc") //Verificar Url
                .prettyPeek();

    }

    @Then("a Api do endpoint mcc devera retornar status code {int} com os dados esperados no corpo da resposta")
    public void a_api_do_endpoint_mcc_devera_retornar_status_code_com_os_dados_esperados_no_corpo_da_resposta(Integer statusCodeEsperado) {

        assertEquals((int) statusCodeEsperado, validarResponse.getStatusCode());

    }

}
