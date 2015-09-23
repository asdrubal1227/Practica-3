package com.brayanhoyos.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        View suma=findViewById(R.id.radioButton);
        suma.setOnClickListener(this);
        View resta=findViewById(R.id.radioButton2);
        resta.setOnClickListener(this);
        View multi=findViewById(R.id.radioButton3);
        multi.setOnClickListener(this);
        View divi=findViewById(R.id.radioButton4);
        divi.setOnClickListener(this);
    }

    public void onClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        EditText temp,temp2;
        TextView result;
        temp= (EditText) findViewById(R.id.editText);
        temp2= (EditText) findViewById(R.id.editText2);
        result= (TextView) findViewById(R.id.textView3);
        // Check which radio button was clicked
        float a=Float.parseFloat(temp.getText().toString());
        float b=Float.parseFloat(temp2.getText().toString());
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                result.setText("Resultado: "+(a+b));
                    break;
            case R.id.radioButton2:
                if (checked)
                    result.setText("Resultado: "+(a-b));
                    break;
            case R.id.radioButton3:
                if (checked)
                    result.setText("Resultado: "+(a*b));
                break;
            case R.id.radioButton4:
                if (checked)
                    result.setText("Resultado: "+(a/b));
                    break;
        }
    }
}
