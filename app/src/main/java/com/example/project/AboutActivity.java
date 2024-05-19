package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {


    private void showExternalWebPage() {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        WebView myWebView = (WebView)findViewById(R.id.aboutView);

        myWebView.loadUrl("file:///android_asset/about.html");

        getSupportActionBar().setTitle("About Us!!!");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.action_main_activity){
            Log.d("==>", "Opens Main activity");
            showExternalWebPage();
        }

        return true;
    }
}