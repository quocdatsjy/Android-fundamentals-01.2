package com.example.btngay0311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        List<String> hobby = new ArrayList<>();
        hobby.add("Thể thao");
        hobby.add("Du lịch");
        hobby.add("Âm nhạc");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, hobby);
        spinner.setAdapter(adapter);

        Button submit = findViewById(R.id.submit);

    }

    public void onSubmit(View view) {
        EditText name = findViewById(R.id.name);
        EditText mssv = findViewById(R.id.mssv);
        EditText date = findViewById(R.id.date);
        EditText phone = findViewById(R.id.phone);
        EditText email = findViewById(R.id.email);
        if(TextUtils.isEmpty(name.getText().toString()) ||
            TextUtils.isEmpty(mssv.getText().toString()) ||
            TextUtils.isEmpty(date.getText().toString()) ||
            TextUtils.isEmpty(phone.getText().toString()) ||
            TextUtils.isEmpty(email.getText().toString())) {
            Log.v("TAG", "Submit không thành công, còn thiếu thông tin bắt buộc");
        } else {
            Log.v("TAG", "Submit thành công");
        }
    }
}