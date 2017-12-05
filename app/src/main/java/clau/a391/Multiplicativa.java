package clau.a391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Multiplicativa extends AppCompatActivity implements View.OnClickListener {

    EditText constante;
    EditText modulo;
    EditText semilla;
    Button generar;
    TextView resultado;
    Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicativa);

        constante=(EditText)findViewById(R.id.EdtCongruencialMultiplicativoConstante);
        modulo=(EditText)findViewById(R.id.EdtCongruencialMultiplicativaModulo);
        semilla=(EditText)findViewById(R.id.EdtCongruencialMultiplicativaSemilla);
        resultado=(TextView) findViewById(R.id.TxtCongruencialMultiplicativaResultado);
        generar=(Button)findViewById(R.id.BtnCongruencialMultiplicativoGenerar);
        generar.setOnClickListener(this);
        limpiar=(Button)findViewById(R.id.BtnCongruencialMultiplicativoLimpiar);
        limpiar.setOnClickListener(this);
    }

    public void onClick(View v) {

        double a;
        double m;
        double x0;
        double xn=0;
        int i=0;



        switch (v.getId()){
            case R.id.BtnCongruencialMultiplicativoGenerar:
                String res=" n      Xn      Xn+1\n" ;
                a=Double.parseDouble(constante.getText().toString());
                m=Double.parseDouble(modulo.getText().toString());
                x0 = Double.parseDouble(semilla.getText().toString());
                double aux=x0;
                if(x0!=0)
                {
                    for (i=1;i<20 ;i++) {
                        xn = ((x0 * a)) % m;


                        res = res + " " + String.valueOf(i) + "        " + String.valueOf((int) x0) + "                " + String.valueOf(xn) + "\n";

                        x0 = xn;
                        resultado.setText(res);
                    }
                }else{
                    Toast.makeText(this,"No se puede resolver x alguna razon xD",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.BtnCongruencialMultiplicativoLimpiar:

                constante.setText(" ");
                modulo.setText(" ");
                semilla.setText(" ");
                resultado.setText(" ");
                break;
        }
    }
}
