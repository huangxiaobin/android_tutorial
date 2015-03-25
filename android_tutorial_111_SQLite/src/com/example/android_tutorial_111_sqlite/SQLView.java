package com.example.android_tutorial_111_sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class SQLView extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv = (TextView)findViewById(R.id.tvResult);
		
		HotOrNot info = new HotOrNot(this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
		
	}
}
