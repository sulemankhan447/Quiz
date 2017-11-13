package com.suleman.quiz;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tvQn;
    Button btnOp1;
    Button btnOp2;
    Button btnOp3;
    Button btnOp4;
    String answer;
    RequestQueue requestQueue;
    private final  static String server_url = "http://192.168..0.10/fetch.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*Checking Internet Connection*/
        if(false)
        {
            startActivity(new Intent(MainActivity.this,ReloadActivity.class));
        }
        else
        {
            tvQn=(TextView)findViewById(R.id.tvQn);
            btnOp1=(Button)findViewById(R.id.btnOp1);
            btnOp2=(Button)findViewById(R.id.btnOp3);
            btnOp4=(Button)findViewById(R.id.btnOp4);
            requestQueue= Volley.newRequestQueue(MainActivity.this);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                Log.d("Volley Response",response.toString());

                    try {
                        tvQn.setText(response.getString("question"));
                        btnOp1.setText(response.getString("op1"));
                        btnOp2.setText(response.getString("op2"));
                        btnOp3.setText(response.getString("op3"));
                        btnOp4.setText(response.getString("op4"));
                        answer = response.getString("ans");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Volley Error",error.toString());
                    startActivity(new Intent(MainActivity.this,ReloadActivity.class));
                }
            });
            requestQueue.add(jsonObjectRequest);
            btnOp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnOp1.getText().equals(answer))
                    {

                    }
                }
            });
            btnOp2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnOp2.getText().equals(answer)){

                    }
                }
            });
            btnOp3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnOp3.getText().equals(answer)){

                    }
                }
            });
            btnOp4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(btnOp4.getText().equals(answer)){

                    }
                }
            });
        }
    }
}
