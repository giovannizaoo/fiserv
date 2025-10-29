package com.fiserv.model.fiservFuncionalidades.referenceFields.request;

import java.util.HashMap;
import java.util.Map;

public class ReferenceFieldsRequestModel {

    private final Map<String, String> referenceFieldsRequestModel;

    public ReferenceFieldsRequestModel() {
        referenceFieldsRequestModel = new HashMap<>();
        referenceFieldsRequestModel.put("groupLevel", "4");
        referenceFieldsRequestModel.put("countryCode", "BHS");

    }

    public Map<String, String> getReferenceFieldsRequestModel() {
        return referenceFieldsRequestModel;

    }
}
