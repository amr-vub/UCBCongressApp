package org.ucb.ui.activity;

import org.ucb.ui.R;
import org.ucb.ui.activity.adapter.AccessCodeAdapter;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;


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
}
