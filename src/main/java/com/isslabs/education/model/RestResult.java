package com.isslabs.education.model;

/**
 * Encapsulates the response given by the Controller. trying with no serializable & no toString
 */

public class RestResult {

    private String code;
    private String message;
    private String url;

    /**
     * TODO: Delete
     */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
