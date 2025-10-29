package com.fiserv.pages;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class BaseApiPageCat {

    @Given("que seja iniciada a chamada da url base cat da funcionalidade fiserv funcionalidades")
    public void que_seja_iniciada_a_chamada_da_url_base_cat_da_funcionalidade_fiserv_funcionalidades() {

        RestAssured.baseURI = "https://cat.latam.api.fiservapps.com/merchant/boarding";

    }
}
