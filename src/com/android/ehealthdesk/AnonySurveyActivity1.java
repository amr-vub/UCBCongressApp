package com.android.ehealthdesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnonySurveyActivity1 extends Activity{

	Button anonySurveyDoctor;
	Button anonySurveyNurse;
	Button anonySurveyPharma;
	Button anonySurveyPhd;
	
	AnonySurveyAdapter1 surveyAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anonymous_survey_page1);

		// get instance of log in adapter
		surveyAdapter = new AnonySurveyAdapter1();

		// Get references of views
		anonySurveyDoctor = (Button) findViewById(R.id.anony_survey_doctor);
		anonySurveyNurse = (Button) findViewById(R.id.anony_survey_nurse);
		anonySurveyPharma = (Button) findViewById(R.id.anony_survey_pharma);
		anonySurveyPhd = (Button) findViewById(R.id.anony_survey_phd);
		
		anonySurveyDoctor.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				startActivity(intent);
			}
		});
		anonySurveyNurse.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				startActivity(intent);
			}
		});
		anonySurveyPharma.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				startActivity(intent);
			}
		});
		anonySurveyPhd.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		surveyAdapter.close();
	}
}
