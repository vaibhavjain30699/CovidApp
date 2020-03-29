package com.vaibhav.covidquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {

    private TextView question;
    //private RadioGroup answers;
    //private RadioButton low,medium,high;
    private Button low,medium,high,exit;
    private int yes=0,no=0;

    private int patient_age;
    String travel_history,temp,coughing,breathlessness,weakness,dry_cough,sore_throat,change_appetite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        patient_age = getIntent().getIntExtra("age",0);

        question = findViewById(R.id.question);
        //answers = findViewById(R.id.radiogroup);
        low = findViewById(R.id.low);
        medium = findViewById(R.id.medium);
        high = findViewById(R.id.high);
        high.setVisibility(View.GONE);
        exit = findViewById(R.id.exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(quiz.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //answers.clearCheck();

        question.setText("Any Travel History in Past 14 days?");
        low.setText("Yes");
        medium.setText("No");
        //high.setText("Has travel history");

//        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId==R.id.low)
//                    travel_history = "No History";
//                else if(checkedId==R.id.medium)
//                    travel_history = "In contact with Infected";
//                else
//                    travel_history = "Has Travel History";
//
//                answers.clearCheck();
//            }
//        });

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel_history = "Yes";
                //yes++;
                Question2();
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel_history = "No";
                //no++;
                Question2();
            }
        });

        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travel_history = "Has Travel History";
                Question2();
            }
        });

    }

    String contact;

    private void Question2(){
        question.setText("Came in contact with the infected?");
        low.setText("Yes");
        medium.setText("No");
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //yes++;
                contact = "Yes";
                Question_Second();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //no++;
                contact = "No";
                Question_Second();
            }
        });
    }

    private void Question_Second(){
       // answers.clearCheck();
        question.setText("Fever?");
        //Toast.makeText(this, ""+travel_history, Toast.LENGTH_SHORT).show();
        //low.setText("Normal (<=98.6)");
        low.setText("Yes");
        //medium.setText("Medium (98.6-100)");
        medium.setText("No");
        high.setText("High (>100)");

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                temp = "Low";
                yes++;
                ThirdQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                temp = "medium";
                no++;
                ThirdQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = "high";
                ThirdQuestion();
            }
        });
    }

    private void ThirdQuestion(){
        //Toast.makeText(this,temp,Toast.LENGTH_SHORT).show();
        question.setText("Coughing?");
        low.setText("Yes");
        medium.setText("No");
        high.setText("High");

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coughing = "low";
                yes++;
                FourthQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coughing = "medium";
                no++;
                FourthQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coughing = "high";
                FourthQuestion();
            }
        });

    }


    private void FourthQuestion(){
        //Toast.makeText(this,coughing,Toast.LENGTH_SHORT).show();
        question.setText("Breathlessness?");
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes++;
                breathlessness = "low";
                FifthQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no++;
                breathlessness = "medium";
                FifthQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breathlessness = "high";
                FifthQuestion();
            }
        });
    }

    private void FifthQuestion(){
        question.setText("Weakness?");
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weakness = "low";
                yes++;
                SixthQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weakness = "medium";
                no++;
                SixthQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weakness = "high";
                SixthQuestion();
            }
        });
    }

    private void SixthQuestion(){
        question.setText("Dry Cough?");
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dry_cough = "low";
                yes++;
                SeventhQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dry_cough = "medium";
                no++;
                SeventhQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dry_cough = "high";
                SeventhQuestion();
            }
        });
    }

    private void SeventhQuestion(){
        question.setText("Sore Throat?");
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yes++;
                sore_throat = "low";
                EightQuestion();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sore_throat = "medium";
                no++;
                EightQuestion();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sore_throat = "high";
                EightQuestion();
            }
        });
    }

    String verdict = "";

    private void EightQuestion(){
        question.setText("Change in Appetite?");

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_appetite = "low";
                //FifthQuestion();
                Verdict();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_appetite = "medium";
                //FifthQuestion();
                Verdict();
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change_appetite = "high";
                //FifthQuestion();
            }
        });
    }

    private void Verdict(){
        if(yes>=3){
            if(travel_history.equals("Yes")  ||  patient_age>30  ||  contact.equals("Yes"))
                verdict = "HIGH";
            else
                verdict = "MEDIUM";
        }
        else
            verdict = "LOW";
        Intent intent1 = new Intent(quiz.this,result_covid.class);
        intent1.putExtra("ans",verdict);
        startActivity(intent1);
        finish();
    }
}
