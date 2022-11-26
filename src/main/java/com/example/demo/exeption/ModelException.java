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
//        return switch (code) {
//            case TITLE_EMPTY -> Text.get("ERROR_TITLE_EMPTY");
//            case IS_EXIST -> Text.get("ERROR_IS_EXIST");
//            case DATE_FORMAT -> Text.get("ERROR_DATE_FORMAT");
//            case CODE_EMPTY -> Text.get("ERROR_CODE_EMPTY");
//            case CURRENCY_EMPTY -> Text.get("ERROR_CURRENCY_EMPTY");
//            case ARTICLE_EMPTY -> Text.get("ERROR_ARTICLE_EMPTY");
//            case ACCOUNT_EMPTY -> Text.get("ERROR_ACCOUNT_EMPTY");
//            case RATE_INCORRECT -> Text.get("ERROR_RATE_INCORRECT");
//            case AMOUNT_FORMAT -> Text.get("ERROR_AMOUNT_FORMAT");
//            case NO_BASE_CURRENCY -> Text.get("ERROR_NO_BASE_CURRENCY");
//            default -> "";
//        };

    }

}
