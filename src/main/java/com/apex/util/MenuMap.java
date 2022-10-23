package com.apex.util;

import java.util.HashMap;
import java.util.Map;

public class MenuMap {

	private String title;
    private Map<String, String> menu = new HashMap<> ();

    public Map<String, String> getMap() {
        return menu;
    }

    public MenuMap addPair(String key, String value) {
        this.menu.put(key, value);
        return this;
    }

	public String getTitle() {
		return title;
	}

	public MenuMap setTitle(String title) {
		this.title = title;
		return this;
	}
    
    
}
