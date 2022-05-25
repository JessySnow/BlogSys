package com.jessysnow.boot.service.retcode;

/**
 * 返回的状态码
 * code:
 *      200 - 成功
 *      201 - 失败
 * status: 附带的失败信息
 */
public class Code {
    private int code;
    private String status;

    public Code(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }
}
