package com.example.android_tutorial_95_sharepreference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	TextView tv;
	EditText et;
	static String filename = "myShareFile";
	SharedPreferences shareData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button save = (Button)findViewById(R.id.button1);
		Button load = (Button)findViewById(R.id.button2);
		tv = (TextView)findViewById(R.id.textView1);
		et = (EditText)findViewById(R.id.editText1);
		
		save.setOnClickListener(this);
		load.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			/*
			String stringData = et.getText().toString();
			shareData = getSharedPreferences(filename, 0);
			SharedPreferences.Editor editor = shareData.edit();
			editor.putString("key1", stringData);
			editor.commit();
			*/
			String stringData = et.getText().toString();
			FileOutputStream fos;
			try {
				fos = openFileOutput(filename, Context.MODE_PRIVATE);
				fos.write(stringData.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.button2:
			/*
			shareData = getSharedPreferences(filename, 0);
			String dataCollected = shareData.getString("key1", "could not collect data");
			tv.setText(dataCollected);
			*/
//			ProgressDialog dialog = new ProgressDialog(InternalData.this);
			String dataCollected = null;
			FileInputStream fis;
			try {
				fis = openFileInput(filename);
				byte[] dataArr = new byte[fis.available()];
				while (fis.read(dataArr) != -1) {
					dataCollected = new String(dataArr);
				}
				fis.close();
				tv.setText(dataCollected);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
}
