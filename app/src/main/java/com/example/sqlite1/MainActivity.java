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
    Button b1;
    Button b2;
    EditText e1;
    TextView t1;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        t1 = findViewById(R.id.t1);
        dbHelper = new DatabaseHelper(this);
        b1.setOnClickListener(v -> {
            String name = e1.getText().toString().trim();
            if (name.isEmpty()) {
                e1.setError("Enter a name");
                return;
            }
            if (dbHelper.addName(name)) {
                Toast.makeText(this, "Name added",
                        Toast.LENGTH_SHORT).show();
                e1.setText("");
            } else {
                Toast.makeText(this, "Failed to add name",
                        Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(v -> {
            String names = dbHelper.getAllNames();
            t1.setText(names);

        });
    }
}




