package com.hp.curriculum.model.json;


import com.hp.curriculum.model.constant.code.AjaxCode;
import com.hp.curriculum.model.constant.message.json.AjaxMessage;
import lombok.Data;

/**
 * @author Administrator
 * @date 2018/2/12
 */
@Data
public class AjaxError {

    private String field;

    private String msg;

    private Integer code;

    public AjaxError() {
        this(AjaxMessage.UNKNOWN_EXCEPTION, AjaxCode.UNKNOWN_EXCEPTION);
    }

    AjaxError(String field, String msg, Integer code) {
        this.field = field;
        this.msg = msg;
        this.code = code;
    }

    AjaxError(String field, String msg) {
        this(field, msg, AjaxCode.PARAMETER_ERROR);
    }

    private AjaxError(String msg, Integer code) {
        this(null, msg, code);
    }
}
