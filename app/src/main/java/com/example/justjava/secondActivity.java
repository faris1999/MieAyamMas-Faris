package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void browser(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScpXheLC3JawVMSxMd9vGjRj1tshG94JmnguFt92WMjQCOTUQ/viewform?usp=sf_link"));
        startActivity(browserIntent);
    }
}
