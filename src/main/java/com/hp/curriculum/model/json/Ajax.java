package com.hp.curriculum.model.json;


import com.hp.curriculum.model.constant.attribute.Key;
import com.hp.curriculum.model.constant.code.AjaxCode;
import com.hp.curriculum.model.constant.message.json.AjaxMessage;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/2/2
 */
public class Ajax extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private Ajax(boolean result) {
        put(Key.RESULT, result);
    }

    /**
     * 默认异步请求成功
     *
     * @return msg - 消息
     */
    public static Ajax success() {
        return success(AjaxMessage.REQUEST_SUCCESS);
    }

    /**
     * 自定义异步请求成功消息
     *
     * @param msg 消息
     * @return msg - 消息
     */
    public static Ajax success(final String msg) {
        return new Ajax(true) {{
            put(Key.MSG, msg);
        }};
    }

    /**
     * 自定义异步请求成功数据
     *
     * @param data 数据
     * @return data - 数据
     */
    public static Ajax success(final Object data) {
        return new Ajax(true) {{
            put(Key.DATA, data);
        }};
    }

    /**
     * 自定义异步请求成功数据和消息
     *
     * @param data 数据
     * @param msg  消息
     * @return data - 数据；msg - 消息
     */
    public static Ajax success(final Object data, final String msg) {
        return new Ajax(true) {{
            put(Key.DATA, data).put(Key.MSG, msg);
        }};
    }

    /**
     * 自定义异步请求成功返回值
     *
     * @param map 键值对
     * @return map - 键值对
     */
    public static Ajax success(final HashMap<String, Object> map) {
        return new Ajax(true) {{
            putAll(map);
        }};
    }

    /**
     * 默认异步请求失败/异常
     *
     * @return msg
     */
    public static Ajax error() {
        return error(AjaxMessage.UNKNOWN_EXCEPTION);
    }

    /**
     * 自定义异步请求失败/异常消息
     *
     * @param msg 消息
     * @return msg - 消息
     */
    public static Ajax error(String msg) {
        return error(msg, AjaxCode.UNKNOWN_EXCEPTION);
    }

    /**
     * 自定义异步请求失败/异常消息和返回码
     *
     * @param msg  消息
     * @param code 返回码
     * @return msg - 消息；code - 返回码
     */
    public static Ajax error(final String msg, final int code) {
        return new Ajax(false) {{
            put(Key.MSG, msg).put(Key.CODE, code);
        }};
    }

    /**
     * 自定义异步请求失败/异常消息和返回码
     *
     * @param ajaxError 错误
     * @return msg - 消息；code - 返回码
     */
    public static Ajax error(final AjaxError ajaxError) {
        return new Ajax(false) {{
            if (StringUtils.isEmpty(ajaxError.getMsg())) {
                put(Key.MSG, ajaxError.getMsg());
            }
            if (ajaxError.getCode() == null) {
                put(Key.CODE, ajaxError.getCode());
            }
        }};
    }

    /**
     * 自定义异步请求失败/异常消息
     *
     * @param errorMap 错误
     * @return 自定义键值对
     */
    public static Ajax error(final Map<String, Object> errorMap) {
        return new Ajax(false) {{
            putAll(errorMap);
        }};
    }

    @Override
    public Ajax put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Ajax put(Map<? extends String, ?> m) {
        super.putAll(m);
        return this;
    }

}
