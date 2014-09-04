package org.ucb.ui.activity;


import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ucb.data.domain.Login;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.ui.model.AccessCode;
import org.ucb.ui.model.IP;
import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.activity.survey.RegisteredSurveyActivity;
import org.ucb.ui.R;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class RegisterActivity extends Activity implements OnItemSelectedListener{
	SessionManager session;
	String[] countries = new String[] { "Austria", "Belgium", "China",
			"Denmark", "Finland", "France", "Germany", "Greece", "Italy",
			"Luxembourg", "Netherlands", "Portugal", "Romania", "Spain",
			"Sweden", "United Kingdom", "United States" };
	EditText firstName, lastName, email, phoneNumber, password, confirmPassword;
	Spinner country;
	Button signupCreateAccount;

	LoginAdapter loginAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(this.getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		// get instance of log in adapter
		loginAdapter = new LoginAdapter(this);
		loginAdapter = loginAdapter.open();

		// Get references of views
		firstName = (EditText) findViewById(R.id.first_name);
		lastName = (EditText) findViewById(R.id.last_name);
		email = (EditText) findViewById(R.id.email);
		phoneNumber = (EditText) findViewById(R.id.phone);
		password = (EditText) findViewById(R.id.password);
		confirmPassword = (EditText) findViewById(R.id.confirm_password);
		country = (Spinner) findViewById(R.id.country);
		ArrayAdapter<String> adapterCountries = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, countries);
		adapterCountries
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		country.setAdapter(adapterCountries);
		country.setOnItemSelectedListener(this);
		signupCreateAccount = (Button) findViewById(R.id.signup_create_account);
		signupCreateAccount.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				String first = firstName.getText().toString();
				String last = lastName.getText().toString();
				String eml = email.getText().toString();
				String phone = phoneNumber.getText().toString();
				String pwd = password.getText().toString();
				String cpwd = confirmPassword.getText().toString();

				/**
				 * SERVICE here requires the logic to connect to the service
				 * part
				 */
				// check if any of the fields are empty
				if (first.equals("") || last.equals("") || password.equals("")
						|| confirmPassword.equals("")) {
					Toast.makeText(getApplicationContext(), "Field Vaccant",
							Toast.LENGTH_LONG).show();
					return;
				}
				// check if both password matches
				if (!pwd.equals(cpwd)) {
					Toast.makeText(getApplicationContext(),
							"Password does not match", Toast.LENGTH_LONG)
							.show();
					return;
				} else {
					/** Save the user information into database
					 *  SERVICE: need to connect to database
					 */
					try {
						new HttpRequestTask().execute().get();		
						Toast.makeText(getApplicationContext(),
								"Account Successfully Created ", Toast.LENGTH_LONG)
								.show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					loginAdapter.insertEntry(first, pwd);
					finish();
					session.createRegisteredUserSession(eml, pwd);
					session.setFirstTime();
					Intent intent = new Intent(RegisterActivity.this, RegisteredSurveyActivity.class);
					startActivity(intent);
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		country.setSelection(position);
		String cty = (String) country.getSelectedItem();
		Toast.makeText(getApplicationContext(), cty, 1000);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	/** 
	 * the async task for handling registration flow by the back end service
	 */
	 private class HttpRequestTask extends AsyncTask<Void, Void, RegisteredHCP> {

		 Gson gson=new Gson();
		
		protected RegisteredHCP doInBackground(Void... params) {
			RegisteredHCP hcp = new RegisteredHCP();
			hcp.setHcpID(0);
			// building the User object based on the the registration form data
			hcp.setHcpName(firstName.getText().toString() + lastName.getText().toString());
			hcp.setCountry(country.getSelectedItem().toString());
			hcp.setEmail(email.getText().toString());
			hcp.setPhone(Integer.valueOf(phoneNumber.getText().toString()));
			// creating the login info
			Login login = new Login();
			login.setPassword(password.getText().toString());
			login.setUsername("ucb");
			hcp.setRegHCP_login(login);
			
			//AccessCode accesscode = new AccessCode("1234", -1);
									
			 try {
				  // the connection with the restful API
	                final String url = "http://" + IP.ip + ":8080/register"; 
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                //HttpGet httpGet = new HttpGet(url);
	                
	                HttpPost httppost = new HttpPost(url);	           
	                httppost.setHeader("Content-type", "application/json");
	                String tm = gson.toJson(hcp, RegisteredHCP.class);
	                httppost.setEntity(new StringEntity(tm));
	                HttpResponse response = httpClient.execute(httppost, localContext);
	                
	                HttpEntity entity = response.getEntity();
	                String text = EntityUtils.toString(entity);
	                
	                // parsing the JSON response using GSON google API
	                hcp = gson.fromJson(text, RegisteredHCP.class);
	                
	                return hcp;
	                
	            } catch (Exception e) {
	                Log.e("AccessCodeActivity", e.getMessage(), e);
	            }

           return null;
		}

//		protected void onPostExecute(AccessCode results) {
//			System.out.print(results);
//			if(results != null)
//				accessCode.setText("XIn");
//			else
//				accessCode.setText("");
//			}
//	     
//	    }
	 }
}