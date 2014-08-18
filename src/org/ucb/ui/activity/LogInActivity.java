package org.ucb.ui.activity;

import org.ucb.ui.R;
import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.home.HomeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogInActivity extends Activity{
	
	TextView userName;
	TextView password;
	Button signIn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// create a instance of the Database
		userName = (TextView) findViewById(R.id.login_user_name);
		password = (TextView) findViewById(R.id.login_password);
		signIn = (Button) findViewById(R.id.button_sign_in2);

		// Set OnClick listener on anonymous button for anonymous user to enter access code
		signIn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String username = userName.getText().toString();
				String psw = password.getText().toString();
				
				/**
				 * SERVICE: need to validate the user name and password
				 */
				if(username.equals("ucb") && psw.equals("ucb")){
				// Create Intent for SignUpActivity and start the activity
				Intent intent = new Intent(getApplicationContext(),
						HomeActivity.class);
				startActivity(intent);
				}
				else{
					/**
					 * the user name or password is not valid
					 */
				}
			}
		});
	}
	

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
