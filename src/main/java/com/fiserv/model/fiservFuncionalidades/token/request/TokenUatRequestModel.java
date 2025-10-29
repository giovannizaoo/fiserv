package com.fiserv.model.fiservFuncionalidades.token.request;

public class TokenUatRequestModel {

    private static final String GRANT_TYPE = "password";
    private static final String CLIENT_ID = "boarding-ui";
    private static final String USERNAME = "novigi_api_user";
    private static final String PASSWORD = "N19sUb#Bor8Digahg";

    public static String getGrantType() {
        return GRANT_TYPE;
    }

    public static String getClientId() {
        return CLIENT_ID;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
