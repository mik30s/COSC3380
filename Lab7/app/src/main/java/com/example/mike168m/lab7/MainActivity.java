package com.example.mike168m.lab7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private EditText firstNumberText;
    private EditText secondNumberText;
    private EditText resultsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);

        resultsText = findViewById(R.id.resultText);
        firstNumberText = findViewById(R.id.firstNumberText);
        secondNumberText = findViewById(R.id.secondNumberText);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a = textToNumber(firstNumberText);
                Float b = textToNumber(secondNumberText);
                resultsText.setText(calculate(a, b, "+").toString());
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a = textToNumber(firstNumberText);
                Float b = textToNumber(secondNumberText);
                resultsText.setText(calculate(a, b, "-").toString());
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a = textToNumber(firstNumberText);
                Float b = textToNumber(secondNumberText);
                resultsText.setText(calculate(a, b, "*").toString());
            }
        });

        Log.d("OnCreate", "On create called");
    }

    public Float textToNumber(EditText eds) {
        return Float.parseFloat(eds.getText().toString());
    }

    public Float calculate(Float a , Float b, String op) throws NullPointerException {
        if (a == null || b == null ) {
            throw new NullPointerException();
        }
        switch (op) {
            case "+": return a  + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new InvalidParameterException();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("OnStart", "App is starting.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OnStart", "App has been stoppped");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OnResume", "On resume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OnPause", "App was paused.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OnDestroy", "App was destroyed.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("OnRestart", "App was restarted.");
    }

}
