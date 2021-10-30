package com.example.ortoprevina;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shockwave.pdfium.PdfDocument;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


public class Resultado extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b10;
    private Button b11;
    private TextView tvR;
    private TextView tvRisco;
    private Button btMaisOrient;
    private Button btPdf;
    int escreverresult;
    int Risco;
    int finalReceberresultado;
    int receberresultado;




    @SuppressLint({"WrongViewCast", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        TextView tvR = (TextView) findViewById(R.id.tvR);
        TextView tvRisco = (TextView) findViewById(R.id.tvRisco);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button b10 = (Button) findViewById(R.id.b10);
        Button b11 = (Button) findViewById(R.id.b11);
        Button btMaisOrient = (Button) findViewById(R.id.btMaisOrient);
        Button btPdf = (Button) findViewById(R.id.btPdf);


        //declarando os valores

        // pegando os parametros intent
        Intent intent = getIntent();
        //validando a intent
        if (intent != null) {
            Bundle params = intent.getExtras();
            //validando se há parametros
            if (params != null) {
                //resgatando os valores na segunda intent
                receberresultado = params.getInt("resultado");
            }
            String risc;
            risc = (String.valueOf(receberresultado));
            tvRisco.setText(risc);
        }


        btMaisOrient.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Resultado.this, MaisOrientacoes.class);
                startActivity(it);
            }
        });


        btPdf.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent pdf = new Intent(Resultado.this, Guia.class);
                startActivity(pdf);

            }
        });

                Risco = receberresultado;

                if (Risco >= 10 & Risco < 15) {
                    tvR.setText("Cuidados Recomendados - Em RISCO");
                    tvR.setBackgroundColor(Color.parseColor("#EACF1F"));
                } else if (Risco >= 15 & Risco < 20) {
                    tvR.setText("Cuidados Recomendados - Em ALTO RISCO");
                    tvR.setBackgroundColor(Color.parseColor("#DD6220"));
                } else if (Risco >= 20) {
                    tvR.setText("Cuidados Recomendados - Em ALTÍSSIMO RISCO");
                    tvR.setBackgroundColor(Color.parseColor("#DD2020"));
                }


                b1.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder indicacao1 = new AlertDialog.Builder(Resultado.this);
                            indicacao1.setTitle("Medidas Preventivas");
                            indicacao1.setMessage("- Comunicar nutricionista elaboração de plano nutricional.");
                            indicacao1.setNeutralButton("OK", null);
                            indicacao1.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Comunicar nutricionista para desenvolvimento e aplicação de um plano nutricional individualizado");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Comunicar nutricionista para desenvolvimento e aplicação de um plano nutricional individualizado. ");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b2.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Utilizar água, sabão e produtos de limpeza preferencialmente com pH levemente ácido; \n- Evitar esfregar a pele vigorosamente durante a higiene; \n- Hidratar a pele com hidratante corporal após o banho;\n- Verificar se a roupa de cama está bem esticada, sem dobras ou costuras em contato com a pele. ");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("-Utilizar água, sabão e produtos de limpeza preferencialmente com pH levemente ácido;\n- Evitar esfregar a pele vigorosamente durante a higiene;\n- Hidratar a pele com hidratante corporal após o banho;\n- Verificar se a roupa de cama está bem esticada, sem dobras ou costuras em contato com a pele.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("-Utilizar água, sabão e produtos de limpeza preferencialmente com pH levemente ácido;\n- Evitar esfregar a pele vigorosamente durante a higiene;\n- Hidratar a pele com hidratante corporal após o banho;\n- Verificar se a roupa de cama está bem esticada, sem dobras ou costuras em contato com a pele.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }

                });
                b3.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Manejo do microclima:\n• Limpar a pele imediatamente após episódios de incontinência;\n• Utilizar creme barreira  nos casos de incontinência urinária e fecal;\n• Em casos de diarréia aplicar protetor cutâneo diariamente;\n• Troca de fraldas frequentemente.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("Manejo do microclima:\n• Limpar a pele imediatamente após episódios de incontinência;\n• Utilizar creme barreira nos casos de incontinência urinária e fecal;\n• Em casos de diarréia aplicar protetor cutâneo diariamente;\n• Troca de fraldas frequentemente.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("Manejo do microclima:\n• Limpar a pele imediatamente após episódios de incontinência;\n• Utilizar creme barreira nos casos de incontinência urinária e fecal;\n• Em casos de diarréia aplicar protetor cutâneo diariamente;\n• Troca de fraldas frequentemente.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b4.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema  não branqueável.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema  branqueável e não branqueável.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma multicamadas para proteção nos casos de eritema branqueável e não branqueável.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }

                });
                b5.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Manter os maléolos  totalmente afastados da superfície da cama;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema não branqueável.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Manter os maléolos  totalmente afastados da superfície da cama;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema branqueável e não branqueável.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Manter os maléolos  totalmente afastados da superfície da cama;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma multicamadas para proteção nos casos de eritema branqueável e não branqueável.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b6.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Garantir que os dispositivos médicos (ex.: colar cervical) sejam adequadamente posicionados para evitar deslocamento e pressão excessiva.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Garantir que os dispositivos médicos (ex.: colar cervical) sejam adequadamente posicionados para evitar deslocamento e pressão excessiva");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Garantir que os dispositivos médicos (ex.: colar cervical) sejam adequadamente posicionados para evitar deslocamento e pressão excessiva.\n");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b7.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Inspecionar a pele diariamente;\n- Preencher e instalar escala de mudança de decúbito com intervalos de até 4/4h ;\n- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) .");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Inspecionar a pele diariamente;\n- Preencher e instalar escala de mudança de decúbito com intervalos de até 2/2h ;\n- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Instalar o colchão pneumático.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("-Inspecionar a pele diariamente;\n- Preencher e instalar escala de mudança de decúbito com intervalos de até 2/2h ;\n- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Iniciar pequenas mudanças frequentes no posicionamento para indivíduos gravemente enfermos, dependendo da estabilidade hemodinâmica;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Instalar o colchão pneumático.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }

                });
                b8.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Posicionar o paciente com a cabeceira em 30° e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema  não branqueável.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Posicionar o paciente com a cabeceira em 30º e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma de poliuretano para proteção nos casos de eritema  branqueável e não branqueável.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Posicionar o paciente com a cabeceira em 30° e lateralização entre 30° e 40° para redistribuição do peso;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma) ;\n- Aplicar espuma multicamadas para proteção nos casos de eritema  branqueável e não branqueável.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }

                });
                b9.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Em cadeirante estimular a descompressão da região isquiática a cada 15 minutos e atentar para a posição anatômica, ao alinhamento postural e a distribuição do peso.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Em cadeirante estimular a descompressão da região isquiática a cada 15 minutos e atentar para a posição anatômica, ao alinhamento postural e a distribuição do peso.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Em cadeirante estimular a descompressão da região isquiática a cada 15 minutos e atentar para a posição anatômica, ao alinhamento postural e a distribuição do peso.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b10.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Garantir que os dispositivos médicos  sejam adequadamente posicionados para evitar deslocamento e pressão excessiva;\n- Aplicar espuma de poluretano para proteção nos casos de utilização de tala gessada e órteses.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Garantir que os dispositivos médicos  sejam adequadamente posicionados para evitar deslocamento e pressão excessiva;\n- Aplicar espuma de poluretano para proteção nos casos de utilização de tala gessada e órteses.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Garantir que os dispositivos médicos  sejam adequadamente posicionados para evitar deslocamento e pressão excessiva;\n- Aplicar espuma de poluretano para proteção nos casos de utilização de tala gessada e órteses.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
                b11.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        if (Risco >= 10 & Risco < 15) {
                            AlertDialog.Builder caixa = new AlertDialog.Builder(Resultado.this);
                            caixa.setTitle("Medidas Preventivas");
                            caixa.setMessage("- Manter  os calcâneos totalmente afastados da superfície da cama (calcâneos “flutuantes”) distribuindo o peso da perna ao longo da panturrilha;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma);\n- Aplicar espuma de poliuretano para proteção nos casos de eritema não branqueável.");
                            caixa.setNeutralButton("OK", null);
                            caixa.show();
                        }
                        if (Risco >= 15 & Risco < 20) {
                            AlertDialog.Builder indicacao2 = new AlertDialog.Builder(Resultado.this);
                            indicacao2.setTitle("Medidas Preventivas");
                            indicacao2.setMessage("- Manter  os calcâneos totalmente afastados da superfície da cama (calcâneos “flutuantes”) distribuindo o peso da perna ao longo da panturrilha;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma);\n- Aplicar espuma de poliuretano para proteção nos casos de eritema branqueável e não branqueável.");
                            indicacao2.setNeutralButton("OK", null);
                            indicacao2.show();
                        }
                        if (Risco >= 20) {
                            AlertDialog.Builder indicacao3 = new AlertDialog.Builder(Resultado.this);
                            indicacao3.setTitle("Medidas Preventivas");
                            indicacao3.setMessage("- Manter  os calcâneos totalmente afastados da superfície da cama (calcâneos “flutuantes”) distribuindo o peso da perna ao longo da panturrilha;\n- Utilizar superfícies de apoio (coxins, travesseiro/almofada de espuma);\n- Aplicar espuma multicamadas para proteção nos casos de eritema branqueável e não branqueável.");
                            indicacao3.setNeutralButton("OK", null);
                            indicacao3.show();
                        }
                    }
                });
    }
}



