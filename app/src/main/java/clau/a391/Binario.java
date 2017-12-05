package clau.a391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Binario extends AppCompatActivity implements View.OnClickListener{

    EditText constante;
    EditText modulo;
    EditText semilla;
    Button generar;
    TextView resultado;
    Button limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binario);


        constante=(EditText)findViewById(R.id.EdtCongruenciaBinarioConstante);
        modulo=(EditText)findViewById(R.id.EdtCongruenciaBinarioModulo);
        semilla=(EditText)findViewById(R.id.EdtCongruenciaBinarioSemilla);
        resultado=(TextView) findViewById(R.id.TxtCongruenciaBinarioResultado);
        generar=(Button)findViewById(R.id.BtnCongruenciaBinarioGenerar);
        generar.setOnClickListener(this);
        limpiar=(Button)findViewById(R.id.BtnCongruenciaBinarioLimpiar);
        limpiar.setOnClickListener(this);
    }


    public void onClick(View v) {

        int t;
        int m;
        double x0;
        int a=0;

        double xn=0;
        int i=0;
        int j=1;



        switch (v.getId()){
            case R.id.BtnCongruencialMultiplicativoGenerar:
                String res=" n      Xn      Xn+1\n  " ;
                t=Integer.parseInt(constante.getText().toString());
                m=Integer.parseInt(modulo.getText().toString());
                x0 = Double.parseDouble(semilla.getText().toString());
                double aux=x0;
                a=8*t+3;
                for (j=1;j<1048576;j++){
                    if (m!= Math.pow(2,j)){

                    }else{
                        break;
                    }

                }
                j++;

                if(x0!=0)
                {
                    for (i=1;i<j ;i++) {
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
