package org.ucb.ui.activity;

import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.home.HomeActivity;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;

import org.ucb.ui.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {

	SessionManager session;
	EditText userName, password, accessCode;
	Button buttonSignIn, buttonAnonymous;
	Dialog dialog1, dialog2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_page);
		session = new SessionManager(this.getApplicationContext());

		// Get The Reference Of Buttons
		buttonSignIn = (Button) findViewById(R.id.button_signin);
		buttonAnonymous = (Button) findViewById(R.id.button_anonymous);

		//ImageView myImageView = (ImageView) findViewById(R.id.start_imageView1);
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.relative_layout_icons);
		Animation myFadeInAnimation = AnimationUtils.loadAnimation(this,
				R.anim.fadein);
		layout.startAnimation(myFadeInAnimation);
		/**
		 * myImageView.startAnimation(myFadeInAnimation);
		myImageView = (ImageView) findViewById(R.id.start_imageView2);
		myImageView.startAnimation(myFadeInAnimation);
		myImageView = (ImageView) findViewById(R.id.start_imageView3);
		myImageView.startAnimation(myFadeInAnimation);
		myImageView = (ImageView) findViewById(R.id.start_imageView4);
		myImageView.startAnimation(myFadeInAnimation);
		myImageView = (ImageView) findViewById(R.id.start_imageView5);
		myImageView.startAnimation(myFadeInAnimation);
		myImageView = (ImageView) findViewById(R.id.start_imageView6);
		myImageView.startAnimation(myFadeInAnimation);
*/
		// Set OnClick listener on anonymous button for anonymous user to enter
		// access code
		buttonAnonymous.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				callAccessCodeDialog();
			}
		});
		buttonSignIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				callLoginDialog();
			}
		});
	}

	private void callLoginDialog() {
		dialog1 = new Dialog(this);
		dialog1.setTitle("Sign in");
		dialog1.setContentView(R.layout.login);
		dialog1.setCancelable(true);

		userName = (EditText) dialog1.findViewById(R.id.login_user_name);
		password = (EditText) dialog1.findViewById(R.id.login_password);
		dialog1.show();

		Button signIn = (Button) dialog1.findViewById(R.id.button_sign_in2);
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
					Toast.makeText(getApplicationContext(), "log in failed",
							1000);
				}
			}
		});

	}

	private void callAccessCodeDialog() {
		dialog2 = new Dialog(this);
		dialog2.setTitle("Enter access code");
		dialog2.setContentView(R.layout.access_code);
		dialog2.setCancelable(true);

		accessCode = (EditText) dialog2.findViewById(R.id.access_code);
		dialog2.show();

		Button accessCodeContinue = (Button) dialog2.findViewById(R.id.access_code_continue);
		accessCodeContinue.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				String codeValue = accessCode.getText().toString();
				session.createAnonymousSession(codeValue);

				/** SERVICE to validate the access code */
				if (codeValue.equals("1234")) {
					Intent intent = new Intent(StartActivity.this,
							AnonySurveyActivity1.class);
					startActivity(intent);
				} else {
					/** SERVICE to validate the access code */
					Toast.makeText(getApplicationContext(),
							"Your access code is wrong", Toast.LENGTH_LONG)
							.show();
				}
			}
		});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}