package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo.databinding.ActivityMainBinding;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);


        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi0();
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi1();
            }
        });

    }

    void callApi1()
    {
        /*Json Request*/
        String url = "https://arpit-portfolio.herokuapp.com/api/1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            Toast.makeText(MainActivity.this, response.get("num").toString(), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e)
                        {
                            Log.e(TAG, "onResponse: "+e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: "+ error.getMessage());
                    }
                });
        //add request to queue
        requestQueue.add(jsonObjectRequest);
    }

    void callApi0()
    {
        /*Json Request*/
        String url = "https://arpit-portfolio.herokuapp.com/api/0";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            Toast.makeText(MainActivity.this, response.get("num").toString(), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e)
                        {
                            Log.e(TAG, "onResponse: "+e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: "+ error.getMessage());
                    }
                });
        //add request to queue
        requestQueue.add(jsonObjectRequest);
    }
}
