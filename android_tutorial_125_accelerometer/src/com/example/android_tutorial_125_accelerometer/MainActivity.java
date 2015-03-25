package com.example.android_tutorial_125_accelerometer;

import com.example.android_tutorial_125_accelerometer.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Align;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MainActivity extends Activity implements SensorEventListener{
	float x,y,sensorX,sensorY;
	Bitmap ball;
	SensorManager sm;
	myBringBackSurface ourSurfaceView;
	
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

				float currentX = canvas.getWidth()/2;
				float currentY = canvas.getHeight()/2;
				canvas.drawBitmap(ball, currentX + sensorX*20, currentY +sensorY*20, null);
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
		}
		
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		x = y = sensorX = sensorY = 0;
		ourSurfaceView = new myBringBackSurface(this);
		ourSurfaceView.resume();
		setContentView(ourSurfaceView);
	}

	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sm.unregisterListener(this);
		super.onPause();
	}


	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sensorX = arg0.values[0];
		sensorY = arg0.values[1];
	}	
}
