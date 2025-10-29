package com.fiserv.model.fiservFuncionalidades.merchantProperties.request;

import java.util.HashMap;
import java.util.Map;

public class MerchantPropertiesRequestModel {

    private final Map<String, String> merchantPropertiesRequestModel;

    public MerchantPropertiesRequestModel() {
        merchantPropertiesRequestModel = new HashMap<>();
        merchantPropertiesRequestModel.put("countryCode", "VGB");
        merchantPropertiesRequestModel.put("groupLevel", "4");

    }

    public Map<String, String> getMerchantPropertiesRequestModel() {
        return merchantPropertiesRequestModel;

    }
}
