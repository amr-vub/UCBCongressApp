package org.ucb.ui.activity.session;

import org.ucb.ui.R;
import org.ucb.ui.activity.RegisterActivity;
import org.ucb.ui.activity.SessionManager;
import org.ucb.ui.activity.adapter.SessionAdapter;
import org.ucb.ui.activity.learnmore.LearnMoreActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SessionActivity extends Activity {
	SessionManager session;
	RelativeLayout topLevelLayout;
	TextView detailSessionTitle;
	TextView detailSessionTime;
	TextView detailSessionPlace;
	TextView detailSessionSpeaker;
	TextView detailSessionAbstract;
	RatingBar ratingBar;
	Button detailSessionLearnMore;
	Button detailSessionRate;
	Button detailSessionFeedback;
	Button detailViewDocument;
	Dialog dialogbox;
	SessionAdapter sessionAdapter;

	String[] interestSessions = new String[] {
			"The patient as a teather: case oriented teaching",
			"Neurobiology symposium", "Emerging concepts in status epilepticus" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_detail);
		topLevelLayout = (RelativeLayout) findViewById(R.id.top_layout);

		// get instance of log in adapter
		sessionAdapter = new SessionAdapter(this);

		// Get references of views
		detailSessionTitle = (TextView) findViewById(R.id.session_detail_title);
		detailSessionTime = (TextView) findViewById(R.id.learn_more_text1);
		detailSessionPlace = (TextView) findViewById(R.id.learn_more_text2);
		detailSessionSpeaker = (TextView) findViewById(R.id.learn_more_text3);
		detailSessionAbstract = (TextView) findViewById(R.id.text_abstract);
		detailSessionLearnMore = (Button) findViewById(R.id.button_learn_more);
		detailSessionRate = (Button) findViewById(R.id.detail_session_rate);
		detailSessionFeedback = (Button) findViewById(R.id.detail_session_feedback);
		detailViewDocument = (Button) findViewById(R.id.button_download_doc);

		detailSessionTime.setText("2014-08-01 09:00");
		detailSessionPlace.setText("Room 501");
		detailSessionSpeaker.setText("Dr. Chiu Matthews");
		detailSessionAbstract.setText("Here is the abstract");
		detailSessionTitle
				.setText("The patient as a teather: case oriented teaching");

		if (isFirstTime()) {
			topLevelLayout.setVisibility(View.INVISIBLE);
		}
		detailSessionLearnMore.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!session.getUserMode()) {
					Toast.makeText(
							getApplicationContext(),
							"You are almost there...\nRegister to find out more!",
							Toast.LENGTH_LONG).show();
					Intent i = new Intent(SessionActivity.this,
							RegisterActivity.class);
					startActivity(i);
				} else {
					Intent i = new Intent(SessionActivity.this,
							LearnMoreActivity.class);
					startActivity(i);
				}

			}

		});
		detailSessionRate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showRatingForm();
			}
		});
		detailSessionFeedback.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SessionActivity.this, FeedbackActivity.class);
				startActivity(intent);
			}
			
		});
		detailViewDocument.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SessionActivity.this, ViewDocumentActivity.class);
				startActivity(intent);
				
			}
		});
	}

	protected void showRatingForm() {
		dialogbox = new Dialog(SessionActivity.this);
		dialogbox.setTitle("Rate this session");
		dialogbox.setContentView(R.layout.rating);
		dialogbox.setCancelable(true);

		ratingBar = (RatingBar) dialogbox.findViewById(R.id.ratingBar1);
		dialogbox.show();

		Button submitRating = (Button) dialogbox
				.findViewById(R.id.submit_rating);
		submitRating.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				float ratingValue = ratingBar.getRating();

				Toast.makeText(getApplicationContext(),
						"Thanks for your rating!", Toast.LENGTH_LONG).show();
				dialogbox.dismiss();
			}
		});

	}

	public boolean isFirstTime() {
		boolean ranBefore = session.getFirstTime();
		if (!ranBefore) {

			session.setFirstTime();
			topLevelLayout.setVisibility(View.VISIBLE);
			topLevelLayout.setOnTouchListener(new View.OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					topLevelLayout.setVisibility(View.INVISIBLE);
					return false;
				}

			});

		}
		return ranBefore;
	}

}