package com.purusottam.softwarecatalogue.exception;

public enum ErrorCode {

    PUBLISHER_NOT_FOUND("Publisher not found", 400), PRODUCT_NOT_FOUND("Product not found", 400), VERSION_NOT_FOUND("Version not found", 400), PRODUCT_EDITION_NOT_FOUND("ProductEdition not found", 400), SYSTEM_REQUIREMENT_NOT_FOUND(
            "System Requirment not found", 400), INSTALLATION_DETAILS_NOT_FOUND("Installation Details not found", 400), LICENSE_NOT_FOUND("License not found", 400), PUBLISHER_IS_EXIST("Publisher is exist ",
            401), PRODUCT_IS_EXIST("Product is exist ", 401), VERSION_IS_EXIST("version is exist ", 401), PRODUCT_EDITION_IS_EXIST("Production edition is exist ", 401), SYSTEM_REQUIRMENT_IS_EXIST("System Requirment is exist ",
            401), INSTALLATION_DETAILS_IS_EXIST("Installation Details is exist ", 400), LICENSE_IS_EXIST("License is exist ",
            401), CATEGORY_NOR_FOUND("Category not found ", 400), CATEGORY_IS_EXIST("Category is exist", 401), SUB_CATEGORY_NOR_FOUND("Category not found ", 400), SUB_CATEGORY_IS_EXIST("Category is exist", 401);

    private String message;
    private int errorCode;

    private ErrorCode(String message) {
        this.message = message;
    }

    private ErrorCode(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
