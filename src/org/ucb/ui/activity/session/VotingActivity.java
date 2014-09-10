package org.ucb.ui.activity.session;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ucb.data.domain.Session;
import org.ucb.data.domain.Vote_value;
import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;
import org.ucb.ui.model.IP;
import org.ucb.ui.model.VotingSession;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
				
				// sendig the vote to the back-end
				new HttpRequestTaskVote().execute();
				
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
	
	 /**
		 * Fake for testing vote
		 */
		 private class HttpRequestTaskVote extends AsyncTask<Void, Void, Boolean> {

			Gson gson=new Gson();
			@Override
			protected Boolean doInBackground(Void... params) {
				VotingSession votingSession = new VotingSession();
				Session session = new  Session();
				session.setSessionID(2);
				votingSession.setVotingSession(session);
				Vote_value value = new Vote_value();
				// get rating value
				int radioButtonID = radioGroup.getCheckedRadioButtonId();
				View radioButton = radioGroup.findViewById(radioButtonID);
				int selectedButton = radioGroup.indexOfChild(radioButton);				
				value.setVoteValue(selectedButton);
				votingSession.setVoteValue(value);
				votingSession.setVoteID(1);
										
				 try {
					  // greeting the connection with the restful API
		                final String url = "http://" + IP.ip + ":8080/vote"; //"http://" + IP.getIP() + ":8080/checkIn";
		                HttpClient httpClient = new DefaultHttpClient();
		                HttpContext localContext = new BasicHttpContext();
		                //HttpGet httpGet = new HttpGet(url);
		                
		                HttpPost httppost = new HttpPost(url);	           
		                httppost.setHeader("Content-type", "application/json");
		                httppost.setEntity(new StringEntity(gson.toJson(votingSession, VotingSession.class)));
		                HttpResponse response = httpClient.execute(httppost, localContext);
		                
		                HttpEntity entity = response.getEntity();
		                String text = EntityUtils.toString(entity);
		                
		                // parsing the JSON response using GSON google API
		                boolean retValue = gson.fromJson(text, Boolean.class);
		                
		                return retValue;
		                
		            } catch (Exception e) {
		                Log.e("AccessCodeActivity", e.getMessage(), e);
		            }

	           return null;
			}
		 }
}
