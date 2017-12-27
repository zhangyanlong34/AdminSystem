package com.zyl.adminsystem.Common;

import com.alibaba.fastjson.JSONObject;

public class ResponseMessage {
    private String msg;
    private int code;
    private JSONObject extdata;

    public static String buildSuccessMessage(JSONObject extdata){
        return new ResponseMessage("success",200,extdata).toString();
    }

    public ResponseMessage(String msg, int code, JSONObject extdata) {
        this.msg = msg;
        this.code = code;
        this.extdata = extdata;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",msg);
        jsonObject.put("code",code);
        jsonObject.put("extdata",extdata);
        return jsonObject.toJSONString();
    }
}
