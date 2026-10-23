package com.example.sqlite1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText t1;
    TextView text;

    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1 = b1.findViewById(R.id.b1);
        b2 = b2.findViewById(R.id.b2);
        t1 = t1.findViewById(R.id.t1);
        text = text.findViewById(R.id.text);
        dbHelper = new DatabaseHelper(this);
    }
public void add(View view)
        {
            String name=t1.getText().toString();
            if (dbHelper.addName(name)){
                Toast.makeText(this, "Name added", Toast.LENGTH_SHORT).show();
            t1.setText("");
            }
            else {
                Toast.makeText(this, "Failed to add name", Toast.LENGTH_SHORT).show();
            }

            }

            public void show(View view)
            {
                String names=dbHelper.getAllNames();
                text.setText(names);
            }
        }


