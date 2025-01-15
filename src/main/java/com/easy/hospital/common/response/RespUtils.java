package com.easy.hospital.common.response;

public class RespUtils {
    public RespUtils(){}

    public static <T> RespResult<T> success() {
        return new RespResult<>(RespSystemCode.SUCCESS);
    }

    public static <T> RespResult<T> success(T data) {
        RespResult<T> result = new RespResult<>(RespSystemCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> RespResult<T> fail(RespCode source){
        return new RespResult<>(source);
    }

    public static <T> RespResult<T> fail(RespCode source, T data){
        RespResult<T> result = new RespResult<>(source);
        result.setData(data);
        return result;
    }

    public static <T> RespResult<T> fail(RespCode source, String message){
        RespResult<T> result = new RespResult<>(source);
        result.setRespMsg(message);
        return result;
    }

    public static <T> RespResult<T> fail(String code, String message){
        return new RespResult<>(code, message);
    }

    public static <T> RespResult<T> fail(ServiceException serviceException){
        return fail(serviceException.getCode(), serviceException.getMessage());
    }

    public static boolean isSuccess(RespResult<?> result){
        if (result == null){
            throw new ServiceException(RespSystemCode.SYSTEM_ERROR);
        }
        return RespSystemCode.SUCCESS.getCode().equals(result.getRespCode());
    }

    public static boolean isSocketTimeOut(RespResult<?> result){
        return RespSystemCode.SOCKET_READ_TIMEOUT.getCode().equals(result.getRespCode());
    }

    public static boolean isFail(RespResult<?> result){
        return !isSuccess(result);
    }

    public static <T> T getRespResult(RespResult<T> result){
        if (result == null){
            throw new ServiceException(RespSystemCode.SYSTEM_ERROR);
        } else if (RespSystemCode.SUCCESS.getCode().equals(result.getRespCode())) {
            return result.getData();
        } else {
            throw new ServiceException(result.getRespCode(), result.getRespMsg());
        }
    }

    public static <T> T getRespResultWithErrorCodeAndMsg(RespResult<T> result, String errorCode, String errorMsg){
        if (result == null){
            throw new ServiceException(errorCode, errorMsg);
        } else if (RespSystemCode.SUCCESS.getCode().equals(result.getRespCode())) {
            return result.getData();
        } else {
            throw new ServiceException(errorCode, errorMsg);
        }
    }

    public static <T> T getRespResultWithErrorCode(RespResult<T> result, RespCode error){
        if (result == null){
            throw new ServiceException(error);
        } else if (RespSystemCode.SUCCESS.getCode().equals(result.getRespCode())) {
            return result.getData();
        } else {
            throw new ServiceException(error);
        }
    }

    public static <T> T getRespResultWithNULL(RespResult<T> result){
        if (result == null){
            return null;
        } else if (RespSystemCode.SUCCESS.getCode().equals(result.getRespCode())) {
            return result.getData();
        } else {
            throw new ServiceException(result.getRespCode(), result.getRespMsg());
        }
    }

    public static <T> T getRespResultNoCheck(RespResult<T> result){
        if (result == null){
            return null;
        }else {
            return result.getData();
        }
    }
}
