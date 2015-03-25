package com.example.android_tutorial_89_browser;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	EditText url;
	WebView myBrowser;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myBrowser = (WebView) findViewById(R.id.webView1);
		myBrowser.getSettings().setJavaScriptEnabled(true);
		myBrowser.getSettings().setLoadWithOverviewMode(true);
		myBrowser.getSettings().setSupportZoom(true);
		myBrowser.getSettings().setBuiltInZoomControls(true);
		myBrowser.getSettings().setDisplayZoomControls(false);
		myBrowser.getSettings().setUseWideViewPort(true);
		
		myBrowser.setWebViewClient(new myWebViewClient());
		myBrowser.loadUrl("http://www.google.com");
		url = (EditText)findViewById(R.id.editText1);
		Button go = (Button) findViewById(R.id.BGo);
		Button back = (Button) findViewById(R.id.BBack);
		back.setText("<");
		Button foward = (Button) findViewById(R.id.BFoward);
		foward.setText(">");
		Button refresh = (Button) findViewById(R.id.BRefresh);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		foward.setOnClickListener(this);
		refresh.setOnClickListener(this);
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
		case R.id.BGo:
			String newUrl = url.getText().toString();
			myBrowser.loadUrl(newUrl);
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.BBack:
			if(myBrowser.canGoBack())
				myBrowser.goBack();
			break;
		case R.id.BFoward:
			if (myBrowser.canGoForward())
				myBrowser.goForward();
			break;
		case R.id.BRefresh:
			myBrowser.reload();
			break;
		default:
			break;
		}
	}
	
	public class myWebViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView v, String url) {
			v.loadUrl(url);
			return true;
		}
		
	}
}
