package com.fiserv.utils;

import com.fiserv.model.fiservFuncionalidades.token.request.TokenCatRequestModel;
import com.fiserv.model.fiservFuncionalidades.token.request.TokenUatRequestModel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class AuthToken {

    private String accessTokenUat;

    private String accessTokenCat;

    private final String clientSecret = "2O1HGIbfbQcyFw3TDnr1dnp8Wz69YxYQfMfAdrx9YQT";

    private final String clientKey = ApiKey.getApiKey();

    private Response validarResponse;

    // 🔹 Gera assinatura HMAC-SHA256 Base64
    private static String generateHmac(String secret, String data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        mac.init(secretKeySpec);
        return Base64.getEncoder().encodeToString(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    public String getAccessTokenUat() {

        this.accessTokenUat = RestAssured
                .given()
                .contentType(ContentType.URLENC)
                .baseUri("https://uat-merchant-services.fiservapp.com/boarding-ui")
                .headers("apikey", ApiKey.getApiKey())
                .formParam("grant_type", TokenUatRequestModel.getGrantType())
                .formParam("client_id", TokenUatRequestModel.getClientId())
                .formParam("username", TokenUatRequestModel.getUsername())
                .formParam("password", TokenUatRequestModel.getPassword())
                .post("/external-api/token")
                        .path("access_token");

                return this.accessTokenUat;

    }

    public String getAccessTokenCat() throws Exception {

        // Base URL
        RestAssured.baseURI = "https://cat.latam.api.fiservapps.com/merchant/boarding";

        String requestUuid = UUID.randomUUID().toString();
        String timestamp = String.valueOf(System.currentTimeMillis());

        // Para /token -> não incluir o corpo no rawData
        String rawData = String.format("%s:%s:%s", clientKey, timestamp, requestUuid);

        // Gera assinatura
        String signature = generateHmac(clientSecret, rawData);

        // Executa requisição
        this.accessTokenCat = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType("application/x-www-form-urlencoded")
                .header("client_secret", clientSecret)
                .header("x-client-request-id", requestUuid)
                .header("User-Agent", "PostmanRuntime/7.49.0")
                .header("apikey", clientKey)
                .header("Connection", "keep-alive")
                .header("Timestamp", timestamp)
                .header("x-hmac-signature", signature)
                .formParam("grant_type", TokenCatRequestModel.getGrantType())
                .formParam("client_id", TokenCatRequestModel.getClientId())
                .formParam("username", TokenCatRequestModel.getUsername())
                .formParam("password", TokenCatRequestModel.getPassword())
                .log().all()
                .post("/token")
                .prettyPeek()
                .path("access_token");

        return this.accessTokenCat;

    }


}
