package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22nevan";
    private final String JSON_FILE = "projectJSON.json";
    private ArrayList<Produce> produceArrayList = new ArrayList<>();

    Gson gson = new Gson();

    RecyclerViewAdapter adapter;

    public void showInternalWebPage(){
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Buy our plants!!!");

        adapter = new RecyclerViewAdapter(this, produceArrayList, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Produce item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.produceList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);

        new JsonFile(this,this).execute(JSON_FILE);
        //new JsonTask(this).execute(JSON_URL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_internal_web) {
            Log.d("==>", "Will display 'About Us' internal web page in new activity");
            showInternalWebPage();
        }

        return true;
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", "JSON data received: " + json);
        Type type = new TypeToken<List<Produce>>() {}.getType();
        produceArrayList = gson.fromJson(json, type);
        adapter.setItems(produceArrayList);
        adapter.notifyDataSetChanged();
    }
}
