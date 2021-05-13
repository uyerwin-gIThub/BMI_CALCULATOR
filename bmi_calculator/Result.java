package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView $bmiResult, $bmiClassify;
    Button $btnGb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        $btnGb = findViewById(R.id.btnGb);
        $bmiResult = findViewById(R.id.bmiResult);
        $bmiClassify = findViewById(R.id.bmiClassify);

        Intent i = getIntent();

        String result = i.getStringExtra("RESULT");
        $bmiResult.setText(result);

        String classify = i.getStringExtra("CLASSIFY");
        $bmiClassify.setText(classify);

        $btnGb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Result.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}