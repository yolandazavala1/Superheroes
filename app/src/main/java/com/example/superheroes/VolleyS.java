package com.example.superheroes;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyS {
    private static VolleyS mVolleyS = null;

    //Este es el objeto que utilizara la aplicación
    private RequestQueue mRequestQueue;

    private VolleyS(Context context){
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyS getInstance(Context context){
        if(mVolleyS == null){
            mVolleyS = new VolleyS(context);
        }
        return mVolleyS;
    }

    public RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getmRequestQueue().add(req);
    }

}


