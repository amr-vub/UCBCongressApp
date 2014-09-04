package org.ucb.ui.activity.session;

import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class FeedbackActivity extends Activity {
	SessionManager session;
	RatingBar ratingBar1;
	RatingBar ratingBar2;
	RadioGroup radioGroup;
	RadioButton radioButton;
	Button submit;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_feedback);

		// Get references of views
		ratingBar1 = (RatingBar) findViewById(R.id.feedback_ratingBar1);
		ratingBar2 = (RatingBar) findViewById(R.id.feedback_ratingBar2);
		radioGroup = (RadioGroup) findViewById(R.id.feedback_radioGroup1);
		submit = (Button) findViewById(R.id.feedback_button1);
		
		ratingBar1.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
			}

		});
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get rating value
				float rating1 = ratingBar1.getRating();
				// get rating value
				float rating2 = ratingBar2.getRating();
				int selectedId = radioGroup.getCheckedRadioButtonId();
				radioButton = (RadioButton) findViewById(selectedId);
				// get the position of the checked radio button
				int radioId = radioGroup.indexOfChild(radioButton);
				Toast.makeText(getApplicationContext(), "Thank you!", 500);
			}
		});
		
	}
}
