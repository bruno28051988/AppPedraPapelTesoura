package com.br.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        //Linkando meu elemento do código ao elemento gráfico
        ImageView imagemResultado = findViewById(R.id.imgResultado);
        TextView textResultado = findViewById(R.id.txtResultado);

        //Gerando a jogada / escolha do app
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero]; // opcoes[pedra] ou opcoes[papel] ou opcoes[tesoura]

        switch(escolhaApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "pepal":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //Comparando as escolhas e gerando o resultado
        if( (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                    (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ) {//Aplicativo ganhou
            textResultado.setText("App Ganhou!");

        }else if((escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                    (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ) {//Usuario ganhou) {
            textResultado.setText("Você Ganhou!");
        }else{
            textResultado.setText("Empatamos!");
        }

    }







}