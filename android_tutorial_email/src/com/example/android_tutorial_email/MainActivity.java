package com.example.android_tutorial_email;

import com.example.android_tutorial_email.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends ActionBarActivity {
	EditText text1;
	EditText text2;
	EditText text3;
	EditText text4;
    Button btn1;
    String emailAdd,  ccAdd, subject, content;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        initializeVars();
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String message = "Happy new year 2015 ";
		        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAdd);
		        emailIntent.putExtra(android.content.Intent.EXTRA_CC, ccAdd);
		        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content + message);
		        startActivity(emailIntent);
			}
		});
*/		
    }

    private void initializeVars() { 
    	text1 = (EditText)findViewById(R.id.editText1);
    	text2 = (EditText)findViewById(R.id.editText2);
    	text3 = (EditText)findViewById(R.id.editText3);
    	text4 = (EditText)findViewById(R.id.editText4);
        btn1 = (Button)findViewById(R.id.button1);  
        
        convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
    }
    
    private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = text1.getText().toString();
		ccAdd = text2.getText().toString();
		subject = text3.getText().toString();
		content = text4.getText().toString();
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
