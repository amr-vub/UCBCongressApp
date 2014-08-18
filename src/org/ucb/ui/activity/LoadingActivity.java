package org.ucb.ui.activity;

import org.ucb.ui.R;
import org.ucb.ui.activity.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends Activity {

	// Splash screen timer
	private static int SPLASH_TIME_OUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);

		new Handler().postDelayed(new Runnable() {

			// Showing splash screen with a timer.

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start the anonymous user screen: enter access code
				Intent i = new Intent(LoadingActivity.this,
						StartActivity.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

}