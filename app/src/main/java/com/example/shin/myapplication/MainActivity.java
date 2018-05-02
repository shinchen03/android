package com.example.shin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1 = (EditText) findViewById(R.id.firstNumEditText);
                EditText t2 = (EditText) findViewById(R.id.SecondNum);
                TextView result = (TextView) findViewById(R.id.ResulttextView);

                int num1 = Integer.parseInt(t1.getText().toString());
                int num2 = Integer.parseInt(t2.getText().toString());
                int res = num1 + num2;
                result.setText(res + "");
            }
        });
    }
}
