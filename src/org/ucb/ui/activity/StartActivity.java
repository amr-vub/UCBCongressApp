package org.ucb.ui.activity;

import org.ucb.ui.activity.*;
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
	Button buttonSignIn, buttonSignUp;
	LoginAdapter loginAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_in_sign_up);

		// create a instance of the Database
		loginAdapter = new LoginAdapter(this);
		loginAdapter = loginAdapter.open();

		// Get The Reference Of Buttons
		buttonSignIn = (Button) findViewById(R.id.button_sign_in);
		buttonSignUp = (Button) findViewById(R.id.button_sign_up);

		// Set OnClick Listener on SignUp button
		buttonSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Create Intent for SignUpActivity and start the activity
				Intent intentSignUp = new Intent(getApplicationContext(),
						SignUpActivity.class);
				startActivity(intentSignUp);
			}
		});
	}

	// Method to handle click event of sign in button
	public void signIn(View view) {
		final Dialog dialog = new Dialog(StartActivity.this);
		dialog.setContentView(R.layout.login);
		dialog.setTitle("Login");

		// get the references of views
		final EditText loginUserName = (EditText) dialog
				.findViewById(R.id.login_user_name);
		final EditText loginPassword = (EditText) dialog
				.findViewById(R.id.login_password);

		Button buttonSignIn2 = (Button) dialog
				.findViewById(R.id.button_sign_in2);

		// Set on click listener
		buttonSignIn2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// get The User name and Password
				String username = loginUserName.getText().toString();
				String password = loginPassword.getText().toString();

				/** SERVICE the logic is required here to validate username and password */
				// fetch the Password form database for respective user name
				String storedPassword = loginAdapter.getSinlgeEntry(username);

				/** SERVICE check LoginAdapter */
				// check if the Stored password matches with password entered by user
				if (username.equals("ucb")&&password.equals("jim")) {
					Toast.makeText(StartActivity.this,
							"Congrats: Login Successfull", Toast.LENGTH_LONG)
							.show();
					dialog.dismiss();
					Intent intent = new Intent(StartActivity.this, HomeActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(StartActivity.this,
							"User Name or Password does not match",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// Close The Database
		loginAdapter.close();
	}
}