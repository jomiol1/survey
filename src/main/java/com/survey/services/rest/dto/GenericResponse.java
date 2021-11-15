
package com.survey.services.rest.dto;

import lombok.Data;

@Data
public class GenericResponse<T> {
    private Integer statusCode;
    private String message;
    private T data;
     
}
