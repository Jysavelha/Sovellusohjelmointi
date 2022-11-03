package com.example.android_loppuharjoitus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Stockholm extends AppCompatActivity {

    private String mUrl = "https://api.open-meteo.com/v1/forecast?latitude=59.3328&longitude=18.0645&current_weather=true&windspeed_unit=ms&timezone=auto";
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockholm);
        mQueue = Volley.newRequestQueue(this);


    }

    public void GetWeather(View view) {

        //Säätiedot URLista

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        parseJsonAndUpdateUI(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        //Lisätään request volley queueen
        mQueue.add(jsonObjectRequest);
    }
    private void parseJsonAndUpdateUI(JSONObject weatherObject){
        TextView Temp = (TextView) findViewById(R.id.Temp);
        TextView Wind = (TextView) findViewById(R.id.Wind);
        TextView WindDir = (TextView) findViewById(R.id.WindDir);
        TextView Time = (TextView)findViewById(R.id.Time);
        try {
            double temperature = weatherObject.getJSONObject("current_weather").getDouble("temperature");
            Temp.setText("" + temperature + " c");

            double windSpeed = weatherObject.getJSONObject("current_weather").getDouble("windspeed");
            Wind.setText("" + windSpeed + "m/s");

            double windDirection = weatherObject.getJSONObject("current_weather").getDouble("winddirection");
            WindDir.setText("" + windDirection + "");

            String TimeDate = weatherObject.getJSONObject("current_weather").getString("time");
            Time.setText("" + TimeDate + "");

            Time.setText(TimeDate);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}