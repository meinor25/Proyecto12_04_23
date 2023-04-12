package com.example.proyecto12_04_23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtDescripcion;
    CheckBox chkVag, chkProg, chkCom;
    RadioGroup rbgExcusas;

    RadioButton rbtExcusaSi, rbtExcusaNo;
    Spinner spnSalon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InicializarControles();

    }

    private void InicializarControles() {
        txtNombre = (EditText) findViewById(R.id.txt_name);
        txtDescripcion = (EditText) findViewById(R.id.txt_descripcion);
        chkProg = (CheckBox) findViewById(R.id.chkProgramando);
        chkVag = (CheckBox) findViewById(R.id.chkVagueando);
        chkCom = (CheckBox) findViewById(R.id.chkComiendo);
        rbgExcusas = (RadioGroup) findViewById(R.id.rdgExcusa);
        rbtExcusaSi = (RadioButton) findViewById(R.id.rbtSi);
        rbtExcusaNo = (RadioButton) findViewById(R.id.rbtNo);

        spnSalon = (Spinner) findViewById(R.id.spnSpinner);

    }

    public void EnviarDatos (View v) {
        try {
            String nombre = txtNombre.getText().toString();
            String descripcion = txtDescripcion.getText().toString();

            String motivos  = obtenerCheckbox();

            new Dialog().show(getSupportFragmentManager(), "Dialog");

            Toast.makeText(this, nombre + " " + descripcion + " " + motivos , Toast.LENGTH_SHORT).show();
        }catch (Exception e ){
            Toast.makeText(this, "Error => " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String obtenerCheckbox() {
        String checkboxs = "";

        if(chkProg.isChecked()) checkboxs += chkProg.getText() + ", ";
        if(chkCom.isChecked()) checkboxs += chkCom.getText() + ", ";
        if(chkVag.isChecked()) checkboxs += chkVag.getText() + ", ";


        return checkboxs;
    }


}