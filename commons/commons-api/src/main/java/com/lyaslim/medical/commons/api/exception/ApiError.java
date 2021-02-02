package com.lyaslim.medical.commons.api.exception;

import lombok.Value;

import java.util.List;

@Value(staticConstructor="of")
public class ApiError {

    private String message;
    private List<String> details;

}
