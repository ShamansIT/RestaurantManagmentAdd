package com.example.demo.model;

import java.util.HashMap;

final public class Text {
    private static final HashMap<String, String> data = new HashMap<>();
    public static String get(String key) {
        return data.get(key);
    }

    public static void initText() {
        data.put("ERROR_TITLE_EMPTY", "Please enter correct PIN!");
        data.put("ERROR_IS_EXIST_ACCOUNT", "This record already exists");
        data.put("ERROR_IS_EMPTY_FIELD", "Field empty!");

    }
}