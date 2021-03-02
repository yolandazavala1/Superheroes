package com.example.superheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView heroesList = findViewById(R.id.heroeslist);
        heroesList.setLayoutManager(new LinearLayoutManager(this));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://simplifiedcoding.net/demos/view-flipper/heroes.php",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<Superheroe> superheroe;
                        try {
                            JSONArray jsonArray = response.getJSONArray("heroes");
                            if(jsonArray.length()>0){
                                superheroe = Arrays.asList(gson.fromJson(jsonArray.toString(),Superheroe[].class));

                                heroesList.setAdapter(new MyAdapter(MainActivity.this,superheroe));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        VolleyS.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }
}
