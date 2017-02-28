package cn.hnq.utsoft.retrofit_two.Entity;

/**
 * Created by 胡楠启 on 2017/2/17.
 * Function：返回的数据实体类
 * Desc：
 */

public class DataEntity {
    /**
     * 返回码
     */
    private String resultcode;
    /**
     * 返回结果
     */
    private String reason;
    /**
     * 结果
     */
    private ResultEntity result;
    /**
     * 错误码
     */
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
