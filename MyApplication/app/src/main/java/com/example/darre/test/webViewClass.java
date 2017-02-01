package com.example.darre.test;

/**
 * Created by darre on 01/02/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class webViewClass extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);



        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl("https://brunelstudents.com/sportsclubs/BrunelCalisthenics/");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web_view_actions, menu);

        setTitle("Calisthenics");


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menu){

        switch(menu.getItemId()){
            case R.id.close_action:

                closeActivity();

                break;
        }

        return false;

    }

    public void closeActivity(){

        Intent intent = new Intent(webViewClass.this, MainActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

