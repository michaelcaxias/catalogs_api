package com.michaelcaxias.catalogs.api.src.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourceConfig {
    public static final String API_VERSION = "v1";
    public static final String ROOT_PATH = "/catalogs-api/" + API_VERSION;
}
