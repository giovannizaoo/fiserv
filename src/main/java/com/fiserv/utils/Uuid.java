package com.fiserv.utils;

import java.util.UUID;

public class Uuid {

    private final String requestUuid = UUID.randomUUID().toString();

    public String getRequestUuid() {
        return requestUuid;
    }
}
