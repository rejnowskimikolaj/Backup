package com.example.android.sunshine.app;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 2017-01-08.
 */

public  class ForecastFragment extends Fragment {

private ArrayAdapter<String> mForecastAdapter;
    public ForecastFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecast_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.action_refresh){
            Toast.makeText(getActivity(), "downloading forecast", Toast.LENGTH_SHORT).show();
            FetchWeatherTask task = new FetchWeatherTask();
            task.execute("3085151");


            return true;
        }

        else if(id==R.id.action_settings){
            Toast.makeText(getActivity(), "settings", Toast.LENGTH_SHORT).show();


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create some dummy data for the ListView.  Here's a sample weekly forecast
        String[] data = {
                "dzisiaj",
                "jutro",
                "pojutrze",
                "popojutrze",
                "popopojutrze",
                "popopopojutrze",
                "popopopopojutrze"};

        List<String> weekForecast = new ArrayList<>(Arrays.asList(data));

        mForecastAdapter = new ArrayAdapter(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ListView listViewForecast = (ListView) rootView.findViewById(R.id.listview_forecast);
        listViewForecast.setAdapter(mForecastAdapter);

        listViewForecast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(getActivity(), mForecastAdapter.getItem(i), Toast.LENGTH_SHORT).show();

                String forecast = mForecastAdapter.getItem(i).toString();

                Intent intent = new Intent(getActivity(),DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT,forecast);
                startActivity(intent);

            }
        });





        return rootView;

        //65b2cefe96066a833ed493d04d6a2c78
    }

    private String getReadableDateString(long time){
        // Because the API returns a unix timestamp (measured in seconds),
        // it must be converted to milliseconds in order to be converted to valid date.
        SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
        return shortenedDateFormat.format(time);
    }

    private String formatHighLows(double high, double low) {
        // For presentation, assume the user doesn't care about tenths of a degree.

        double highCelcius = high-273.15;
        double lowCelcius = low-273.15;

        long roundedHigh = Math.round(highCelcius);
        long roundedLow = Math.round(lowCelcius);
        String highLowStr = roundedHigh + "/" + roundedLow;
        return highLowStr;
    }

    private String[] getWeatherDataFromJson(String forecastJsonStr, int numDays) throws JSONException {
        JSONObject job = new JSONObject(forecastJsonStr);
        JSONArray ja = (JSONArray) job.get("list");
        String[] resultStrs = new String[numDays];


        Time dayTime = new Time();
        dayTime.setToNow();

        // we start at the day returned by local time. Otherwise this is a mess.
        int julianStartDay = Time.getJulianDay(System.currentTimeMillis(), dayTime.gmtoff);

        // now we work exclusively in UTC
        dayTime = new Time();

        for(int i=0; i<resultStrs.length;i++){
            String day;
            String description;
            String highAndLow;

            JSONObject dayWeather = (JSONObject) ja.get(i);
            JSONObject main = (JSONObject) dayWeather.get("main");

            // The date/time is returned as a long.  We need to convert that
            // into something human-readable, since most people won't read "1400356800" as
            // "this saturday".
            long dateTime;

            // Cheating to convert this to UTC time, which is what we want anyhow
            //adding day to today
            dateTime = dayTime.setJulianDay(julianStartDay+i);
            day = getReadableDateString(dateTime);


            //temperatures
            double highTemp = main.getDouble("temp_max");
            double lowTemp = main.getDouble("temp_min");
            highAndLow = formatHighLows(highTemp,lowTemp);


            JSONArray weather = (JSONArray) dayWeather.get("weather");
            JSONObject weather0 = (JSONObject) weather.get(0);
            description = weather0.getString("description");

            resultStrs[i] = day + " : " + description + " : " + highAndLow;

        }

        for (String s : resultStrs) {
            Log.v("forecast:", "Forecast entry: " + s);
        }

        return resultStrs;
    }
    public class FetchWeatherTask extends AsyncTask<String,Void,String[]>{
        private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();
        private String cityCode;

        @Override
        protected String[] doInBackground(String... params) {


            // These two need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a string.
            String forecastJsonStr = null;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                String baseUrl = "http://api.openweathermap.org/data/2.5/forecast/city?id=3085151&APPID=65b2cefe96066a833ed493d04d6a2c78";
                Uri.Builder builder = new Uri.Builder();
                //https://www.myawesomesite.com/turtles/types?type=1&sort=relevance#section-name

                builder.scheme("http")
                        .authority("api.openweathermap.org")
                        .appendPath("data")
                        .appendPath("2.5")
                        .appendPath("forecast")
                        .appendQueryParameter("id", params[0])
                        .appendQueryParameter("APPID", "65b2cefe96066a833ed493d04d6a2c78");
                String myUrl = builder.build().toString();
                URL url = new URL(myUrl);

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
                forecastJsonStr = buffer.toString();
                //Toast.makeText(getActivity(), "JSON downloaded", Toast.LENGTH_LONG).show();

                Log.v(LOG_TAG,forecastJsonStr);

                getWeatherDataFromJson(forecastJsonStr,7);

                JSONParser parser = new JSONParser();
                parser.setJob(forecastJsonStr);
                Log.v("maxTemp", parser.getMaxTemp(0));
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }

                try {
                    return getWeatherDataFromJson(forecastJsonStr, 7);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;


        }

        @Override
        protected void onPostExecute(String[] strings) {

            if (strings!=null){
                mForecastAdapter.clear();
                for(String forecastStr:strings){
                    mForecastAdapter.add(forecastStr);
                }
            }
        }

    }
}
