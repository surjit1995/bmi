package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtheight, edtWeight, edtBmi, edtCategory;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtheight = (EditText) findViewById(R.id.heightin);
        edtWeight = (EditText) findViewById(R.id.inweight);
        edtBmi = (EditText) findViewById(R.id.bmiResult);
        edtCategory = (EditText) findViewById(R.id.bmiCategory);
        btnCalculate = (Button) findViewById(R.id.calculate);


        //the action code
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtheight.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Enter the height in cm",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtWeight.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Enter the weight in kilograms",Toast.LENGTH_SHORT).show();
                    return;
                }

                int height = Integer.parseInt(edtheight.getText().toString());
                int weight = Integer.parseInt(edtWeight.getText().toString());
                double finalHeight = (double)height / 100;
                double bmi = weight/(finalHeight*finalHeight);
               Double BMI = new Double(bmi);
                String strDouble = String.format("%.2f", BMI);
                edtBmi.setText(strDouble);
                String cat;
                if (bmi < 18.5) {
                    cat = "Underweight";
                } else if (bmi < 25) {
                   cat = "Normal weight";
                } else if (bmi < 30) {
                    cat = "Overweight ";
                } else
                    cat = " Obesity" ;
                    edtCategory.setText(cat);

            }
        });
    }


}