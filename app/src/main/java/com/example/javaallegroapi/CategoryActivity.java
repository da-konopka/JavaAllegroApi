package com.example.javaallegroapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        textView = (TextView) findViewById(R.id.textView2);
        String token = getIntent().getExtras().getString("token");
        textView.setText(token);
    }

}
