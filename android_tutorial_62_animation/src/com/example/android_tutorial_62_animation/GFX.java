package com.example.android_tutorial_62_animation;
import android.app.Activity;
import android.os.Bundle;


public class GFX extends Activity{
	ballView myBall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		myBall = new ballView(this);
		setContentView(myBall);
	}

}
