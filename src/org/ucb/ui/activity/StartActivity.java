package org.ucb.ui.activity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ucb.ui.model.AccessCode;
import org.ucb.ui.model.IP;
import org.ucb.ui.model.LoginInfo;
import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.home.HomeActivity;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;

import org.ucb.ui.R;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
				if(username.equals("ucb") && psw.equals("ucb")){
					session.createRegisteredUserSession(username, psw);
					Intent intent = new Intent(StartActivity.this, HomeActivity.class);
					startActivity(intent);
				}
				
/*				LoginInfo loginInfo = new LoginInfo();
				try {
					loginInfo = new HttpRequestTaskLogin().execute().get(10000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {				
					e.printStackTrace();
				}
				if (loginInfo.isUserExists()) {
					// Create Intent for SignUpActivity and start the activity
					Intent intent = new Intent(getApplicationContext(),
							HomeActivity.class);
					startActivity(intent);
					finish();
				} else {
					//the user name or password is not valid
					Toast.makeText(getApplicationContext(), "log in failed",
							1000);
				}*/
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
/*				if(codeValue.equals("1234")){
					session.createAnonymousSession(codeValue);
					Intent intent = new Intent(StartActivity.this, HomeActivity.class);
					startActivity(intent);
				}
*/
				AccessCode access = new AccessCode();
				
				try {
					access = new HttpRequestTask().execute().get(10000, TimeUnit.MILLISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} catch (TimeoutException e) {
					e.printStackTrace();
				}

				// SERVICE to validate the access code
				if (access.getCheckin() == 1) {
					Intent intent = new Intent(StartActivity.this,
							AnonySurveyActivity1.class);
					startActivity(intent);
				} else {
					// SERVICE to validate the access code
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
	/************************************ Back end part **************************************************/
	/**
	 * Async calss for check in validation
	*/
	 private class HttpRequestTask extends AsyncTask<Void, Void, AccessCode> {

		Gson gson=new Gson();
		@Override
		protected AccessCode doInBackground(Void... params) {
			AccessCode access_Code = new AccessCode(accessCode.getText().toString(), -1);
									
			 try {
				  // greeting the connection with the restful API
	                final String url = "http://" + IP.ip + ":8080/checkIn"; //"http://" + IP.getIP() + ":8080/checkIn";
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                //HttpGet httpGet = new HttpGet(url);
	                
	                HttpPost httppost = new HttpPost(url);	           
	                httppost.setHeader("Content-type", "application/json");
	                httppost.setEntity(new StringEntity(gson.toJson(access_Code, AccessCode.class)));
	                HttpResponse response = httpClient.execute(httppost, localContext);
	                
	                HttpEntity entity = response.getEntity();
	                String text = EntityUtils.toString(entity);
	                
	                // parsing the JSON response using GSON google API
	                access_Code = gson.fromJson(text, AccessCode.class);
	                
	                return access_Code;
	                
	            } catch (Exception e) {
	                Log.e("AccessCodeActivity", e.getMessage(), e);
	            }

           return null;
		}

		protected void onPostExecute(AccessCode results) {
			//System.out.print(results);
//			if(results != null)
//				accessCode.setText("XIn");
//			else
//				accessCode.setText("");
			}
	     
	    }

		/**
		 * Async calss for log in validation
		 */
		 private class HttpRequestTaskLogin extends AsyncTask<Void, Void, LoginInfo> {

			  Gson gson=new Gson();
			@Override
			protected LoginInfo doInBackground(Void... params) {
				LoginInfo loginInfo = new LoginInfo(userName.getText().toString(), password.getText().toString()
						, false);
										
				 try {
					  // greeting the connection with the restful API
		                final String url = "http://" + IP.ip + ":8080/logIn"; //"http://" + IP.getIP() + ":8080/checkIn";
		                HttpClient httpClient = new DefaultHttpClient();
		                HttpContext localContext = new BasicHttpContext();
		                //HttpGet httpGet = new HttpGet(url);
		                
		                HttpPost httppost = new HttpPost(url);	           
		                httppost.setHeader("Content-type", "application/json");
		                httppost.setEntity(new StringEntity(gson.toJson(loginInfo, LoginInfo.class)));
		                HttpResponse response = httpClient.execute(httppost, localContext);
		                
		                HttpEntity entity = response.getEntity();
		                String text = EntityUtils.toString(entity);
		                
		                // parsing the JSON response using GSON google API
		                loginInfo = gson.fromJson(text, LoginInfo.class);
		                
		                return loginInfo;		                
		            } catch (Exception e) {
		                Log.e("AccessCodeActivity", e.getMessage(), e);
		            }

	           return null;
			}
		     
		    }
		 
}