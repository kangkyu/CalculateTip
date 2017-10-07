package com.kangkyu.calculatetip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = (TextView) findViewById(R.id.resultText);
        final TextView tipAmount = (TextView) findViewById(R.id.tipAmountText);

        inputField = (EditText) findViewById(R.id.inputNumber);
        submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String subTotal = inputField.getText().toString();

                        // Toast.makeText(MainActivity.this, subTotal, Toast.LENGTH_LONG).show();

                        result.setText(Float.valueOf(subTotal) * 1.15 + ""); // tipping 15%
                        tipAmount.setText(Float.valueOf(subTotal) * 0.15 + "");
                    }
                }
        );
    }

}
