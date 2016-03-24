package com.baabtra.faceebookapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends ActionBarActivity {
	 private final int SPLASH_DISPLAY_LENGTH = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		
		 new Handler().postDelayed(new Runnable() {
	            @Override
	            public void run() {
	                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
	                SplashActivity.this.startActivity(mainIntent);
	                SplashActivity.this.finish();
	            }
	        }, SPLASH_DISPLAY_LENGTH);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
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
