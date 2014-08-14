package org.ucb.ui.activity;

import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.LoginAdapter;

import org.ucb.ui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {
	EditText signupUserName, signupPassword, signupConfirmPassword;
	Button signupCreateAccount;

	LoginAdapter loginAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);

		// get instance of log in adapter
		loginAdapter = new LoginAdapter(this);
		loginAdapter = loginAdapter.open();

		// Get references of views
		signupUserName = (EditText) findViewById(R.id.signup_user_name);
		signupPassword = (EditText) findViewById(R.id.signup_password);
		signupConfirmPassword = (EditText) findViewById(R.id.signup_confirm_password);

		signupCreateAccount = (Button) findViewById(R.id.signup_create_account);
		signupCreateAccount.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				String userName = signupUserName.getText().toString();
				String password = signupPassword.getText().toString();
				String confirmPassword = signupConfirmPassword.getText()
						.toString();

				/** SERVICE here requires the logic to connect to the service part*/
				// check if any of the fields are empty
				if (userName.equals("") || password.equals("")
						|| confirmPassword.equals("")) {
					Toast.makeText(getApplicationContext(), "Field Vaccant",
							Toast.LENGTH_LONG).show();
					return;
				}
				// check if both password matches
				if (!password.equals(confirmPassword)) {
					Toast.makeText(getApplicationContext(),
							"Password does not match", Toast.LENGTH_LONG)
							.show();
					return;
				} else {
					// Save the Data in Database
					loginAdapter.insertEntry(userName, password);
					Toast.makeText(getApplicationContext(),
							"Account Successfully Created ", Toast.LENGTH_LONG)
							.show();
					finish();
				}
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		loginAdapter.close();
	}
}