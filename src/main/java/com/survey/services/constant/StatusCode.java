
package com.survey.services.constant;

public enum StatusCode {
    OK(0, "ok"), INTERNAL_SERVER_ERROR(-1, "Internal server error"), BAD_REQUEST(-2, "Bad Request");

    private Integer code;
    private String description;

    private StatusCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
    
}
