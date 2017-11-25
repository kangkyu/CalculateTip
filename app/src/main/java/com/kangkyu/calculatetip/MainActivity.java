package com.kangkyu.calculatetip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int mPercentage = 15; // tipping 15% as initial value.
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
                        String subTotalString = inputField.getText().toString();

                        if (!subTotalString.matches("")) {
                            float subTotal = Float.valueOf(subTotalString);
                            double percentage = mPercentage * 1.0 / 100;

                            result.setText(NumberFormat.getCurrencyInstance().format(subTotal * (1 + percentage)));
                            tipAmount.setText(NumberFormat.getCurrencyInstance().format(subTotal * percentage));
                        } else {
                            Toast.makeText(MainActivity.this, "Not calculated with empty field", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        mPercentage = mPercentage + 1;
        displayPercentage(mPercentage);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        mPercentage = mPercentage - 1;
        displayPercentage(mPercentage);
    }

    /**
     * This method displays tip percentage with % sign on the screen.
     *
     * @param number percentage value as integer
     */
    private void displayPercentage(int number) {
        TextView percentTextView = (TextView) findViewById(R.id.percentage_text_view);
        percentTextView.setText(number + "%");
    }
}
