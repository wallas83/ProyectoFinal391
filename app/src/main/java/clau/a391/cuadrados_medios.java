package clau.a391;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cuadrados_medios extends AppCompatActivity implements View.OnClickListener{
    EditText semilla;
    Button generar;
    TextView resultado;
    String res="";
    Button limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrados_medios);
        semilla=(EditText)findViewById(R.id.EdtCuadradosMediosSemilla);
        generar=(Button)findViewById(R.id.BtnCuadradosMediosGenerar);
        generar.setOnClickListener(this);
        resultado=(TextView)findViewById(R.id.TxtCuadradosMediosResultado);
        limpiar=(Button)findViewById(R.id.BtnCuadradosMediosLimpiar);
        limpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View w)
    {
        switch (w.getId())
        {
            case R.id.BtnCuadradosMediosGenerar:
                long x = Integer.parseInt(semilla.getText().toString());
                long d=contardigitos(x);
                long d2=0;
                long c=0;
                long v[]=new  long[1000];
                //float numero_decimal =0;
                //System.out.println("La cantidad de digitos de este numero es :" +x + " es: " + d);
                // Verificando que la cantidad de digitos sea mayor a 3
                if (d>3) {
                    while (x>0){
                        c++;
                        x=(long) Math.pow(x, 2);
                        //System.out.println(x);
                        if (d%2==0) {
                            //System.out.println("entra");
                            //System.out.println("la cantidad de digitos es: "+d );
                            d2=d/2;
                            x=x/(int) Math.pow(10, d2);
                            //System.out.println("primera division "+ x);
                            x=x%(int) Math.pow(10, d);

                            v[(int) c]=x;
                            res=res+"\t"+c+ ": "+"\tx : " + x +" "+"\tu : " + (float)x/Math.pow(10, d)+ "\n";

                        }
                        else{
                            long cc=contardigitos((long) Math.pow(x, 2));
                            x=x+(long)Math.pow(10,cc);
                            d2=d/2;
                            x=x/(long) Math.pow(10, d2);
                            //System.out.println("primera division "+ x);
                            x=x%(long) Math.pow(10, d);
                            v[(int) c]=x;

                            //System.out.println("la cantidad de digitos es "+ cantidad);
                            res=res+"\t"+c+ ": "+"\tx : " + x +" "+"\tu : " + (float)x/Math.pow(10, d)+ "\n";
                        }


                        if(c!=1)
                        {
                            if (encontrar(v,c,v[(int) c])) {

                                break;
                            }
                            {
                                //System.out.println("Siga su camino");
                            }
                        }

                    }
                    resultado.setText(res);
                }
                res="";
                break;
            case R.id.BtnCuadradosMediosLimpiar:
                semilla.setText(" ");
                resultado.setText(" ");
                break;
        }
    }
    public  long contardigitos(long n){
        long c=0;
        while (n>0) {
            n=n/10;
            c++;
        }
        return c;

    }

    public  boolean encontrar(long[]n, long c, long x){

        for (long i = c-1; i >=1; i--) {
            //System.out.println("esta :" +n[i]);
            if (x==n[(int) i]){
                System.out.println("");
                Toast.makeText(this,"El numero repetido es: "+i +" x: "+ x,Toast.LENGTH_LONG).show();
                //	System.out.println("Se encuentra repetido en la posicion "+ i);
                return true;
            }
        }
        return false;
    }

}
