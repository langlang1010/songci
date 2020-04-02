package cn.smileyan.songci.util;

/**
 * @author Smileyan
 */
public class RestBody {
    private String msg;
    private Integer code;
    private Object data;

    public static final int SUCCESS = 200;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
