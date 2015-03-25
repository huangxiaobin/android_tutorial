package com.example.android_tutorial_84_tabhost;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	TabHost th;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button addView = (Button)findViewById(R.id.button3);
		addView.setOnClickListener(this);
		
		th = (TabHost)findViewById(R.id.tabhost);
		th.setup();

		TabSpec specs;
		specs = th.newTabSpec("tab1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("tab1");
		th.addTab(specs);
		
		specs = th.newTabSpec("tab2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("tab2");
		th.addTab(specs);

		specs = th.newTabSpec("tab3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("tab3");
		th.addTab(specs);

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
		switch(arg0.getId()) {
		case R.id.button3:
			TabSpec spec;
			spec = th.newTabSpec("new tab");
			spec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					TextView tv = new TextView(MainActivity.this);
					tv.setText("hello");
					return (tv);
				}
			});
			//specs.setContent(R.id.tab2);
			spec.setIndicator("new tab");
			th.addTab(spec);
			break;
		
		default:
			break;
		}
	}
}
