package org.ucb.ui.activity;


import org.ucb.ui.activity.adapter.LoginAdapter;
import org.ucb.ui.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class RegisterActivity extends Activity implements OnItemSelectedListener{
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
				if (!password.equals(confirmPassword)) {
					Toast.makeText(getApplicationContext(),
							"Password does not match", Toast.LENGTH_LONG)
							.show();
					return;
				} else {
					/** Save the user information into database
					 *  SERVICE: need to connect to database
					 */
					loginAdapter.insertEntry(first, pwd);
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
}