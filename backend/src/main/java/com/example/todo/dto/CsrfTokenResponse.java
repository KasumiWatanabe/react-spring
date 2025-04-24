package com.example.todo.dto;

public class CsrfTokenResponse {

    private final String csrfTokenHeaderName;
    private final String csrfTokenValue;

    public CsrfTokenResponse(String csrfTokenHeaderName, String csrfTokenValue) {
        this.csrfTokenHeaderName = csrfTokenHeaderName;
        this.csrfTokenValue = csrfTokenValue;
    }

    public String getCsrfTokenHeaderName() {
        return csrfTokenHeaderName;
    }

    public String getCsrfTokenValue() {
        return csrfTokenValue;
    }
}