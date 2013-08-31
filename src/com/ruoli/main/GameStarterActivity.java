package com.ruoli.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.ads.*;

public class GameStarterActivity extends Activity {

	Button singleGameButton, pvpButton;
    AdView adView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_game_starter);
		
		singleGameButton = (Button)findViewById(R.id.singleGameButton);
		singleGameButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(GameStarterActivity.this, GameActivity.class);
                startActivity(i);
			}
		});

        //add ad.
        adView = new AdView(this, AdSize.BANNER, "a1521917b9b8235");

        LinearLayout layout = (LinearLayout)findViewById(R.id.gameStarterActivityLayout);
        layout.addView(adView);

        adView.loadAd(new AdRequest());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game_starter, menu);
		return true;
	}

    @Override
    protected void onDestroy() {
        if(adView != null){
            adView.destroy();
        }
        super.onDestroy();
    }
}
