package com.infoyb.supplier.system.utils;

import java.io.Serializable;

/**
 * Created by infoyb on 2017.11.02.
 */
public class ResultObject implements Serializable {

    private static final long serialVersionUID = 1L;
    // success [true|false] default true
    private boolean success = true;
    // 提示信息
    private String msg;
    // 代码, 后面需要对没一个错误进行编码
    private String code = "200";
    // 返回时携带的数据
    private Object data;
    //返回时判断是否登录
    private boolean login = true;

    private Integer draw;

    private Integer recordsTotal;

    private Integer recordsFiltered;

    public ResultObject() {
    }

    public ResultObject(String msg) {
        this.msg = msg;
    }

    public ResultObject(Object data) {
        this.data = data;
    }

    public ResultObject(boolean result) {
        this.success = result;
    }

    public ResultObject(boolean result, String msg) {
        this.success = result;
        this.msg = msg;
    }

    public ResultObject(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    @Override
    public String toString() {
        return "ResultObj{" + "result=" + success + ", msg=" + msg + ", code=" + code + ", data=" + data + '}';
    }
}
