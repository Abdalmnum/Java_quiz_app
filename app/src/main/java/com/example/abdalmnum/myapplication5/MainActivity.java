package com.example.abdalmnum.myapplication5;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int trueAns, subCount;
    private CheckBox chk_qu2_ch1;
    private CheckBox chk_qu2_ch2;
    private CheckBox chk_qu2_ch3;
    private EditText et_qu3_ans;
    private EditText et_qu5_ans;
    private RadioButton rb_qu1_Ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //question 1
        rb_qu1_Ch2 = (RadioButton) findViewById(R.id.rb_qu1Ch2);
        //question 2
        chk_qu2_ch1 = (CheckBox) findViewById(R.id.chk_qu2Ch1);
        chk_qu2_ch3 = (CheckBox) findViewById(R.id.chk_qu2Ch3);
        chk_qu2_ch2 = (CheckBox) findViewById(R.id.chk_qu2Ch2);
        //question 3
        et_qu3_ans = (EditText) findViewById(R.id.et_qu3Ans);

        //question 5
        et_qu5_ans = (EditText) findViewById(R.id.et_qu5Ans);
    }

    //get Result
    public void submit(View view) {
        subCount += 1;
        if (subCount > 1) {
            //to disable button and stop rotation
            Button submit = (Button) findViewById(R.id.submit);
            submit.setClickable(false);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            //quetion 1
            if (rb_qu1_Ch2.isChecked()) {
                trueAns += 1;
            }
            //get question 2 true answer
            if (chk_qu2_ch1.isChecked() && chk_qu2_ch3.isChecked() && !chk_qu2_ch2.isChecked()) {
                trueAns += 1;
            }
            //get question 3 true answer
            if (et_qu3_ans.getText().toString().equals("Null")) {
                trueAns += 1;
            }

            //get question 5 true answer
            if (et_qu5_ans.getText().toString().equals("15.7")) {
                trueAns += 1;
            }
            //display true and rong answer
            Toast.makeText(this, "true answer :" + String.valueOf(trueAns), Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Rong answer :" + String.valueOf(5 - trueAns), Toast.LENGTH_LONG).show();
        }

    }

    //true answer for all question
    public void AnswerTrue(View view) {
        //Toast
        Toast.makeText(this, "1 => -32768 to 32767" + "\n" + "2 => integers and floating point numbers" + "\n" + "3 =>  Null" + "\n" + "4 => double" + "\n" + "5 =>15.7", Toast.LENGTH_LONG).show();
        //question 1
        rb_qu1_Ch2.setChecked(true);
        //question 2
        chk_qu2_ch1.setChecked(true);
        chk_qu2_ch3.setChecked(true);
        //question 3
        et_qu3_ans.setText("Null");

        //question 5
        et_qu5_ans.setText("15.7");

    }
}
