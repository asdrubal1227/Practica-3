package com.brayanhoyos.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText temp = (EditText) findViewById(R.id.editText);
                EditText temp2= (EditText) findViewById(R.id.editText2);
                EditText temp3 = (EditText) findViewById(R.id.editText3);
                EditText temp4= (EditText) findViewById(R.id.editText4);
                TextView result= (TextView) findViewById(R.id.textView5);
                // Perform action on click
                float a=Float.parseFloat(temp.getText().toString());
                float b=Float.parseFloat(temp2.getText().toString());
                float c=Float.parseFloat(temp3.getText().toString());
                float d=Float.parseFloat(temp4.getText().toString());
                result.setText(String.format("%.2f",(a*0.15+b*0.1+c*0.4+d*0.35)));
            }
        });
    }
}
