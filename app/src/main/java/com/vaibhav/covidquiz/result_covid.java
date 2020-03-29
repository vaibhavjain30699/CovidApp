package com.vaibhav.covidquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class result_covid extends AppCompatActivity {

    String verdict;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_covid);

        verdict = getIntent().getStringExtra("ans");

        textView = findViewById(R.id.verdict);
        textView.setText(verdict);

        if(verdict.equals("LOW"))
            textView.setTextColor(Color.GREEN);
        else if(verdict.equals("MEDIUM"))
            textView.setTextColor(Color.YELLOW);
        else
            textView.setTextColor(Color.RED);

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
        //Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
    }
}
