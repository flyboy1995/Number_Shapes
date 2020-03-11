package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        et = findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et.getText().toString();
                int test_number = Integer.parseInt(et.getText().toString());

                if (isSquare(test_number)&!isTriangular(test_number)) {
                    Toast.makeText(MainActivity.this, number + " is square, but not triangular.", Toast.LENGTH_LONG).show();
                }
                else if (!isSquare(test_number)&isTriangular(test_number)) {
                    Toast.makeText(MainActivity.this, number + " is triangular, but not square.", Toast.LENGTH_LONG).show();
                }
                else if (isSquare(test_number)&isTriangular(test_number)) {
                    Toast.makeText(MainActivity.this, number + " is both square and triangular.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, number + " is neither square nor triangular.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public boolean isSquare(int number) {
        double squareRoot = Math.sqrt(number);
        if (squareRoot == Math.floor(squareRoot)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTriangular(int number) {
        int x = 1;
        int triangularNumber = 1;
        while (triangularNumber < number) {
            x++;
            triangularNumber = triangularNumber + x;
        }
        if (triangularNumber == number) {
            return true;
        } else {
            return false;
        }
    }

}

