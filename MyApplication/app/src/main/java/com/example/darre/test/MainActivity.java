package com.example.darre.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Home");

        TextView cali;
        cali = (TextView) findViewById(R.id.calisthenics);

        cali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, webViewClass.class);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menu) {

        switch (menu.getItemId()) {
            case R.id.action_settings:

                settingsPage();

                break;

            case R.id.action_notifications:

                notificationsPage();

                break;

            case R.id.toolbar:

                Intent intent1 = new Intent(MainActivity.this, searchActivity.class);
                startActivity(intent1);

                break;
        }

        return false;

    }

    private void settingsPage() {
        setTitle("Settings");
    }

    private void notificationsPage() {
        setTitle("Notifications");


    }

    private void searchpage() {
        setTitle("Search");



    }


}
