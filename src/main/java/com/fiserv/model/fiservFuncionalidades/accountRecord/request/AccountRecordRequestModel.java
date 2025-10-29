package com.fiserv.model.fiservFuncionalidades.accountRecord.request;

import java.util.HashMap;
import java.util.Map;

public class AccountRecordRequestModel {

    private final Map<String, String> accountRecordRequestModel;

    public AccountRecordRequestModel() {
        accountRecordRequestModel = new HashMap<>();
        accountRecordRequestModel.put("accountType", "170");
        accountRecordRequestModel.put("accountCurrency", "USD");

    }

    public Map<String, String> getAccountRecordRequestModel() {
        return accountRecordRequestModel;

    }
}
