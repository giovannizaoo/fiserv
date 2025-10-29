package com.fiserv.pages;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class BaseApiPageUat {

    @Given("que seja iniciada a chamada da url base uat da funcionalidade fiserv funcionalidades")
    public void que_seja_iniciada_a_chamada_da_url_base_uat_da_funcionalidade_fiserv_funcionalidades() {

        RestAssured.baseURI = "https://uat-merchant-services.fiservapp.com/boarding-ui/external-api";

    }
}
