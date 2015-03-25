package com.example.android_tutorial_data;

import com.example.android_tutorial_data.R;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnCheckedChangeListener{
	Button bt1;
	RadioGroup rg;
	TextView tv1;
	TextView tv2;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        init();
        
        bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
        rg.setOnCheckedChangeListener(this);
    
    }

    private void init() {
    	bt1 = (Button)findViewById(R.id.button1);
    	rg = (RadioGroup)findViewById(R.id.radioGroup1);
    	tv1 = (TextView)findViewById(R.id.textView1);
    	tv2 = (TextView)findViewById(R.id.textView2);
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
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		String str = null;
		// TODO Auto-generated method stub
		switch(checkedId) {
		case R.id.radio0:
			str = "good";
			break;
		case R.id.radio1:
			str = "medium";
			break;
		case R.id.radio2:
			str = "bad";
			break;
		default:
			break;
		}
		tv2.setText(str);
	}
}
