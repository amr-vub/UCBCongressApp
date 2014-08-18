package org.ucb.ui.activity;

import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.home.HomeActivity;

import org.ucb.ui.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends Activity {
	Button buttonSignIn, buttonAnonymous;
	LoginAdapter loginAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_sign_up);

		// create a instance of the Database
		loginAdapter = new LoginAdapter(this);
		loginAdapter = loginAdapter.open();

		// Get The Reference Of Buttons
		buttonSignIn = (Button) findViewById(R.id.button_signin);
		buttonAnonymous = (Button) findViewById(R.id.button_anonymous);

		// Set OnClick listener on anonymous button for anonymous user to enter access code
		buttonAnonymous.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create Intent for SignUpActivity and start the activity
				Intent intent = new Intent(getApplicationContext(),
						AccessCodeActivity.class);
				startActivity(intent);
			}
		});
		buttonSignIn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Create Intent for sign in activity for registered users
				Intent intent = new Intent(getApplicationContext(),
						LogInActivity.class);
				startActivity(intent);
				
			}
		});
	}
	

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Close The Database
		loginAdapter.close();
	}
}