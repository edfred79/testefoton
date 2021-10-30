package com.example.ortoprevina;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgIMC;
    RadioButton rbAM;
    RadioButton rbM;
    RadioButton rbAcM;
    RadioButton rbObeso;
    RadioGroup rgIdade;
    RadioButton rb1449;
    RadioButton rb5064;
    RadioButton rb6574;
    RadioButton rb7580;
    RadioButton rb80a;
    RadioGroup rgSexo;
    RadioButton masc;
    RadioButton fem;
    CheckBox cbSaudavel;
    CheckBox cbQueb;
    CheckBox cbUmida;
    CheckBox cbDescorada;
    CheckBox cbSeca;
    CheckBox cbMfina;
    CheckBox cbEdema;
    RadioGroup rgCont;
    RadioButton rbSVouC;
    RadioButton rbOcaInc;
    RadioButton rbSVDouI;
    RadioButton rbDpI;
    CheckBox cbTotal;
    CheckBox cbRestrito;
    CheckBox cbAgitado;
    CheckBox cbInerte;
    CheckBox cbCadeirante;
    CheckBox cbCaquexia;
    CheckBox cbInsufcard;
    CheckBox cbDoencavasc;
    CheckBox cbAnemia;
    CheckBox cbFumante;
    CheckBox cbDiabetes;
    CheckBox cbParaplegia;
    CheckBox cbMedulal;
    CheckBox cbAcima2h;
    RadioGroup rgApetite;
    RadioButton rbNormal;
    RadioButton rbPouco;
    RadioButton rbSNGE;
    RadioButton rbSomenteL;
    RadioButton rbAnorexico;
    CheckBox cbEsteroides;
    CheckBox cbCitotoxicos;
    CheckBox cbAltadosagem;
    CheckBox cbAntiinflamatorio;
    TextView tvResultado;
    TextView tvResultado2;
    Button aboutapp;
    Button verificar;
    Button calcular;
    Button limpar;
    int queb = 0;
    int umida = 0;
    int desco = 0;
    int seca = 0;
    int mfina = 0;
    int edema = 0;
    int restrito = 0;
    int agita = 0;
    int inerte = 0;
    int cadeira = 0;
    int caquexia = 0;
    int insuf = 0;
    int vasc = 0;
    int anemia = 0;
    int fum = 0;
    int diabetes = 0;
    int medulal = 0;
    int parapleg = 0;
    int acima2 = 0;
    int esteroides = 0;
    int citotox = 0;
    int altadose = 0;
    int antiinf = 0;
    int IMC = 0;
    int idade = 0;
    int sexo = 0;
    int continencia = 0;
    int apetite = 0;
    int riscopele = 0;
    int mobilidade = 0;
    int subnutricao = 0;
    int doencaneuro = 0;
    int cirurgiagp = 0;
    int medicacao = 0;
    int resultado = 0;
    int resultadofinal;
    int enviarresultado;
    int result = 0;
    String idSelecionado;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgIMC = (RadioGroup) findViewById(R.id.rgIMC);
        rgIdade = (RadioGroup) findViewById(R.id.rgIdade);
        rgSexo = (RadioGroup) findViewById(R.id.rgSexo);
        rgCont = (RadioGroup) findViewById(R.id.rgCont);
        rgApetite = (RadioGroup) findViewById(R.id.rgApetite);
        rbAM = (RadioButton) findViewById(R.id.rbAM);
        rbM = (RadioButton) findViewById(R.id.rbM);
        rbAcM = (RadioButton) findViewById(R.id.rbAcM);
        rbObeso = (RadioButton) findViewById(R.id.rbObeso);
        rb1449 = (RadioButton) findViewById(R.id.rb1449);
        rb5064 = (RadioButton) findViewById(R.id.rb5064);
        rb6574 = (RadioButton) findViewById(R.id.rb6574);
        rb7580 = (RadioButton) findViewById(R.id.rb7580);
        rb80a = (RadioButton) findViewById(R.id.rb80a);
        masc = (RadioButton) findViewById(R.id.masc);
        fem = (RadioButton) findViewById(R.id.fem);
        rbSVouC = (RadioButton) findViewById(R.id.rbSVDouC);
        rbOcaInc = (RadioButton) findViewById(R.id.rbOcaInc);
        rbSVDouI = (RadioButton) findViewById(R.id.rbSVDouI);
        rbDpI = (RadioButton) findViewById(R.id.rbDpI);
        rbNormal = (RadioButton) findViewById(R.id.rbNormal);
        rbPouco = (RadioButton) findViewById(R.id.rbPouco);
        rbSNGE = (RadioButton) findViewById(R.id.rbSNGE);
        rbSomenteL = (RadioButton) findViewById(R.id.rbSomenteL);
        rbAnorexico = (RadioButton) findViewById(R.id.rbAnorexico);
        aboutapp = (Button) findViewById(R.id.aboutapp);
        verificar = (Button) findViewById(R.id.verificar);
        calcular = (Button) findViewById(R.id.calcular);
        cbSaudavel = (CheckBox) findViewById(R.id.cbSaudavel);
        cbQueb = (CheckBox) findViewById(R.id.cbQueb);
        cbUmida = (CheckBox) findViewById(R.id.cbUmida);
        cbSeca = (CheckBox) findViewById(R.id.cbSeca);
        cbMfina = (CheckBox) findViewById(R.id.cbMfina);
        cbEdema = (CheckBox) findViewById(R.id.cbEdema);
        cbDescorada = (CheckBox) findViewById(R.id.cbDescorada);
        cbTotal = (CheckBox) findViewById(R.id.cbTotal);
        cbRestrito = (CheckBox) findViewById(R.id.cbRestrito);
        cbAgitado = (CheckBox) findViewById(R.id.cbAgitado);
        cbInerte = (CheckBox) findViewById(R.id.cbInerte);
        cbCadeirante = (CheckBox) findViewById(R.id.cbCadeirante);
        cbCaquexia = (CheckBox) findViewById(R.id.cbCaquexia);
        cbInsufcard = (CheckBox) findViewById(R.id.cbInsufcard);
        cbDoencavasc = (CheckBox) findViewById(R.id.cbDoencavasc);
        cbAnemia = (CheckBox) findViewById(R.id.cbAnemia);
        cbFumante = (CheckBox) findViewById(R.id.cbFumante);
        cbDiabetes = (CheckBox) findViewById(R.id.cbDiabetes);
        cbParaplegia = (CheckBox) findViewById(R.id.cbParaplegia);
        cbMedulal = (CheckBox) findViewById(R.id.cbMedulal);
        cbAcima2h = (CheckBox) findViewById(R.id.cbAcima2h);
        cbEsteroides = (CheckBox) findViewById(R.id.cbEsteroides);
        cbCitotoxicos = (CheckBox) findViewById(R.id.cbCitotoxicos);
        cbAltadosagem = (CheckBox) findViewById(R.id.cbAltadosagem);
        cbAntiinflamatorio = (CheckBox) findViewById(R.id.cbAntiinflamatorio);
        final TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        final TextView tvResultado2 = (TextView) findViewById(R.id.tvResultado2);
        final int[] result = {0};


        aboutapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SobreoApp.class);
                startActivity(it);
            }
        });

        verificar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enviarresultado = Integer.parseInt(tvResultado.getText().toString());
                if (enviarresultado < 10) {
                    Intent abaixo = new Intent(MainActivity.this, Abaixode10.class);
                    startActivity(abaixo);
                } else {
                    Intent intent = new Intent(MainActivity.this, Resultado.class);
                    Bundle params = new Bundle();
                    params.putInt("resultado", enviarresultado);
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validador();
                if (cbQueb.isChecked()) {
                    queb = 3;
                } else {
                    queb = 0;
                }

                if (cbUmida.isChecked()) {
                    umida = 1;
                } else {
                    umida = 0;
                }
                if (cbDescorada.isChecked()) {
                    desco = 2;
                } else {
                    desco = 0;
                }
                if (cbSeca.isChecked()) {
                    seca = 1;
                } else {
                    seca = 0;
                }
                if (cbMfina.isChecked()) {
                    mfina = 1;
                } else {
                    mfina = 0;
                }
                if (cbEdema.isChecked()) {
                    edema = 1;
                } else {
                    edema = 0;
                }
                if (cbRestrito.isChecked()) {
                    restrito = 3;
                } else {
                    restrito = 0;
                }
                if (cbAgitado.isChecked()) {
                    agita = 1;
                } else {
                    agita = 0;
                }
                if (cbInerte.isChecked()) {
                    inerte = 4;
                } else {
                    inerte = 0;
                }
                if (cbCadeirante.isChecked()) {
                    cadeira = 5;
                } else {
                    cadeira = 0;
                }
                if (cbCaquexia.isChecked()) {
                    caquexia = 8;
                } else {
                    caquexia = 0;
                }
                if (cbInsufcard.isChecked()) {
                    insuf = 5;
                } else {
                    insuf = 0;
                }
                if (cbDoencavasc.isChecked()) {
                    vasc = 5;
                } else {
                    vasc = 0;
                }
                if (cbAnemia.isChecked()) {
                    anemia = 2;
                } else {
                    anemia = 0;
                }
                if (cbFumante.isChecked()) {
                    fum = 1;
                } else {
                    fum = 0;
                }
                if (cbDiabetes.isChecked()) {
                    diabetes = 4;
                } else {
                    diabetes = 0;
                }
                if (cbParaplegia.isChecked()) {
                    parapleg = 5;
                } else {
                    parapleg = 0;
                }
                if (cbMedulal.isChecked()) {
                    medulal = 5;
                } else {
                    medulal = 0;
                }
                if (cbAcima2h.isChecked()) {
                    acima2 = 5;
                } else {
                    acima2 = 0;
                }
                if (cbEsteroides.isChecked()) {
                    esteroides = 4;
                } else {
                    esteroides = 0;
                }
                if (cbCitotoxicos.isChecked()) {
                    citotox = 4;
                } else {
                    citotox = 0;
                }
                if (cbAltadosagem.isChecked()) {
                    altadose = 4;
                } else {
                    altadose = 0;
                }
                if (cbAntiinflamatorio.isChecked()) {
                    antiinf = 4;
                } else {
                    antiinf = 0;
                }
                int resultado = (queb + umida + desco + seca + mfina + edema + restrito + agita + inerte + cadeira + caquexia + insuf + vasc + anemia + fum + diabetes + medulal + parapleg + acima2 + esteroides + citotox + altadose + antiinf);

                int resultadofinal = (resultado + IMC + idade + sexo + continencia + apetite);

                String resultadoaescrever;
                resultadoaescrever = String.valueOf(resultadofinal);
                tvResultado.setText(resultadoaescrever);


                int result = Integer.parseInt(String.valueOf(resultadoaescrever));


                if (result < 10) {
                    tvResultado2.setText("Paciente sem Risco");
                    tvResultado2.setBackgroundColor(Color.parseColor("#6CBC12"));
                }
                if (result >= 10 & result < 15) {
                    tvResultado2.setText("Paciente em Risco");
                    tvResultado2.setBackgroundColor(Color.parseColor("#EACF1F"));
                }
                if (result >= 15 & result < 20) {
                    tvResultado2.setText("Paciente em Alto Risco");
                    tvResultado2.setBackgroundColor(Color.parseColor("#DD6220"));
                } else if (result >= 20) {
                    tvResultado2.setText("Paciente em Altíssimo Risco");
                    tvResultado2.setBackgroundColor(Color.parseColor("#DD2020"));
                }

            }

        });


        rgIMC.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbAM) {
                    IMC = 3;
                } else if (checkedId == R.id.rbM) {
                    IMC = 0;
                } else if (checkedId == R.id.rbAcM) {
                    IMC = 1;
                } else {
                    IMC = 2;
                }
            }
        });

        rgIdade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1449) {
                    idade = 1;
                } else if (checkedId == R.id.rb5064) {
                    idade = 2;
                } else if (checkedId == R.id.rb6574) {
                    idade = 3;
                } else if (checkedId == R.id.rb7580) {
                    idade = 4;
                } else {
                    idade = 5;
                }
            }
        });
        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.masc) {
                    sexo = 1;
                } else {
                    sexo = 2;
                }
            }
        });
        rgCont.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbSVDouC) {
                    continencia = 0;
                } else if (checkedId == R.id.rbOcaInc) {
                    continencia = 1;
                } else if (checkedId == R.id.rbSVDouI) {
                    continencia = 2;
                } else {
                    continencia = 3;
                }
            }
        });
        rgApetite.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbNormal) {
                    apetite = 0;
                } else if (checkedId == R.id.rbPouco) {
                    apetite = 1;
                } else if (checkedId == R.id.rbAnorexico) {
                    apetite = 3;
                } else if (checkedId == R.id.rbSNGE) {
                    apetite = 2;
                } else {
                    apetite = 2;
                }
            }
        });

    }

    public void validador() {
        int sexo = rgSexo.getCheckedRadioButtonId();
        int IMC = rgIMC.getCheckedRadioButtonId();
        int idade = rgIdade.getCheckedRadioButtonId();
        int conti = rgCont.getCheckedRadioButtonId();
        int apetite = rgApetite.getCheckedRadioButtonId();
        if (sexo == -1) {
            Toast.makeText(MainActivity.this, "Selecione o sexo", Toast.LENGTH_LONG).show();
            return;
        }
        if (IMC == -1) {
            Toast.makeText(MainActivity.this, "Selecione o IMC", Toast.LENGTH_LONG).show();
            return;
        }
        if (idade == -1) {
            Toast.makeText(MainActivity.this, "Selecione a idade", Toast.LENGTH_LONG).show();
            return;
        }
        if (conti == -1) {
            Toast.makeText(MainActivity.this, "Selecione a Continência", Toast.LENGTH_LONG).show();
            return;
        }
        if (apetite == -1) {
            Toast.makeText(MainActivity.this, "Selecione o nível do apetite", Toast.LENGTH_LONG).show();
            return;
        }
        if (!cbCadeirante.isChecked() && !cbRestrito.isChecked() && !cbAgitado.isChecked() && !cbTotal.isChecked() && !cbInerte.isChecked()) {
            Toast.makeText(MainActivity.this, "Marque uma das Opções de Mobilidade", Toast.LENGTH_LONG).show();
            return;
        }
        if (!cbSaudavel.isChecked() && !cbEdema.isChecked() && !cbQueb.isChecked() && !cbMfina.isChecked() && !cbUmida.isChecked() && !cbSeca.isChecked() && !cbDescorada.isChecked()) {
            Toast.makeText(MainActivity.this, "Marque uma das Opções de Risco de Pele", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(MainActivity.this, "Pode continuar para ORIENTAÇÕES PREVENTIVAS", Toast.LENGTH_LONG).show();


    }

}








