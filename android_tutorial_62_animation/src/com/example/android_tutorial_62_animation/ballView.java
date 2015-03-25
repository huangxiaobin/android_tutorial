package com.example.android_tutorial_62_animation;

import com.example.android_tutorial_62_animation.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.view.View;


public class ballView extends View{
	Bitmap ball;
	float changeY;
	boolean down = true;
	
	public ballView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		canvas.drawBitmap(ball, canvas.getWidth()/2, changeY, null);
		if (changeY >= canvas.getHeight())
			down = false;
		else if (changeY <= 0)
			down = true;
		
		if (changeY < canvas.getHeight() && down == true)
			changeY += 10;
		else
			changeY -= 10;
		
		Rect myRect = new Rect();
		myRect.set(0, 400, canvas.getWidth(), 500);
		Paint myBlue = new Paint();
		myBlue.setColor(Color.BLUE);
		canvas.drawRect(myRect, myBlue);
		
		
		Paint myText = new Paint();
		myText.setColor(Color.GRAY);
		myText.setTextSize(50);
		myText.setTextAlign(Align.CENTER);
		canvas.drawText("Goal", canvas.getWidth()/2, 200, myText);
		
		invalidate();
		
	}

}
