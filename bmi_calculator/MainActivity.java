 package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

     EditText $H_cm, $W_kg;
     Button $btnCalcu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        $btnCalcu = findViewById(R.id.btnCalcu);
        $H_cm = findViewById(R.id.H_cm);
        $W_kg = findViewById(R.id.W_kg);

        $btnCalcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cm = $H_cm.getText().toString();
                String kg = $W_kg.getText().toString();
                String[] scale = {"Underweight", "Normal", "Overweight", "Obese"};

                if (cm.isEmpty() || kg.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER HEIGHT AND WEIGHT", Toast.LENGTH_SHORT).show();
                } else {

                    float numHeight = Float.parseFloat(cm);
                    float numWeight = Float.parseFloat(kg);

                    float enterHeight = numHeight / 100;
                    float enterWeight = enterHeight * enterHeight;
                    float result = numWeight / enterWeight;

                    String bmi = String.valueOf(result);

                    Intent i = new Intent(MainActivity.this, Result.class);
                    i.putExtra("RESULT", bmi);

                    if (result <= 18.5) {
                        i.putExtra("CLASSIFY", scale[0].toUpperCase());
                    } else if (result > 18.5 && result <= 24.9) {
                        i.putExtra("CLASSIFY", scale[1].toUpperCase());
                    } else if (result > 25.0 && result <= 29.9) {
                        i.putExtra("CLASSIFY", scale[2].toUpperCase());
                    } else if (result > 30.0) {
                        i.putExtra("CLASSIFY", scale[3].toUpperCase());
                    }
                    startActivity(i);
                }
            }
        });
    }
}