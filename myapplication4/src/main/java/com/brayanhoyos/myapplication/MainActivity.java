package com.brayanhoyos.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener  {
    private String ciudad, fecha, nombre, apellido, id,sexo="",hob1="",hob2="",hob3="",hob4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sValores = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Ciudad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sValores.setAdapter(adapter);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final EditText nom = (EditText) findViewById(R.id.editText);
                final EditText ape = (EditText) findViewById(R.id.editText2);
                final EditText ident = (EditText) findViewById(R.id.editText3);
                final EditText fech = (EditText) findViewById(R.id.txtdate);
                final TextView result = (TextView) findViewById(R.id.textView4);
                // Perform action on click
                nombre = nom.getText().toString();
                apellido = ape.getText().toString();
                id = ident.getText().toString();
                fecha = fech.getText().toString();
                ciudad = sValores.getSelectedItem().toString();
                result.setText("Nombre: " + nombre + "\nApellido: " + apellido + "\nIdentificación: " + id + "\nSexo: " + sexo + "\nFecha de Nacimiento: "
                        + fecha + "\nLugar de Nacimiento: " + ciudad + "\nHobbis:\t" + hob1 + hob2 + hob3 + hob4);

            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();

        final EditText txtDate=(EditText)findViewById(R.id.txtdate);
        txtDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog dialog = new DateDialog(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButton2:
                if (checked)
                    sexo="Masculino";
                break;
            case R.id.radioButton:
                if (checked)
                    sexo="Femenino";
                break;

        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox:
                if (checked){
                    hob1="Videojuegos, ";
                }
                else
                    hob1="";
                break;
            case R.id.checkBox2:
                if (checked){
                    hob2="Deportes, ";
                }
                else
                    hob2="";
                break;
            case R.id.checkBox3:
                if (checked){
                    hob3="Peliculas, ";
                }
                else
                    hob3="";
                break;
            case R.id.checkBox4:
                if (checked){
                    hob4="Estudiar";
                }
                else
                    hob4="";
                break;
            // TODO: Veggie sandwich
        }
    }
}
