package com.fiserv.model.fiservFuncionalidades.mcc.request;

import java.util.HashMap;
import java.util.Map;

public class MccRequestModel {

    private final Map<String, String> mccRequestModel;

    public MccRequestModel() {
        mccRequestModel = new HashMap<>();
        mccRequestModel.put("page", "0");
        mccRequestModel.put("pageSize", "9999999");
    }

    public Map<String, String> getMccRequestModel() {
        return mccRequestModel;
    }
}
