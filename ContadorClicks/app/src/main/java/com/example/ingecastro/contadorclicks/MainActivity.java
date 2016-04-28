package com.example.ingecastro.contadorclicks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button b1,b2,b5;
    int contador=0;
    LinearLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.texto);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b5=(Button)findViewById(R.id.button5);
        screen=(LinearLayout)findViewById(R.id.screen);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                txt.setText(""+contador);
            }
        });


        b2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                contador++;
                txt.setText(""+contador);
                return false;
            }
        });




        EditText edt1 = (EditText) findViewById(R.id.edt1);
        edt1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    contador=contador+1;
                    txt.setText("" + contador);
                    return true;
                }
                return false;

            }});
        this.screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP){
                    contador++;
                    txt.setText(""+contador);
                }if (event.getAction()==MotionEvent.ACTION_DOWN){
                    contador++;
                    txt.setText(""+contador);
                }
                return false;
            }
        });

        this.txt.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    contador++;
                b5.setText("contador incrementado "+contador);
            }
        });

    }
}
