package org.ucb.ui.activity.survey;

import java.util.ArrayList;

import org.ucb.ui.activity.adapter.SurveyInterestItemAdapter;
import org.ucb.ui.activity.home.UserProfileActivity;
import org.ucb.ui.model.InterestItem;

import org.ucb.ui.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class RegisteredSurveyActivity extends Activity {

	GridView gridView;
	Button nextButton;
	SurveyInterestItemAdapter itemAdapter;
	ArrayList<InterestItem> interestItems;

	static final String[] numbers = new String[] { "Epilepsy", "Stop Smoking",
			"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
			"Diabetes", "Mental health", "Diabetes", "Whatever" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey_register);

		/**
		 * Initialize the interest items, set the name and status (by default
		 * unchecked) of the item
		 * 
		 * SERVICE: here we need to get the previous interest list and show what
		 * the user has selected before when in anonymous mode
		 */
		interestItems = new ArrayList<InterestItem>();
		for (String s : numbers) {
			interestItems.add(new InterestItem(s, true));
		}

		gridView = (GridView) findViewById(R.id.register_survey_gridView1);

		itemAdapter = new SurveyInterestItemAdapter(this, interestItems);

		gridView.setAdapter(itemAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				if (interestItems.get(position).isChecked() == true) {
					interestItems.get(position).setChecked(false);
					itemAdapter.notifyDataSetChanged();
				} else {
					interestItems.get(position).setChecked(true);
					itemAdapter.notifyDataSetChanged();
				}
			}
		});

		nextButton = (Button) this.findViewById(R.id.register_survey_next);
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/**
				 * SERVICE: here we need to save the user's interest list to
				 * database
				 */

				// Jump to user profile screen
				Intent intent = new Intent(RegisteredSurveyActivity.this,
						UserProfileActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	public static class ViewHolder {
		public TextView text;
	}

}
