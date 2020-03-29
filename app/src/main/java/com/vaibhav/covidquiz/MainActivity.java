package com.vaibhav.covidquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText age;
    private Button start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.age);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "Please Enter the age", Toast.LENGTH_SHORT).show();
                else{
                    int x = Integer.parseInt(age.getText().toString());
                    Intent intent = new Intent(MainActivity.this,quiz.class);
                    intent.putExtra("age",x);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
