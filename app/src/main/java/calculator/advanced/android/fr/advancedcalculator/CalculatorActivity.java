package calculator.advanced.android.fr.advancedcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    double op1 = 0;
    double op2 = 0;
    char operator = ' ';

    public void myClickHandler(View view) throws Exception {
        TextView operationText = findViewById(R.id.operationLabel);
        TextView resultText = findViewById(R.id.resultLabel);

        if(view.getId() == R.id.equalButton){
            String[] operation = operationText.getText().toString().split("[/*+-]");
            op1 = Double.parseDouble(operation[0]);
            op2 = Double.parseDouble(operation[1]);

            resultText.setText(String
                    .valueOf(CalculusServer.doOp(op1,op2,operator)));
            ;

        }
        else{
            Button b = (Button) view;
            switch (b.getText().toString()){
                case "+":
                    operator = '+';
                    break;
                case "*":
                    operator = '*';
                    break;
                case "-":
                    operator = '-';
                    break;
                case "/":
                    operator = '/';
                    break;
            }
            operationText.append(b.getText().toString());
        }
    }
}
