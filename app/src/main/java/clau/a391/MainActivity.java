package clau.a391;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button cuadradosmedios;
    Button congruencialmixto;
    Button congruencialmultiplicativo;
    Button congruencualbinario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuadradosmedios=(Button)findViewById(R.id.BtnCuadradosMedios);
        cuadradosmedios.setOnClickListener(this);
        congruencialmixto=(Button)findViewById(R.id.BtnCongruencialMixto);
        congruencialmixto.setOnClickListener(this);
        congruencialmultiplicativo=(Button)findViewById(R.id.BtnCongruencialMultiplicativo);
        congruencialmultiplicativo.setOnClickListener(this);
        congruencualbinario=(Button)findViewById(R.id.BtnCongruencialBinario);
        congruencualbinario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       Intent intent;
        switch (v.getId())
        {
            case R.id.BtnCuadradosMedios:
                intent = new Intent(MainActivity.this,cuadrados_medios.class);
                startActivity(intent);
                break;

            case R.id.BtnCongruencialMixto:
                intent = new Intent(MainActivity.this,congruencial_mixto.class);
                startActivity(intent);
                break;
            case R.id.BtnCongruencialMultiplicativo:
                intent=new Intent(MainActivity.this,Multiplicativa.class);
                break;
            case R.id.BtnCongruencialBinario:
                intent=new Intent(MainActivity.this,Binario.class);
                break;
        }
    }
}
