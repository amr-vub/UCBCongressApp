package org.ucb.ui.activity.survey;

import org.ucb.ui.R;
import org.ucb.ui.activity.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnonySurveyActivity2 extends Activity {

	Button anonySurveyArth;
	Button anonySurveyEpil;
	Button anonySurveyPark;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey_anonymous_page2);

		// Get references of views
		anonySurveyArth = (Button) findViewById(R.id.anony_survey_arith);
		anonySurveyEpil = (Button) findViewById(R.id.anony_survey_epil);
		anonySurveyPark = (Button) findViewById(R.id.anony_survey_park);

		anonySurveyArth.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				/**
				 * SERVICE here requires the logic to connect to the service
				 * part
				 */
				Intent intent = new Intent(AnonySurveyActivity2.this,
						AnonySurveyActivity3.class);
				startActivity(intent);
			}
		});
		anonySurveyEpil.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				/**
				 * SERVICE here requires the logic to connect to the service
				 * part
				 */
				Intent intent = new Intent(AnonySurveyActivity2.this,
						AnonySurveyActivity3.class);
				startActivity(intent);
			}
		});
		anonySurveyPark.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {

				/**
				 * SERVICE here requires the logic to connect to the service
				 * part
				 */
				Intent intent = new Intent(AnonySurveyActivity2.this,
						AnonySurveyActivity3.class);
				startActivity(intent);
			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

	}
}
