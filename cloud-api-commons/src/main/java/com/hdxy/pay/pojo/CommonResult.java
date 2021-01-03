package com.hdxy.pay.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wzh
 * @Description
 * @create 2020-12-07 16:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResult<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;

    public CommonResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
