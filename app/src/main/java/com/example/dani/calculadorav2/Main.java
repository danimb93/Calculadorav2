package com.example.dani.calculadorav2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import static com.example.dani.calculadorav2.R.id.btnCalcular;
import static com.example.dani.calculadorav2.R.id.etnum1;
import static com.example.dani.calculadorav2.R.id.etnum2;
import static com.example.dani.calculadorav2.R.id.tvResultado;

public class Main extends AppCompatActivity {
    private Button calcular;
    private Spinner spinner;
    private EditText num1, num2;
    private TextView res;
    private String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.etnum1);
        num2 = (EditText) findViewById(R.id.etnum2);
        res = (EditText) findViewById(R.id.tvResultado);
        calcular = (Button) findViewById(btnCalcular);
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {"+", "-", "x", "/"};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(aa);
        proceso();
    }

    public void proceso()
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
        @Override
    public void onItemSelected(AdapterView av, View v, int p, long id)
    { try
    { if(p==0)
        res.setText("Resultado: Seleccione operacion");
    else
    { int valor1=Integer.parseInt(num1.getText().toString());
        int valor2=Integer.parseInt(num2.getText().toString());
        int total=0;
        switch(p)
        { case 1: total=valor1+valor2; break;
            case 2: total=valor1-valor2; break;
            case 3: total=valor1*valor2; break;
            case 4: total=valor1/valor2;;
        }
        res.setText("Resultado:"+total);
    }
    }
    catch(NumberFormatException e)
    { res.setText("Resultado: faltan datos");
    }
    catch(ArithmeticException e)
    { res.setText("Resultado: error en operacion");
    }
    }
        @Override
        public void onNothingSelected(AdapterView p)
        { }
    });
    }




    }

  //  @Override
   // public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
  //  }
