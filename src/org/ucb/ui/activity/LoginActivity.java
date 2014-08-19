package org.ucb.ui.activity;

import org.ucb.ui.R;
import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.home.HomeActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	SessionManager session;
	SharedPreferences sharedPreferences;
	TextView userName;
	TextView password;
	Button signIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		session = new SessionManager(getApplicationContext());

		userName = (TextView) findViewById(R.id.login_user_name);
		password = (TextView) findViewById(R.id.login_password);
		signIn = (Button) findViewById(R.id.button_sign_in2);

		// Set OnClick listener on anonymous button for anonymous user to enter
		// access code
		signIn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String username = userName.getText().toString();
				String psw = password.getText().toString();

				/**
				 * SERVICE: need to validate the user name and password
				 */
				session.createRegisteredUserSession("ucb", "ucb");
				if (username.equals("ucb") && psw.equals("ucb")) {
					// Create Intent for SignUpActivity and start the activity
					Intent intent = new Intent(getApplicationContext(),
							HomeActivity.class);
					startActivity(intent);
					finish();
				} else {
					/**
					 * the user name or password is not valid
					 */
					Toast.makeText(getApplicationContext(), "log in failed", 1000);
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
