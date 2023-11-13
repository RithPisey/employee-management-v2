package kh.gov.rac.racsa.utils;

import java.util.HashMap;

public class ResponseMessage {
    public static HashMap<String, Object> responseObject(String msg, Boolean error, Boolean success){
        HashMap<String,Object> res = new HashMap<>();
        res.put("msg",msg);
        res.put("error",error);
        res.put("success",success);
        return res;
    }

    public static HashMap<String, Object> responseObject(String msg, Boolean error, Boolean success, Object data){
        HashMap<String,Object> res = new HashMap<>();
        res.put("msg",msg);
        res.put("error",error);
        res.put("success",success);
        res.put("data", data);
        return res;
    }
}
