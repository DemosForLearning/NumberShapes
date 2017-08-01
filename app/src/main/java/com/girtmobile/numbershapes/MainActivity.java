package com.girtmobile.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)){
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangle(){
            int x = 1;
            int triangularNum = 1;

            while (triangularNum < number) {
                x++;
                triangularNum = triangularNum + x;
            }

            if (triangularNum == number) {
                return true;
            } else {
                return false;
            }
        }
    }


    public void testNum(View view) {
        String message = "";

        EditText usersNum = (EditText) findViewById(R.id.usersNum);

        if (usersNum.getText().toString().isEmpty()) {
            message = " Please enter a number";
        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(usersNum.getText().toString());


            if (myNumber.isSquare()) {
                if (myNumber.isTriangle()) {
                    message = myNumber.number + " is Triangular and Square!";
                } else {
                    message = myNumber.number + " is Square only!";
                }
            } else {
                if (myNumber.isTriangle()) {
                    message = myNumber.number + " is Triangular only!";
                } else {
                    message = myNumber.number + " is just a number!";
                }
            }
        }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
