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

    public static HashMap<String, Object> responseObject(
            String msg,
            Boolean error,
            Boolean success,
            Object data,
            Object paginate,
            Object filter){
        HashMap<String,Object> res = new HashMap<>();
        res.put("msg",msg);
        res.put("error",error);
        res.put("success",success);
        res.put("data", data);
        res.put("paginate", paginate);
        res.put("filter", filter);
        return res;
    }




    public static HashMap<String, Object> getPaginate(int page,int size, String orderBy, String orderType){
        HashMap<String, Object > paginate = new HashMap<>();
        paginate.put("page", page);
        paginate.put("size", size);
        paginate.put("orderBy", orderBy);
        paginate.put("orderType",orderType);
        return paginate;
    }

    public static HashMap<String, Object>  getFilter(Object fil){
        HashMap<String, Object > filter = new HashMap<>();
        filter.put("filter", fil);
        return filter;
    }


}
