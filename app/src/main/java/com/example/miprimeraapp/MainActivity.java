package com.example.miprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    public int contador;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoResultado=(TextView)findViewById(R.id.contadorTexto);
        contador=0;
        EventoTeclado teclado=new EventoTeclado();//Creacion del elemento
        EditText n_reseteo=(EditText)findViewById(R.id.n_reseteo);//casting
        n_reseteo.setOnEditorActionListener(teclado);
    }
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId==EditorInfo.IME_ACTION_DONE){
                resetaContador(null);
            }
            return false;
        }
    }

    public void incrementaContador(View vista){
        contador++;
        textoResultado.setText("" + contador);
        //mostarResultado();
    }

    public void restaContador(View vista) {
        contador--;
        if (contador < 0) {
            CheckBox negativos = (CheckBox) findViewById(R.id.negativos);
            if (!negativos.isChecked()) {
                contador = 0;
            }
        }
        textoResultado.setText("" + contador);
        //mostarResultado();
    }


    public void resetaContador(View vista){
        EditText numero_reset=(EditText)findViewById(R.id.n_reseteo);
        try {
            contador = Integer.parseInt(numero_reset.getText().toString());
        }catch (Exception e){
            contador=0;
        }
        numero_reset.setText("");
        textoResultado.setText("" + contador);
        //contador=0;
        //mostarResultado();
            InputMethodManager miteclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);// Estas dos linea son para esconder el teclado numerico despues de ser utilizado
            miteclado.hideSoftInputFromWindow(numero_reset.getWindowToken(),0);
        }
    }

   /* public void mostarResultado(){

        TextView textoResultado=(TextView)findViewById(R.id.contadorTexto);
        textoResultado.setText("" + contador);
    }*/

