package com.example.shin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editText_name, editText_brand, editText_price;
    Button adddataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        myDb = new DataBaseHelper(this);

        editText_brand = findViewById(R.id.editText_brand);
        editText_name = findViewById(R.id.editText_name);
        editText_price = findViewById(R.id.editText_price);
        adddataBtn = findViewById(R.id.addBtn);
        addData();
    }

    public void addData() {
        adddataBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  boolean isInserted = myDb.insertData(editText_brand.getText().toString(),
                          editText_name.getText().toString(),
                          editText_price.getText().toString());
                  if (isInserted) Toast.makeText(Database.this, "Data inserted", Toast.LENGTH_LONG).show();
                  else Toast.makeText(Database.this, "Data not inserted", Toast.LENGTH_LONG).show();
              }
          }
        );
    }
}
