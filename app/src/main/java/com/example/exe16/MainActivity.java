package com.example.exe16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private boolean adsEscolhido = false;
    private boolean cieEscolhido = false;
    private boolean engEscolhido = false;


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
                    adsEscolhido = true;
                    Toast.makeText(getApplicationContext(), "Escolhido: Análise e Desenvolvimento de Sistemas",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.engenhariaComp) {
                    engEscolhido = true;
                    Toast.makeText(getApplicationContext(), "Escolhido: Engenharia da Computação",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.cienciaComp) {
                    cieEscolhido = true;
                    Toast.makeText(getApplicationContext(), "Escolhido: Ciências da computacão",
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
                    Toast.makeText(getApplicationContext(), "Escolhido: Sim",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.notiNao) {
                    Toast.makeText(getApplicationContext(), "Escolhido: Não",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sendMessage(View view) {
        final Context contexto = getApplicationContext();
        String texto;
        final int duracao = Toast.LENGTH_SHORT;

        EditText matricula = findViewById(R.id.matricula);
        String matriculaText = matricula.getText().toString();

        EditText nome = findViewById(R.id.nome);
        String nomeText = nome.getText().toString();

        EditText email = findViewById(R.id.email);
        String emailText = email.getText().toString();

        EditText senha = findViewById(R.id.senha);
        String senhaText = senha.getText().toString();

        EditText confSenha = findViewById(R.id.contraSenha);
        String confSenhaText = confSenha.getText().toString();

        EditText date = findViewById(R.id.Date);
        String dateText = date.getText().toString();

        CheckBox checkCiencias = findViewById(R.id.cienciaCompCheck);
        CheckBox checkAds = findViewById(R.id.AdsCheck);
        CheckBox checkEngenharia = findViewById(R.id.engenhariaCompCheck);

        boolean letrasRegex = Pattern.matches("\\d", nomeText);
        boolean numerosRegex = Pattern.matches("\\w", matriculaText);
        boolean senhaRegex = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,8}$", senhaText);
        boolean confSenhaRegex = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,8}$", confSenhaText);
        boolean emailRegex = Pattern.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", emailText);


        if (!TextUtils.isEmpty(dateText)) {

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date strDate = format.parse(dateText);
                Date atual = new Date();
                if (strDate.after(atual)) {
                    Toast toast = Toast.makeText(contexto, "data inválida", duracao);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(contexto, "data valida", duracao);
                    toast.show();
                }
            } catch (ParseException e) {
                //handle exception
            }
        }


        if (TextUtils.isEmpty(matriculaText)) {
            Toast toast = Toast.makeText(contexto, "A matrícula não pode ser vazio", duracao);
            toast.show();
        } else if (matriculaText.length() > 20) {
            Toast toast = Toast.makeText(contexto, "Insira uma matricula de tamanho valido", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(nomeText)) {
            Toast toast = Toast.makeText(contexto, "O nome não pode ser vazio", duracao);
            toast.show();
        } else if (nomeText.length() < 3) {
            Toast toast = Toast.makeText(contexto, "Insira um nome de tamanho valido", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(emailText)) {
            Toast toast = Toast.makeText(contexto, "O Email não pode ser vazio", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(senhaText)) {
            Toast toast = Toast.makeText(contexto, "A Senha não pode ser vazio", duracao);
            toast.show();
        } else if (TextUtils.isEmpty(confSenhaText)) {
            Toast toast = Toast.makeText(contexto, "A Confirmação de senha não pode ser vazio", duracao);
            toast.show();
        } else if (letrasRegex) {
            Toast toast = Toast.makeText(contexto, "Entre somente letras no nome", duracao);
            toast.show();
        } else if (!emailRegex) {
            Toast toast = Toast.makeText(contexto, "Entre um e-mail valido", duracao);
            toast.show();
        } else if (numerosRegex) {
            Toast toast = Toast.makeText(contexto, "Entre somente números na matricula", duracao);
            toast.show();
        } else if (!senhaRegex) {
            Toast toast = Toast.makeText(contexto, "Senha inválida", duracao);
            toast.show();
        } else if (!confSenhaRegex) {
            Toast toast = Toast.makeText(contexto, "Confirmação de senha inválida", duracao);
            toast.show();
        } else if (!senhaText.equals(confSenhaText)) {
            Toast toast = Toast.makeText(contexto, "A senha e a confirmação devem ser iguais", duracao);
            toast.show();
        } else if (checkCiencias.isChecked() && cieEscolhido) {
            Toast toast = Toast.makeText(contexto, "O curso escolhido não pode ser o mesmo denão cursaria", duracao);
            toast.show();
        } else if (checkAds.isChecked() && adsEscolhido) {
            Toast toast = Toast.makeText(contexto, "O curso escolhido não pode ser o mesmo de não cursaria", duracao);
            toast.show();
        } else if (checkEngenharia.isChecked() && engEscolhido) {
            Toast toast = Toast.makeText(contexto, "O curso escolhido não pode ser o mesmo de não cursaria", duracao);
            toast.show();
        } else {
            texto = "Tudo OK";
            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();
        }

    }
}
