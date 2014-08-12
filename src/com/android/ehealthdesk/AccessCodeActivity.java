package com.android.ehealthdesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccessCodeActivity extends Activity {

	EditText accessCode;
	Button accessCodeContinue;
	//Button accessCodeContactMsl;

	AccessCodeAdapter accessCodeAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.access_code);

		// get instance of log in adapter
		accessCodeAdapter = new AccessCodeAdapter(this);

		// Get references of views
		accessCode = (EditText) findViewById(R.id.access_code);
		accessCodeContinue = (Button) findViewById(R.id.access_code_continue);
		accessCodeContinue.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				String codeValue = accessCode.getText().toString();

				/** SERVICE to validate the access code */
				if (codeValue.equals("iamjim")) {
					Toast.makeText(getApplicationContext(), "Success",
							Toast.LENGTH_LONG).show();
					Intent intent = new Intent(AccessCodeActivity.this,
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acess_code, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
