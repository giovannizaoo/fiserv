package com.fiserv.steps.firservFuncionalidades.services;

import com.fiserv.utils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicesApiSteps {

    AuthToken authToken = new AuthToken();

    Uuid uuid = new Uuid();

    Response validarResponse;

    @When("prencho todos os campos obrigatorios do endpoint services utilizando o ambiente cat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_services_utilizando_o_ambiente_cat() throws Exception {

        String timestamp = String.valueOf(System.currentTimeMillis());

        String rawData = String.format("%s:%s:%s", ApiKey.getApiKey(), timestamp, uuid.getRequestUuid());

        String signature = Hmac.generateHmac(ClientSecret.getClientSecret(), rawData);

        validarResponse = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .header("client_secret", ClientSecret.getClientSecret())
                .header("x-client-request-id", uuid.getRequestUuid())
                .header("User-Agent", "PostmanRuntime/7.49.0")
                .header("apikey", ApiKey.getApiKey())
                .header("Connection", "keep-alive")
                .header("Timestamp", timestamp)
                .header("x-hmac-signature", signature)
                .header("apikey", ApiKey.getApiKey())
                .header("Authorization", "Bearer " + authToken.getAccessTokenCat())
                .get("/api/v1/application/services") //Verificar Url
                .prettyPeek();

    }

    @When("prencho todos os campos obrigatorios do endpoint services utilizando o ambiente uat")
    public void prencho_todos_os_campos_obrigatorios_do_endpoint_services_utilizando_o_ambiente_uat() {

        validarResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("apikey", ApiKey.getApiKey())
                .header("Authorization", "Bearer " + authToken.getAccessTokenUat())
                .get("/api/v1/application/services") //Verificar Url
                .prettyPeek();

    }

    @Then("a Api do endpoint services devera retornar status code {int} com os dados esperados no corpo da resposta")
    public void a_api_do_endpoint_services_devera_retornar_status_code_com_os_dados_esperados_no_corpo_da_resposta(Integer statusCodeEsperado) {

        assertEquals((int) statusCodeEsperado, validarResponse.getStatusCode());

    }
}
