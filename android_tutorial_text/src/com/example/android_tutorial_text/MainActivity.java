package com.example.android_tutorial_text;

import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text1 = (EditText)findViewById(R.id.editText1);
        final Button btn1 = (Button)findViewById(R.id.button1);
        final ToggleButton tbtn1 = (ToggleButton)findViewById(R.id.toggleButton1);
        final TextView tv1 = (TextView)findViewById(R.id.textView1);
        tbtn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (tbtn1.isChecked()) {
					text1.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					text1.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
        
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String input = text1.getText().toString();
				if(input.contentEquals("left")) {
					tv1.setGravity(Gravity.START);
					tv1.setText("LEFT");
				} else if(input.contentEquals("center")) {
					tv1.setGravity(Gravity.CENTER);
					tv1.setText("CENTER");
				} else if(input.contentEquals("right")) {
					tv1.setGravity(Gravity.RIGHT);
					tv1.setText("RIGHT");
				} else if(input.contentEquals("blue")) {
					tv1.setTextColor(Color.BLUE);
				} else if(input.contentEquals("red")) {
					tv1.setTextColor(Color.RED);
				} else if(input.contentEquals("yellow")) {
					tv1.setTextColor(Color.YELLOW);
				}
			}
		});
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
}
