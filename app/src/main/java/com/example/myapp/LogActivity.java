package com.example.myapp;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {
private RecyclerView mRecyclerView;
private ExampleAdapter mExampleAdapter;
private ArrayList<ExampleItem> mExampleList;
private RequestQueue mRequestQueue;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
        }
private void parseJSON() {
        String url = "http://ec2-65-1-47-142.ap-south-1.compute.amazonaws.com:8080/api/15/items/all";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        new Response.Listener<JSONObject>() {
@Override
public void onResponse(JSONObject response) {
        try {
        JSONArray jsonArray = response.getJSONArray("items");
        for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject hit = jsonArray.getJSONObject(i);
        String itemName = hit.getString("name");
        String description = hit.getString("description");
        int price = hit.getInt("price");
        mExampleList.add(new ExampleItem(itemName, description, price));
        }
        mExampleAdapter = new ExampleAdapter(LogActivity.this, mExampleList);
        mRecyclerView.setAdapter(mExampleAdapter);
        } catch (JSONException e) {
        e.printStackTrace();
        }
        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        final ProgressDialog mDialog = new ProgressDialog(LogActivity.this);
        mDialog.setMessage("Error in API.....");
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setIndeterminate(true);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        }
        });
        mRequestQueue.add(request);
        }
        }
