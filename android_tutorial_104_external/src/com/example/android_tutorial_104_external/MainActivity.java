package com.example.android_tutorial_104_external;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener, OnClickListener {

	private TextView canRead;
	private TextView canWrite;
	private Spinner spinner;
	private EditText et;
	private Button bt;
	
	private String state;
	String [] paths = {"Music", "Pictures", "Download"};
	File path = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		canRead = (TextView)findViewById(R.id.textView1);
		canWrite = (TextView)findViewById(R.id.textView2);
		et = (EditText)findViewById(R.id.editText1);
		bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(this);
/*	
		state = Environment.getExternalStorageState();
		
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			canRead.setText("read: true");
			canWrite.setText("write: true");
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			canRead.setText("read: true");
			canWrite.setText("write: false");			
		} else {
			canRead.setText("read: false");
			canWrite.setText("write: false");
		}
*/		

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, paths);
		spinner = (Spinner)findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

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
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		int pos = spinner.getSelectedItemPosition();
		
		switch (pos) {
		case  0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		default:
			break;
		}

		Toast t = Toast.makeText(MainActivity.this, path.toString(), Toast.LENGTH_LONG);
		t.show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.button1:
			String f = et.getText().toString();
			File file = new File(path, f);
			
			path.mkdirs();
			InputStream is = getResources().openRawResource(R.drawable.abc_ab_bottom_solid_dark_holo);
			OutputStream os;
			try {
				os = new FileOutputStream(file);
				byte data[] = new byte[is.available()];
				is.read();
				os.write(data);
				is.close();
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			Toast t = Toast.makeText(MainActivity.this, file.toString()+" has been changed", Toast.LENGTH_LONG);
			t.show();
			break;
		default:
			break;
		}
	
	}
}
