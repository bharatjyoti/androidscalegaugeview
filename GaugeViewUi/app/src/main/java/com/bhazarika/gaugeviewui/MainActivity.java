package com.bhazarika.gaugeviewui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView valueTxt;
    private int defaultVal = 100;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueTxt = (TextView) findViewById(R.id.val);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        valueTxt.setText(String.valueOf(defaultVal));
    }

    public void onClick(View v){

        switch (v.getId()){

            case R.id.increase:

                defaultVal += 50;

                break;

            case R.id.decrease:

                defaultVal -= 50;

                break;
        }

        progressBar.setProgress(defaultVal);
        valueTxt.setText(String.valueOf(defaultVal));
    }
}
