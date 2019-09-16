package com.example.exe16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.sexoRadioButton);
        radioGroup1 = (RadioGroup) findViewById(R.id.cursoGroup);
        radioGroup2 = (RadioGroup) findViewById(R.id.notiGroup);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.masculino) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Masculino",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.feminino) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Feminino",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });


        radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.ads) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Ads",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.eng) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Eng",
                            Toast.LENGTH_SHORT).show();
                }
                else if (checkedId == R.id.cie) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Ciências",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });


        radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                // find which radio button is selected
                if (checkedId == R.id.notiSim) {
                    Toast.makeText(getApplicationContext(), "Escolhido: SIM",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.eng) {
                    Toast.makeText(getApplicationContext(), "Escolhido: NAO",
                            Toast.LENGTH_SHORT).show();
                }}
            });
    }

    public void sendMessage(View view) {
        final Context contexto = getApplicationContext();
        String texto;
        final int duracao = Toast.LENGTH_LONG;

        EditText matricula = findViewById(R.id.Matricula);
        String matriculaText = matricula.getText().toString();

        EditText nome = findViewById(R.id.Nome);
        String nomeText = nome.getText().toString();

        EditText email = findViewById(R.id.Email);
        String emailText = email.getText().toString();

        EditText senha = findViewById(R.id.Senha);
        String senhaText = senha.getText().toString();

        EditText confSenha = findViewById(R.id.confSenha);
        String confSenhaText = confSenha.getText().toString();


        EditText date = findViewById(R.id.Date);
        String dateText = confSenha.getText().toString();

        boolean letrasRegex = Pattern.matches("\\d", nomeText);
        boolean numerosRegex = Pattern.matches("\\w", matriculaText);
        boolean senhaRegex = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,8}$", senhaText);
        boolean confSenhaRegex = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,8}$", confSenhaText);
        boolean emailRegex = Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", emailText);

        if (dateText != null) {
            Date cDate = new Date();
            String fDate = new SimpleDateFormat("dd-MM-yyyy").format(cDate);



        }
//        if (TextUtils.isEmpty(matriculaText)) {
//            Toast toast = Toast.makeText(contexto, "A matricula nao pode ser vazio", duracao);
//            toast.show();
//        } else if (TextUtils.isEmpty(nomeText)) {
//            Toast toast = Toast.makeText(contexto, "O nome nao pode ser vazio", duracao);
//            toast.show();
//        } else if (TextUtils.isEmpty(emailText)) {
//            Toast toast = Toast.makeText(contexto, "O Email nao pode ser vazio", duracao);
//            toast.show();
//        } else if (TextUtils.isEmpty(senhaText)) {
//            Toast toast = Toast.makeText(contexto, "A Senha nao pode ser vazio", duracao);
//            toast.show();
//        } else if (TextUtils.isEmpty(confSenhaText)) {
//            Toast toast = Toast.makeText(contexto, "A Confirmação de senha nao pode ser vazio", duracao);
//            toast.show();
//        } else if (letrasRegex) {
//            Toast toast = Toast.makeText(contexto, "Entre somente letras no nome", duracao);
//            toast.show();
//        } else if (!emailRegex) {
//            Toast toast = Toast.makeText(contexto, "Entre um email valido", duracao);
//            toast.show();
//        } else if (numerosRegex) {
//            Toast toast = Toast.makeText(contexto, "Entre somente numeros na matricula", duracao);
//            toast.show();
//        } else if (!senhaRegex) {
//            Toast toast = Toast.makeText(contexto, "Senha invalida", duracao);
//            toast.show();
//        } else if (!confSenhaRegex) {
//            Toast toast = Toast.makeText(contexto, "Confirmação de senha invalida", duracao);
//            toast.show();
//        } else if (!senhaText.equals(confSenhaText)) {
//            Toast toast = Toast.makeText(contexto, "A senha e a confirmação devem ser iguais", duracao);
//            toast.show();
//        }
        else {
            texto = "Tudo OK";
            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();
        }

    }
}
