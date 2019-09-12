package com.example.exe16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Context contexto = getApplicationContext();
        String texto;
        int duracao = Toast.LENGTH_LONG;

        EditText matricula = findViewById(R.id.Matricula);
        String matriculaText = matricula.getText().toString();

        EditText nome = findViewById(R.id.Nome);
        String nomeText = nome.getText().toString();

        EditText email = findViewById(R.id.Email);
        String emailText = email.getText().toString();

        EditText senha = findViewById(R.id.Senha);
        String senhaText = senha.getText().toString();

        EditText confSenha = findViewById(R.id.confSenha);
        String confSenhaText = senha.getText().toString();

        boolean b = Pattern.matches("/d", nomeText);

        if (TextUtils.isEmpty(matriculaText)) {
            Toast toast = Toast.makeText(contexto, "A matricula nao pode ser vazio", duracao);
            toast.show();
        }
        else if (TextUtils.isEmpty(nomeText)) {
            Toast toast = Toast.makeText(contexto, "O nome nao pode ser vazio", duracao);
            toast.show();
        }
        else  if (TextUtils.isEmpty(emailText)) {
            Toast toast = Toast.makeText(contexto, "O Email nao pode ser vazio", duracao);
            toast.show();
        }
        else if (TextUtils.isEmpty(senhaText)) {
            Toast toast = Toast.makeText(contexto, "A Senha nao pode ser vazio", duracao);
            toast.show();
        }
        else if (TextUtils.isEmpty(confSenhaText)) {
            Toast toast = Toast.makeText(contexto, "A Confirmação de senha nao pode ser vazio", duracao);
            toast.show();
        }
        else if (b) {
            Toast toast = Toast.makeText(contexto, "Entre somente letras", duracao);
            toast.show();
        }
        else if (Pattern.matches("/^[A-Za-z]+$/",matriculaText)) {
            Toast toast = Toast.makeText(contexto, "Entre somente numeros", duracao);
            toast.show();
        }
        else if (senhaText.matches("/^(?=.*[\\d])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])[\\w!@#$%^&*]{6,8}$/")) {
            Toast toast = Toast.makeText(contexto, "Senha invalida", duracao);
            toast.show();        }
        else if (confSenhaText.matches("/^(?=.*[\\d])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*])[\\w!@#$%^&*]{6,8}$/")) {
            Toast toast = Toast.makeText(contexto, "Entre somente numeros\"", duracao);
            toast.show();
        }  else {
            texto = "Tudo oK";
            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();
        }

    }
}
