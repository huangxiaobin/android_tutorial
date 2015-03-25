package com.example.android_tutorial_67_animation2;
import com.example.android_tutorial_67_animation2.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;


public class GFXSurface extends Activity implements OnTouchListener{
//public class GFXSurface extends Activity{
	myBringBackSurface ourSurfaceView;
	float x, y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourSurfaceView = new myBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		return true;
	}

///*	
	public class myBringBackSurface extends SurfaceView implements Runnable{
		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRuning = false;
		
		public myBringBackSurface(Context ctx) {
			// TODO Auto-generated constructor stub
			super(ctx);
			ourHolder = getHolder();
		}

		public void pause() {
			isRuning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}
		
		public void resume() {
			isRuning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRuning) {
				if (!ourHolder.getSurface().isValid()) {
					continue;
				}
				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawColor(Color.WHITE);

				if (x != 0 && y !=0) {
					Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
					canvas.drawBitmap(ball, x - (ball.getWidth()/2), y - (ball.getHeight()/2), null);
				}
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}
//*/	
}
