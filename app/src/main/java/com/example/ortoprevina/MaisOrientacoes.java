package com.example.ortoprevina;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;



public class MaisOrientacoes extends AppCompatActivity {

    VideoView vVrelogiomud;
    VideoView vVmudanca;
    VideoView vVcalcaneos;
    MediaController mController;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maisorientacoes);

        VideoView vVrelogiomud = (VideoView) findViewById(R.id.vVrelogiomud);
        VideoView vVmudanca = (VideoView) findViewById(R.id.vVmudanca);
        VideoView vVcalcaneos = (VideoView) findViewById(R.id.vVcalcaneos);



        String uri = "android.resource://" + getPackageName() + "/" + R.raw.relogio;

        {
            vVrelogiomud.setVideoURI(Uri.parse(uri));
            mController = new MediaController(this);
            vVrelogiomud.setMediaController(mController);
            vVrelogiomud.requestFocus();
            vVrelogiomud.seekTo( 1 );
        }
        String mudanca = "android.resource://" + getPackageName() + "/" + R.raw.mudancadedecubito;

        {
            vVmudanca.setVideoURI(Uri.parse(mudanca));
            mController = new MediaController(this);
            vVmudanca.setMediaController(mController);
            vVmudanca.requestFocus();
            vVmudanca.seekTo( 1 );
        }

        String calcaneo = "android.resource://" + getPackageName() + "/" + R.raw.calcaneo;

        {
            vVcalcaneos.setVideoURI(Uri.parse(calcaneo));
            mController = new MediaController(this);
            vVcalcaneos.setMediaController(mController);
            vVcalcaneos.requestFocus();
            vVcalcaneos.seekTo( 1 );
        }


    }


}


