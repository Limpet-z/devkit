package com.devKit.devkit.model;

import java.util.UUID;

public class XUserBuilder {
    private static XUserBuilder instance = new XUserBuilder();
    private String id = null;
    private String description = "";

    private XUserBuilder() {
    }

    public static XUserBuilder create() {
        return instance;
    }

    public XUserBuilder withId(String id) {
        this.id = id;
        return instance;
    }

    public XUser build() {
        XUser result = new XUser(this.description);
        if (id != null)
            result.setId(id);
        return result;
    }
}
