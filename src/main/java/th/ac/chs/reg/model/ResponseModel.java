package th.ac.chs.reg.model;

import org.json.JSONObject;

public class ResponseModel {
    String message;

    public ResponseModel(String message){
        this.message = message;
    }
    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("message", message);
        return json.toString();
    }
}
