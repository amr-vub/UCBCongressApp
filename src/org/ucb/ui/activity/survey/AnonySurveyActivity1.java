package org.ucb.ui.activity.survey;

import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.AnonySurveyAdapter1;
import org.ucb.ui.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AnonySurveyActivity1 extends Activity{

	SessionManager session;
	Button anonySurveyPhd;
	Button anonySurveyDoctor;
	Button anonySurveyNurse;
	Button anonySurveyPharma;
	
	AnonySurveyAdapter1 surveyAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(this.getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey_anonymous_page1);

		// get instance of log in adapter
		surveyAdapter = new AnonySurveyAdapter1();

		// Get references of views
		anonySurveyPhd = (Button) findViewById(R.id.anony_survey_phd);
		anonySurveyDoctor = (Button) findViewById(R.id.anony_survey_doctor);
		anonySurveyNurse = (Button) findViewById(R.id.anony_survey_nurse);
		anonySurveyPharma = (Button) findViewById(R.id.anony_survey_pharma);
		
		anonySurveyPhd.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				session.putAnonymousUserProfession("phd student");
				startActivity(intent);
			}
		});
		anonySurveyDoctor.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				session.putAnonymousUserProfession("doctor");
				startActivity(intent);
			}
		});
		anonySurveyNurse.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				session.putAnonymousUserProfession("nurse");
				startActivity(intent);
			}
		});
		anonySurveyPharma.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				
				/** SERVICE here requires the logic to connect to the service part*/
				Intent intent = new Intent(AnonySurveyActivity1.this, 
						AnonySurveyActivity2.class);
				session.putAnonymousUserProfession("pharmacist");
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
