package clau.a391;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class congruencial_mixto extends AppCompatActivity implements View.OnClickListener{
    EditText multiplicador;
    EditText constante;
    EditText modulo;
    EditText semilla;
    Button generar;
   TextView resultado;
    Button limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congruencial_mixto);
        multiplicador=(EditText) findViewById(R.id.EdtCongruencialMixtoMultiplicador);
        constante=(EditText)findViewById(R.id.EdtCongruencialMixtoConstante);
        modulo=(EditText)findViewById(R.id.EdtCongruencialMixtoModulo);
        semilla=(EditText)findViewById(R.id.EdtCongruencialMixtoSemilla);
        resultado=(TextView) findViewById(R.id.TxtCongruencialMixtoResultado);
        generar=(Button)findViewById(R.id.BtnCongruencialMixtoGenerar);
        generar.setOnClickListener(this);
        limpiar=(Button)findViewById(R.id.BtnCongruencialMixtoLimpiar);
        limpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double c;
        double a;
        double m;
        double x0;
        double xn=0;
        double decimal=0;
        int e=0;
        int cont=0;


        switch (v.getId()){
            case R.id.BtnCongruencialMixtoGenerar:
                String res=" n      Xn      Xn+1        Decimal\n" ;
                c=Double.parseDouble(constante.getText().toString());
                a=Double.parseDouble(multiplicador.getText().toString());
                m=Double.parseDouble(modulo.getText().toString());
                x0 = Double.parseDouble(semilla.getText().toString());
                double aux=x0;
                if(x0!=0)
                {
                    while (aux!=xn) {
                    xn = ((x0 * a) + c) % m;
                    e = (int) xn;
                    decimal = e / m;
                    res = res + " " + String.valueOf(cont) + "        " + String.valueOf((int) x0) + "           " + String.valueOf(e) + "         " + String.valueOf(decimal) + "\n";
                    cont++;
                    x0 = xn;
                    resultado.setText(res);
                     }
                }else{
                    Toast.makeText(this,"No se puede resolver x alguna razon xD",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.BtnCongruencialMixtoLimpiar:
                multiplicador.setText(" ");
                constante.setText(" ");
                modulo.setText(" ");
                semilla.setText(" ");
                resultado.setText(" ");
                break;
        }
    }
}

