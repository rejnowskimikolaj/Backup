package com.example.rent.applicationlifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class JsonActivity extends AppCompatActivity {

    private JSONObject jsonIp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        Button getIpButton = (Button) findViewById(R.id.get_ip_button);
        getIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick ");

                JsonDownloader downloader = new JsonDownloader();
                downloader.execute();


            }
        });

    }



    public void goBack(View view){
        Intent i = new Intent();
        TextView ipView =(TextView) findViewById(R.id.ip_text_view);
        i.putExtra("ip", ipView.getText().toString());
        setResult(RESULT_OK, i);
        finish();


    }

    public void setIp(){
        Log.d("TAG", "setIp ");
        if(jsonIp!=null){
            try {


                TextView ipView =(TextView) findViewById(R.id.ip_text_view);
                ipView.setText(jsonIp.getString("ip"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public class JsonDownloader extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
// These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.

            Log.d("TAG", "doInBackground ");

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String JsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                String baseUrl = "http://ip.jsontest.com/";
                Uri.Builder builder = new Uri.Builder();
                //https://www.myawesomesite.com/turtles/types?type=1&sort=relevance#section-name

//                builder.scheme("http")
//                        .authority("api.openweathermap.org")
//                        .appendPath("data")
//                        .appendPath("2.5")
//                        .appendPath("forecast")
//                        .appendPath("city")
//                        .appendQueryParameter("id", params[0])
//                        .appendQueryParameter("APPID", "65b2cefe96066a833ed493d04d6a2c78");
//                String myUrl = builder.build().toString();
                URL url = new URL(baseUrl);

                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                JsonStr = buffer.toString();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return JsonStr;
        }

        @Override
        protected void onPostExecute(String JsonString) {

            if (JsonString!=null){
                try {
                    Log.d("TAG", "onPostExecute new jsonIP ");

                    jsonIp = new JSONObject(JsonString);
                    setIp();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}