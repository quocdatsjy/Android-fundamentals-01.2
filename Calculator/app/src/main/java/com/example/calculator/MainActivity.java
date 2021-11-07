package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum Sign{
        PLUS, MINUS, MULTIPLE, DIVIDE
    }

    private long num1 = 0;
    private long num2 = 0;
    private boolean isSecondNum = false;
    private boolean isNewCal = false;
    private TextView curNum;
    private TextView curCal;
    private Sign sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curNum = (TextView) findViewById(R.id.text_view_cur_num);
        curCal = (TextView) findViewById(R.id.text_view_cur_cal);
    }

    public void onClickButtonNumber(View view) {
        int num = -1;
        if(isNewCal) {
            isNewCal = false;
            num1 = 0;
            curCal.setText("");
        }
        switch (view.getId()) {
            case R.id.button_0: num = 0; break;
            case R.id.button_1: num = 1; break;
            case R.id.button_2: num = 2; break;
            case R.id.button_3: num = 3; break;
            case R.id.button_4: num = 4; break;
            case R.id.button_5: num = 5; break;
            case R.id.button_6: num = 6; break;
            case R.id.button_7: num = 7; break;
            case R.id.button_8: num = 8; break;
            case R.id.button_9: num = 9; break;
            default: return;
        }
        if(!isSecondNum) {
            num1 = num1 * 10 + num;
            curNum.setText(String.valueOf(num1));
        } else {
            num2 = num2 * 10 + num;
            curNum.setText(String.valueOf(num2));
        }
    }

    public void onClickButtonSign(View view) {
        isNewCal = false;
        String str = "";
        if(!isSecondNum) {
            str = String.valueOf(num1);
            isSecondNum = true;
        } else {
            long res = calculate();
            str = String.valueOf(res);
            curNum.setText(str);
            this.reset();
            isSecondNum = true;
            num1 = res;
        }

        switch (view.getId()) {
            case R.id.button_plus: sign = Sign.PLUS; break;
            case R.id.button_minus: sign = Sign.MINUS; break;
            case R.id.button_multiple: sign = Sign.MULTIPLE; break;
            case R.id.button_divide: sign = Sign.DIVIDE; break;
            default: return;
        }

        str += this.getStringSign(sign);
        curCal.setText(str);
    }

    public String getStringSign(Sign s) {
        String string = "";
        switch (s) {
            case PLUS: string = "+"; break;
            case MINUS: string = "-"; break;
            case MULTIPLE: string = "×"; break;
            case DIVIDE: string = "÷"; break;
        }
        return string;
    }

    public void onClickButtonCal(View view) {
        long res = this.calculate();
        curNum.setText(String.valueOf(res));
        String str = ((String) curCal.getText()) + num2;
        curCal.setText(str);
        this.reset();
        num1 = res;
        isNewCal = true;
    }

    public long calculate() {
        long res = 0;
        switch (sign) {
            case PLUS: res = num1 + num2; break;
            case MINUS: res = num1 - num2; break;
            case MULTIPLE: res = num1 * num2; break;
            case DIVIDE: res = num1 / num2; break;
        }
        return res;
    }

    protected void reset() {
        num1 = 0;
        num2 = 0;
        isSecondNum = false;
    }

    public void onCLickButtonC(View view) {
        this.reset();
        curNum.setText("0");
        curCal.setText("");
    }

    public void onCLickButtonCE(View view) {
        if(!isSecondNum) {
            num1 = 0;
        } else {
            num2 = 0;
        }
        curNum.setText("0");
    }

    public void onClickButtonBackspace(View view) {
        if(!isSecondNum) {
            num1 /= 10;
            curNum.setText(String.valueOf(num1));
        } else {
            num2 /= 10;
            curNum.setText(String.valueOf(num2));
        }
    }

    public void onClickButtonSwapSign(View view) {
        if(!isSecondNum) {
            num1 *= -1;
            curNum.setText(String.valueOf(num1));
        } else {
            num2 *= -1;
            curNum.setText(String.valueOf(num2));
        }
    }
}