package com.brayanhoyos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        View calc1=findViewById(R.id.radioButton);
        calc1.setOnClickListener(this);
        View calc2=findViewById(R.id.radioButton2);
        calc2.setOnClickListener(this);
        View calc3=findViewById(R.id.radioButton3);
        calc3.setOnClickListener(this);
        View calc4=findViewById(R.id.radioButton4);
        calc4.setOnClickListener(this);
    }

    public void onClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        final EditText base,altura,radio,lado;
        final TextView result;
        base= (EditText) findViewById(R.id.editText);
        altura= (EditText) findViewById(R.id.editText2);
        radio= (EditText) findViewById(R.id.editText3);
        lado= (EditText) findViewById(R.id.editText4);
        result= (TextView) findViewById(R.id.textView5);
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    base.setVisibility(TextView.INVISIBLE);
                    altura.setVisibility(TextView.INVISIBLE);
                    radio.setVisibility(TextView.INVISIBLE);
                    lado.setVisibility(TextView.VISIBLE);

                final Button button = (Button) findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        float a = Float.parseFloat(lado.getText().toString());
                        result.setText(String.format("%.2f", a*a));
                    }
                });
                break;
            case R.id.radioButton2:
                if (checked)
                    base.setVisibility(TextView.VISIBLE);
                    altura.setVisibility(TextView.VISIBLE);
                    radio.setVisibility(TextView.INVISIBLE);
                    lado.setVisibility(TextView.INVISIBLE);

                final Button button2 = (Button) findViewById(R.id.button);
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        float a = Float.parseFloat(base.getText().toString());
                        float b = Float.parseFloat(altura.getText().toString());
                        result.setText(String.format("%.2f", a * b/2));
                    }
                });
                break;
            case R.id.radioButton3:
                if (checked)
                    base.setVisibility(TextView.VISIBLE);
                    altura.setVisibility(TextView.VISIBLE);
                    radio.setVisibility(TextView.INVISIBLE);
                    lado.setVisibility(TextView.INVISIBLE);

                final Button button3 = (Button) findViewById(R.id.button);
                button3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        float a = Float.parseFloat(base.getText().toString());
                        float b = Float.parseFloat(altura.getText().toString());
                        result.setText(String.format("%.2f", a * b));
                    }
                });
                break;
            case R.id.radioButton4:
                if (checked)
                    base.setVisibility(TextView.INVISIBLE);
                    altura.setVisibility(TextView.INVISIBLE);
                    radio.setVisibility(TextView.VISIBLE);
                    lado.setVisibility(TextView.INVISIBLE);

                final Button button4 = (Button) findViewById(R.id.button);
                button4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Perform action on click
                        float a = Float.parseFloat(radio.getText().toString());
                        result.setText(String.format("%.2f", a * a*3.1416));
                    }
                });
                break;
        }
    }
}
