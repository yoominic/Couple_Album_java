package com.java.response;


import com.java.exception.BaseExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author yoominic
 * @Date 2022/7/26 15:38 周二
 * @Version 1.0.0
 **/

@Data
@AllArgsConstructor
@Slf4j
public class Result<T> implements Serializable {


    /**
     * 状态码
     */
    private int code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(SuperEnumFace superEnumFace) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
    }

    public Result(SuperEnumFace superEnumFace, T data) {
        this.code = superEnumFace.getCode();
        this.message = superEnumFace.getMessage();
        this.data = data;
    }

    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Object error(String message) {
        Object object = null;
        if (ObjectUtils.isEmpty(message)) {
            object = new Result(BaseExceptionEnum.FAIL);
        } else {
            object = new Result(BaseExceptionEnum.FAIL.getCode(), message);
        }
        return object;
    }


    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Object error(String message, Integer code) {
        Object object = null;

        object = new Result(code, message);

        return object;
    }


    /**
     * 服务器错误
     *
     * @param message
     * @return
     */
    public static Object dbError(String message) {
        Object object = null;
        if (ObjectUtils.isEmpty(message)) {
            object = new Result(BaseExceptionEnum.ERROR);
        } else {
            object = new Result(BaseExceptionEnum.ERROR.getCode(), message);
        }

        return object;
    }


    /**
     * @param data
     * @return
     */
    public static <T> Object success(T data) {
        Object object = new Result(BaseExceptionEnum.SUCESS, data);

        return object;
    }


}
