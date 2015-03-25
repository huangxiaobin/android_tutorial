package com.example.android_tutorial_81_slidingdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;

@SuppressWarnings("deprecation")
public class slider extends Activity implements OnCheckedChangeListener{
	CheckBox cb;
	@SuppressWarnings("deprecation")
	SlidingDrawer sd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		cb = (CheckBox)findViewById(R.id.cb1);
		cb.setOnCheckedChangeListener(this);
		sd = (SlidingDrawer)findViewById(R.id.sd1);
	}
	
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if (arg0.isChecked()){
			sd.lock();
		}
		else {
			sd.unlock();
		}
	}


}
