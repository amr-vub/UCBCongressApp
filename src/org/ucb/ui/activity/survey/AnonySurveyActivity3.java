package org.ucb.ui.activity.survey;

import java.util.ArrayList;

import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.AnonySurveyAdapter3;
import org.ucb.ui.activity.home.HomeActivity;
import org.ucb.ui.activity.object.InterestItem;

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

public class AnonySurveyActivity3 extends Activity {

	GridView gridView;
	Button nextButton;
	AnonySurveyAdapter3 myAdapter;
	ArrayList<InterestItem> interestOptions;

	static final String[] numbers = new String[] { "Epilepsy", "Stop Smoking",
			"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
			"Diabetes", "Mental health", "Jim's boys", "Whatever" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anonymous_survey_page3);

		interestOptions = new ArrayList<InterestItem>();
		for (String s : numbers) {
			interestOptions.add(new InterestItem(s, false));
		}

		gridView = (GridView) findViewById(R.id.gridView1);

		myAdapter = new AnonySurveyAdapter3(this, interestOptions);

		gridView.setAdapter(myAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				if(interestOptions.get(position).isState()== true){
					interestOptions.get(position).setState(false);
					myAdapter.notifyDataSetChanged();
				}
				else{
					interestOptions.get(position).setState(true);
					myAdapter.notifyDataSetChanged();
				}
			}
		});

		nextButton = (Button) this
				.findViewById(R.id.anony_survey_interest_next);
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(AnonySurveyActivity3.this,
						HomeActivity.class);
				startActivity(intent);
			}
		});
	}

	public static class ViewHolder {
		public TextView text;
	}

}
