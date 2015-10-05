package com.mishobu.soundplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {

    MediaPlayer player;
    ImageButton btnPlay1, btnPlay2, btnPlay3;
    ImageButton btnStop1, btnStop2, btnStop3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay1 = (ImageButton) findViewById(R.id.imageButton1);
        btnPlay1.setOnClickListener(this);
        btnPlay2 = (ImageButton) findViewById(R.id.imageButton2);
        btnPlay2.setOnClickListener(this);
        btnPlay3 = (ImageButton) findViewById(R.id.imageButton3);
        btnPlay3.setOnClickListener(this);
        btnStop1 = (ImageButton) findViewById(R.id.imageButton4);
        btnStop1.setOnClickListener(this);
        btnStop2 = (ImageButton) findViewById(R.id.imageButton5);
        btnStop2.setOnClickListener(this);
        btnStop3 = (ImageButton) findViewById(R.id.imageButton6);
        btnStop3.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View v) {
        if(player != null)
            player.release();    // Liberar Recursos
        int id = v.getId();

        switch (id) {
            case R.id.imageButton1: player = MediaPlayer.create(this, R.raw.doorbell);
                player.seekTo(0);
                player.start();
                break;
            case R.id.imageButton3: player = MediaPlayer.create(this, R.raw.jet);
                player.seekTo(0);
                player.start();
                break;
            case R.id.imageButton5: player = MediaPlayer.create(this, R.raw.traffic);
                player.seekTo(0);
                player.start();
                break;
            default:  try {
                player.release();
            } catch (NullPointerException e)
            { e.printStackTrace(); }

        }
    }

    @Override
    protected void onPause() {
        if(player != null)
            try {
                player.release();      // Liberar Recursos
            } catch (NullPointerException e)
            { e.printStackTrace(); }
        super.onPause();
    }



}
