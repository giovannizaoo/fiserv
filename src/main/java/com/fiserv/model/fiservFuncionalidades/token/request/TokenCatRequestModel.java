package com.fiserv.model.fiservFuncionalidades.token.request;

public class TokenCatRequestModel {

    private static final String GRANT_TYPE = "password";
    private static final String CLIENT_ID = "boarding-ui";
    private static final String USERNAME = "first_caribbean_qa";
    private static final String PASSWORD = "f1SerV#QA23";

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
