package org.ucb.ui.activity.session;

import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class VotingActivity extends Activity {
	SessionManager session;
	RadioGroup radioGroup;
	RadioButton radioButton0, radioButton1, radioButton2, radioButton3;
	Button submit;
	String[] itemNames = new String[] { "Childhood absence epilepsy",
			"Juvenile myoclonic epilepsy",
			"Epilepsy with grand-mal seizures on awakening", "Others" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_voting);
		this.setRadioButtonText(itemNames);

		// Get references of views
		radioGroup = (RadioGroup) findViewById(R.id.voting_radioGroup1);
		radioButton0 = (RadioButton) findViewById(R.id.voting_radio0);
		radioButton1 = (RadioButton) findViewById(R.id.voting_radio1);
		radioButton2 = (RadioButton) findViewById(R.id.voting_radio2);
		radioButton3 = (RadioButton) findViewById(R.id.voting_radio3);
		submit = (Button) findViewById(R.id.voting_button1);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// get rating value
				int radioButtonID = radioGroup.getCheckedRadioButtonId();
				View radioButton = radioGroup.findViewById(radioButtonID);
				int selectedButton = radioGroup.indexOfChild(radioButton);
				Toast.makeText(getApplicationContext(), "Thank you for voting!", Toast.LENGTH_SHORT);
				finish();
			}
		});

	}
	
	private void setRadioButtonText(String[] itemNames) {
	    RadioGroup rGroup = (RadioGroup)findViewById(R.id.voting_radioGroup1);
	    for (int i = 0; i < rGroup.getChildCount(); i++) {
	        ((RadioButton) rGroup.getChildAt(i)).setText(itemNames[i]);
	    }
	}
}
