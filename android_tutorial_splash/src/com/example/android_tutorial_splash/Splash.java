package com.example.android_tutorial_splash;
import com.example.android_tutorial_splash.R;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.android_tutorial_splash.R;

public class Splash extends Activity{
	MediaPlayer mySong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mySong = MediaPlayer.create(Splash.this, R.raw.song);
		mySong.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(50000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent start = new Intent("com.example.android_tutorial_splash.MAINACTIVITY");
					startActivity(start);
				}
			}
		};

		timer.run();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySong.stop();
		finish();
	}

}
