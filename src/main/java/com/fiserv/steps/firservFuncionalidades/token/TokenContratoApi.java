package com.fiserv.steps.firservFuncionalidades.token;

import com.fiserv.model.fiservFuncionalidades.token.request.TokenUatRequestModel;
import com.fiserv.model.fiservFuncionalidades.token.response.Token200ResponseModel;
import com.fiserv.utils.ApiKey;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TokenContratoApi {

    Response validarResponse;

    Token200ResponseModel token200ResponseModel;

    @Then("valido o contrato da Api do endpoint token devera retornar status code {int} com os dados esperados no corpo da resposta")
    public void valido_o_contrato_da_api_do_endpoint_token_devera_retornar_status_code_com_os_dados_esperados_no_corpo_da_resposta(Integer int1) {

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

        token200ResponseModel = validarResponse.as(Token200ResponseModel.class);

        validarResponse.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/funcionalidadesFiserv/EndpointTokenStatusCode200.json"));

    }

}
