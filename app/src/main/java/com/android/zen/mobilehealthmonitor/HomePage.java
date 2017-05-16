package com.android.zen.mobilehealthmonitor;

/**
 * Created by Lenovo on 16.05.2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HomePage extends Activity {

    private static int showtime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(HomePage.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, showtime);
    }
}