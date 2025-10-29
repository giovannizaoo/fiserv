package com.fiserv.model.fiservFuncionalidades.hierarchy.request;

import java.util.HashMap;
import java.util.Map;

public class HierarchyRequestModel {

    private final Map<String, String> hierarchyRequestModel;

    public HierarchyRequestModel() {

        hierarchyRequestModel = new HashMap<>();
        hierarchyRequestModel.put("companyNameOrMID", "920");
        hierarchyRequestModel.put("merchantLevelCode", "3");
        hierarchyRequestModel.put("page", "0");
        hierarchyRequestModel.put("pageSize", "100");

    }

    public Map<String, String> getHierarchyRequestModel() {
        return hierarchyRequestModel;

    }
}
