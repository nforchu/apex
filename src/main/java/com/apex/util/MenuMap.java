package com.apex.util;

import java.util.HashMap;
import java.util.Map;

public class MenuMap {

    private Map<String, String> menu = new HashMap<> ();

    public Map<String, String> get() {
        return menu;
    }

    public MenuMap addPair(String key, String value) {
        this.menu.put(key, value);
        return this;
    }
}
