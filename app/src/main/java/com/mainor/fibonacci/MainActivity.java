package com.mainor.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())){
                    editText.setError("Please enter a number and try Again!");
                    editText.setFocusable(true);
                }
                else {
                    textView.setText(fibonacci(Integer.parseInt(editText.getText().toString())));
                }
            }
        });

    }

    private String fibonacci (int n) {
        String  text ="";
        ArrayList<BigInteger> fib =  new ArrayList<>();
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        fib.add(first);
        fib.add(second);
        for(int i = 1; i <n; i++){

            fib.add(fib.get(i).add(fib.get(i - 1)));
        }

        for(int i = 1; i <=n; i++) {

            text = text  + i +". " + fib.get(i) + "\n";

        }
        return  text;

    }
}

