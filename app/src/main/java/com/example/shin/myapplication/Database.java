package com.example.shin.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editText_name, editText_brand, editText_price;
    Button adddataBtn;
    Button viewAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        myDb = new DataBaseHelper(this);

        editText_brand = findViewById(R.id.editText_brand);
        editText_name = findViewById(R.id.editText_name);
        editText_price = findViewById(R.id.editText_price);
        adddataBtn = findViewById(R.id.addBtn);
        viewAllBtn = findViewById(R.id.viewBtn);
        addData();
        viewAll();
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

    public void viewAll() {
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("id:" + res.getString(0) + "\n");
                    buffer.append("brand:" + res.getString(1)+ "\n");
                    buffer.append("name:" + res.getString(2)+ "\n");
                    buffer.append("price:" + res.getString(3)+ "\n\n");
                }

                // show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
