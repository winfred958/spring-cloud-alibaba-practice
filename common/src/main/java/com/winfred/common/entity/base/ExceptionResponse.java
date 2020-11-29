package com.winfred.common.entity.base;

public class ExceptionResponse<T> extends BaseResponse<T> {

    private Object error;

    /**
     * @param message
     * @return
     * @Title: sendException
     * @Description: TODO
     * @date 2017年9月2日 上午11:07:50
     */
    public static <T> ExceptionResponse<T> sendException(String message) {
        ExceptionResponse<T> exceptionResponse = new ExceptionResponse<T>();
        exceptionResponse.setCode(EnumResponseType.DEFAULT_ERROR.getCode());
        exceptionResponse.setMessage(message);
        exceptionResponse.setData(null);
        return exceptionResponse;
    }

    /**
     * @param enumExceptionType
     * @return
     * @Title: sendException
     * @Description: TODO
     * @date 2017年9月2日 上午11:07:50
     */
    public static <T> ExceptionResponse<T> sendException(EnumResponseType enumExceptionType) {
        ExceptionResponse<T> exceptionResponse = new ExceptionResponse<T>();
        exceptionResponse.setCode(enumExceptionType.getCode());
        exceptionResponse.setMessage(enumExceptionType.getMessage());
        exceptionResponse.setData(null);
        return exceptionResponse;
    }

    /**
     * @param enumExceptionType
     * @param throwable
     * @return
     * @Title: sendException
     * @Description: TODO
     * @date 2017年9月2日 上午11:07:55
     */
    public static <T> ExceptionResponse<T> sendException(EnumResponseType enumExceptionType, Throwable throwable) {
        ExceptionResponse<T> exceptionResponse = new ExceptionResponse<T>();
        exceptionResponse.setCode(enumExceptionType.getCode());
        exceptionResponse.setMessage(enumExceptionType.getMessage());
        exceptionResponse.setData(null);
        exceptionResponse.setError(throwable);
        return exceptionResponse;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }
}
