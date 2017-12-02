package com.huy.admin.medialocalsound;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.huy.admin.medialocalsound.R.id;
import static com.huy.admin.medialocalsound.R.layout;
import static com.huy.admin.medialocalsound.R.raw;

public class MainActivity extends AppCompatActivity {

    Button btnMP3, btnMP4;
    VideoView videoViewMP4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        btnMP3 = (Button) findViewById(R.id.buttonPlaymp3);
        btnMP4 = (Button) findViewById(R.id.buttonPlayMP4);
        videoViewMP4 = (VideoView) findViewById(R.id.videoView);

        btnMP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, raw.english_listenning);
                mediaPlayer.start();
            }
        });

        btnMP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoViewMP4.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/" + raw.lv1english));
                videoViewMP4.start();
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(videoViewMP4);
                videoViewMP4.setMediaController(mediaController);
            }
        });

    }
}
