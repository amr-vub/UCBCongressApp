package org.ucb.ui.activity.home;

import org.ucb.ui.R;
import org.ucb.ui.activity.AccessCodeActivity;
import org.ucb.ui.activity.adapter.AccessCodeAdapter;
import org.ucb.ui.activity.adapter.SessionAdapter;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class SessionActivity extends Activity {
	TextView detailSessionTitle;
	TextView detailSessionTime;
	TextView detailSessionPlace;
	TextView detailSessionSpeaker;
	TextView detailSessionAbstract;
	Button detailSessionInterest;

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
		detailSessionTitle = (TextView) findViewById(R.id.detail_session_title);
		detailSessionTime = (TextView) findViewById(R.id.detail_session_time);
		detailSessionPlace = (TextView) findViewById(R.id.detail_session_place);
		detailSessionSpeaker = (TextView) findViewById(R.id.detail_session_speaker);
		detailSessionAbstract = (TextView) findViewById(R.id.detail_session_abstract);
		detailSessionInterest = (Button) findViewById(R.id.detail_session_interest);

		detailSessionTitle.setText("Introduction");
		detailSessionTime.setText("2014-08-01 09:00");
		detailSessionPlace.setText("Room 501");
		detailSessionSpeaker.setText("Dr. Chiu Matthews");
		detailSessionAbstract.setText("Here is the abstract");
		detailSessionInterest.setText("The patient as a teather: case oriented teaching");
		
		detailSessionInterest.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SessionActivity.this, SessionActivity.class);
				startActivity(i);
			}
			
		});
	}


}
