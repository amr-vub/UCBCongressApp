package org.ucb.ui.activity.home;

import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;
import org.ucb.ui.activity.adapter.AccessCodeAdapter;
import org.ucb.ui.activity.adapter.SessionAdapter;
import org.ucb.ui.activity.learnmore.LearnMoreActivity;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class SessionActivity extends Activity {
	SessionManager session;
	TextView detailSessionTitle;
	TextView detailSessionTime;
	TextView detailSessionPlace;
	TextView detailSessionSpeaker;
	TextView detailSessionAbstract;
	Button detailSessionLearnMore;

	SessionAdapter sessionAdapter;

	String[] interestSessions = new String[] {
			"The patient as a teather: case oriented teaching",
			"Neurobiology symposium", "Emerging concepts in status epilepticus" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_detail);

		// get instance of log in adapter
		sessionAdapter = new SessionAdapter(this);

		// Get references of views
		detailSessionTitle = (TextView) findViewById(R.id.session_detail_title);
		detailSessionTime = (TextView) findViewById(R.id.learn_more_text1);
		detailSessionPlace = (TextView) findViewById(R.id.learn_more_text2);
		detailSessionSpeaker = (TextView) findViewById(R.id.learn_more_text3);
		detailSessionAbstract = (TextView) findViewById(R.id.text_abstract);
		detailSessionLearnMore = (Button) findViewById(R.id.button_learn_more);

		detailSessionTime.setText("2014-08-01 09:00");
		detailSessionPlace.setText("Room 501");
		detailSessionSpeaker.setText("Dr. Chiu Matthews");
		detailSessionAbstract.setText("Here is the abstract");
		detailSessionTitle.setText("The patient as a teather: case oriented teaching");
		
		detailSessionLearnMore.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SessionActivity.this, LearnMoreActivity.class);
				startActivity(i);
			}
			
		});
	}


}
