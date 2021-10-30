package com.example.ortoprevina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Abaixode10 extends AppCompatActivity {

    Button guia2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abaixode10);

        guia2 = (Button) findViewById(R.id.guia2);

        guia2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent pdf = new Intent(Abaixode10.this, Guia.class);
                startActivity(pdf);

            }
        });
    }
}
