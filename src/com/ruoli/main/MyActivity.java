package com.ruoli.main;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MyActivity extends Activity
{

    MediaPlayer song;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);

        song = MediaPlayer.create(MyActivity.this, R.raw.bomb);
        song.start();

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(MyActivity.this, GameStarterActivity.class);
                    startActivity(i);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        song.release();
        finish();
    }
}
