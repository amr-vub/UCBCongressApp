package org.ucb.ui.activity.survey;

import java.util.ArrayList;

import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.SurveyInterestItemAdapter;
import org.ucb.ui.activity.home.HomeActivity;
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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AnonySurveyActivity3 extends Activity {

	SessionManager session;
	GridView gridView;
	Button nextButton;
	SurveyInterestItemAdapter anonyAdapter;
	ArrayList<InterestItem> interestItems;

	String[] interestNames = new String[] { "Epilepsy", "Stop Smoking",
			"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
			"Arthritis", "Mental health", "Diabetes", "Cancer" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(this.getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey_anonymous_page3);

		/**
		 * Initialize the interest items, set the name and status (by default
		 * unchecked) of the item
		 */
		interestItems = new ArrayList<InterestItem>();
		for (String s : interestNames) {
			interestItems.add(new InterestItem(s, false));
		}

		gridView = (GridView) findViewById(R.id.user_profile_interests);

		anonyAdapter = new SurveyInterestItemAdapter(this, interestItems);

		gridView.setAdapter(anonyAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				if (interestItems.get(position).isChecked() == true) {
					interestItems.get(position).setChecked(false);
					anonyAdapter.notifyDataSetChanged();
				} else {
					interestItems.get(position).setChecked(true);
					anonyAdapter.notifyDataSetChanged();
				}
			}
		});

		nextButton = (Button) this.findViewById(R.id.register_survey_next);
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/**
				 * SERVICE: here we need to save the user's interest list to database
				 */
				generateRegsiteredHCP();
				// Jump to home screen
				Intent intent = new Intent(AnonySurveyActivity3.this,
						HomeActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	/**
	 * This method generate a RegisteredHCP object and should be passed to the server side
	 */
	protected RegisteredHCP generateRegsiteredHCP() {
		RegisteredHCP hcp = new RegisteredHCP();
		ArrayList<HCPInitialInterests> initialInterestList = new ArrayList<HCPInitialInterests>();
		hcp.setHcpID(Integer.valueOf(session.getAnonymousUserDetails().get("accesscode")));
		hcp.setProfession(session.getAnonymousUserProfession().get("profession"));
		hcp.setSpecialization(session.getAnonymousUserSpecialization().get("specialization"));
		
		for(String s: anonyAdapter.getCheckedItems()){
			HCPInitialInterests h = new HCPInitialInterests();
			h.setHCP_Initial_Interest(s);
			h.setHCPInitialInterests_hcp(hcp);
			initialInterestList.add(h);
			Toast.makeText(getApplicationContext(), s, 500).show();
		}
		hcp.setHcp_hcpInitialInterests(initialInterestList);
		return hcp;
		
	}

	public static class ViewHolder {
		public TextView text;
	}

}
