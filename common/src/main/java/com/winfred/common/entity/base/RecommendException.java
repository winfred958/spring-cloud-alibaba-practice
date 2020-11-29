package com.winfred.common.entity.base;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RecommendException extends RuntimeException {


    private static final long serialVersionUID = -2419186112996851702L;
    @Getter
    @Setter
    private ExceptionResponse response;

    public RecommendException(EnumResponseType exceptionType) {
        super(exceptionType.getMessage());
        this.response = ExceptionResponse.sendException(exceptionType);
    }

    public RecommendException(Throwable throwable) {
        super(EnumResponseType.DEFAULT_ERROR.getMessage(), throwable);
        this.response = ExceptionResponse.sendException(EnumResponseType.DEFAULT_ERROR, throwable);
    }

    public RecommendException(EnumResponseType exceptionType, Throwable throwable) {
        super(exceptionType.getMessage(), throwable);
        this.response = ExceptionResponse.sendException(EnumResponseType.DEFAULT_ERROR, throwable);
    }

    public RecommendException(String message) {
        super(message);
        this.response = ExceptionResponse.sendException(message);
    }
}
