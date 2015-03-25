package com.example.android_tutorial_111_sqlite;

import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	Button binsert;
	Button bview;
	Button bupdate;
	Button bdelete;
	EditText ename;
	EditText ehotness;
	EditText eid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		binsert = (Button)findViewById(R.id.button1);
		bview = (Button)findViewById(R.id.button2);
		bupdate = (Button)findViewById(R.id.button3);
		bdelete = (Button)findViewById(R.id.button4);
		ename = (EditText)findViewById(R.id.editText1);
		ehotness = (EditText)findViewById(R.id.editText2);
		eid = (EditText)findViewById(R.id.editText3);
		
		binsert.setOnClickListener(this);
		bview.setOnClickListener(this);
		bupdate.setOnClickListener(this);
		bdelete.setOnClickListener(this);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			String name = ename.getText().toString();
			String hotness = ehotness.getText().toString();
			
			HotOrNot entry = new HotOrNot(MainActivity.this);
			try {
				entry.open();			
				entry.createEntry(name, hotness);
				entry.close();

				Dialog d = new Dialog(this);
				d.setTitle("Congratulation!");
				TextView tv = new TextView(this);
				tv.setText("yes");
				d.setContentView(tv);
				d.show();		
			} catch (Exception e) {
				e.printStackTrace();
				String err = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(err);
				TextView tv = new TextView(this);
				tv.setText(err);
				d.setContentView(tv);
				d.show();
			}
			break;
		case R.id.button2:
			Intent i = new Intent("android.intent.action.SQLVIEW");
			startActivity(i);
			break;
		case R.id.button3:
			String mName = ename.getText().toString();
			String mHotness = ehotness.getText().toString();
			long mId = Long.parseLong(eid.getText().toString());

			/*
			{
			Dialog d = new Dialog(this);
			d.setTitle("update " + eid.getText().toString() + " " + mName + " " + mHotness);
			TextView tv = new TextView(this);
			tv.setText("yes");
			d.setContentView(tv);
			d.show();
			}
			*/
		
			try {
				HotOrNot entryDel = new HotOrNot(MainActivity.this);
				
				entryDel.open();			
				entryDel.update(mId, mName, mHotness);
				entryDel.close();
				Dialog d = new Dialog(this);
				d.setTitle("update " + eid.getText().toString() + " " + mName + " " + mHotness);
				TextView tv = new TextView(this);
				tv.setText("yes");
				d.setContentView(tv);
				d.show();	
			} catch (Exception e) {
				e.printStackTrace();
				String err = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(err);
				TextView tv = new TextView(this);
				tv.setText(err);
				d.setContentView(tv);
				d.show();
			}
			break;
		case R.id.button4:
			try {
				long dId = Long.parseLong(eid.getText().toString());
				
				HotOrNot dEntry = new HotOrNot(this);
				
				dEntry.open();			
				dEntry.delete(dId);
				dEntry.close();
				
				Dialog d = new Dialog(this);
				d.setTitle("delete " + eid.getText().toString());
				TextView tv = new TextView(this);
				tv.setText("yes");
				d.setContentView(tv);
				d.show();
			} catch (Exception e) {
				e.printStackTrace();
				String err = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(err);
				TextView tv = new TextView(this);
				tv.setText(err);
				d.setContentView(tv);
				d.show();
			}
			break;
		default:
			break;
		}
	}
}
