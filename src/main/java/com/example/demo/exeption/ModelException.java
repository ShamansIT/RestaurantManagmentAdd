package com.example.demo.exeption;

import com.example.demo.model.Text;

public class ModelException extends Throwable {
    private final int code;

    public ModelException(int code){
        this.code=code;
    }

    public static final int INCORRECT_PIN = 1;
    public static final int IS_EXIST = 2;
    public static final int EMPTY_FIELD = 3;

    public String getMessage() {
        return switch (code) {
            case INCORRECT_PIN -> Text.get("ERROR_TITLE_EMPTY");
            case IS_EXIST -> Text.get("ERROR_IS_EXIST_ACCOUNT");
            case EMPTY_FIELD -> Text.get("ERROR_IS_EMPTY_FIELD");

            default -> "";
        };

    }

}
