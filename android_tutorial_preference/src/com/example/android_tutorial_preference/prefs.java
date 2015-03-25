package com.example.android_tutorial_preference;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class prefs extends PreferenceActivity{

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.xml.prefs);
		addPreferencesFromResource(R.xml.prefs);
	}

}
