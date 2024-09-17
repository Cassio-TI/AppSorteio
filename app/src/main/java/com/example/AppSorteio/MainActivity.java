package com.example.AppSorteio;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appcadastro.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText visor, num1, num2;
    private RadioButton aleatorio, par, impar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.visor = findViewById(R.id.visor);
        this.num1 = findViewById(R.id.num1);
        this.num2 = findViewById(R.id.num2);
        this.aleatorio = findViewById(R.id.aleatorio);
        this.par = findViewById(R.id.par);
        this.impar = findViewById(R.id.impar);
    }//Fim do OnCreate
    public void sortear(View v){
        String text1 = num1.getText().toString();
        String text2 = num2.getText().toString();

        if(text1.isEmpty() || text2.isEmpty()){
            mensagem("Insira os valores solicitados");
        } else {
            int v1 = Integer.parseInt(text1);
            int v2 = Integer.parseInt(text2);

            if (v1 > v2) {
                mensagem("O primeiro valor deve ser menor que o segundo");
            } else if (v1 == v2) {
                mensagem("Os valores não podem ser iguais");
            } else {

                if (aleatorio.isChecked()) {
                    Random random = new Random();
                    int inferior = v1;
                    int superior = v2;
                    int sorteado = random.nextInt(superior - inferior + 1) + inferior;
                    visor.setText(sorteado + "");
                }

                else if (par.isChecked()) {
                    Random random = new Random();
                    int inferior = v1;
                    int superior = v2;
                    int sorteado = random.nextInt(superior - inferior + 1) + inferior;
                    if (sorteado % 2 == 0) {
                        visor.setText(sorteado + "");
                    } else if (sorteado == v2 && v2 % 2 != 0){
                        visor.setText(sorteado - 1 + "");
                    } else if (sorteado % 2 != 0) {
                        visor.setText(sorteado + 1 + "");
                    }
                }

                else if (impar.isChecked()) {
                    Random random = new Random();
                    int inferior = v1;
                    int superior = v2;
                    int sorteado = random.nextInt(superior - inferior + 1) + inferior;
                    if (sorteado % 2 != 0) {
                        visor.setText(sorteado + "");
                    } else if (sorteado == v2 && v2 % 2 == 0){
                        visor.setText(sorteado - 1 + "");
                    } else if (sorteado % 2 == 0) {
                        visor.setText(sorteado + 1 + "");
                    }
                }
                else {
                    mensagem("Selecione uma opção");
                }
            }
        }
    }//Fim do sortear

    private void mensagem(String text) {
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Atenção");
        msg.setMessage(text);
        msg.setNeutralButton("OK", null);
        msg.create();
        msg.show();
    }
}//Fim da Classe