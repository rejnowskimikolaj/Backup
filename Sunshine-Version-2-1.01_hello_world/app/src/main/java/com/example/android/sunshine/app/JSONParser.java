package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User on 2017-01-09.
 */

public class JSONParser {

    private JSONObject job;


    public void setJob(String JsonString) throws JSONException {
        job = new JSONObject(JsonString);
    }

    public String getMaxTemp(int i) throws JSONException {
        JSONArray ja = (JSONArray) job.get("list");
        JSONObject dateObject = (JSONObject) ja.get(i);
        JSONObject main = (JSONObject) dateObject.get("main");
        return main.getString("temp_max");

    }


}
