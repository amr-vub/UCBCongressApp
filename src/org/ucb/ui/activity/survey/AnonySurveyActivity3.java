package org.ucb.ui.activity.survey;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ucb.data.domain.HCPInitialInterests;
import org.ucb.data.domain.RegisteredHCP;
import org.ucb.data.domain.out.InitialInterests;
import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.SurveyInterestItemAdapter;
import org.ucb.ui.activity.home.HomeActivity;
import org.ucb.ui.model.IP;
import org.ucb.ui.model.InitialInterestModel;
import org.ucb.ui.model.InterestItem;
import org.ucb.ui.R;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
	ArrayList<InterestItem> interestItems = new ArrayList<InterestItem>();

	String[] interestNames;
//			new String[] { "Epilepsy", "Stop Smoking",
//			"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
//			"Arthritis", "Mental health", "Diabetes", "Cancer" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(this.getApplicationContext());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.survey_anonymous_page3);

		// get the interest list from DB based on the specialType and profType
		
		try {
			InitialInterestModel initialInterestModel = 
					new HttpRequestTask_GetInteresets().execute().get();//10000, TimeUnit.MILLISECONDS);
			// if we got a response from the server
			if(initialInterestModel != null){
				List<InitialInterests> initList = initialInterestModel.getInitIntList();
				for(InitialInterests init : initList){						
					interestItems.add(new InterestItem(init.getInitialInterests(), false));					
				}
			}
			// no response from the server
			else{
				interestNames = 
				new String[] { "Amr", "Stop Smoking",
				"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
				"Arthritis", "Mental health", "Diabetes", "Cancer" };
				/**
				 * Initialize the interest items, set the name and status (by default
				 * unchecked) of the item
				 */
				interestItems = new ArrayList<InterestItem>();
				for (String s : interestNames) {
					interestItems.add(new InterestItem(s, false));
				}
			}
			// in case of error, use the static list
		} catch (Exception e) {
			// TODO Auto-generated catch block
			interestNames = 
				new String[] { "Catch", "Stop Smoking",
				"Parkinson", "Dyslexia", "Eating Disorders", "Skin Cancer",
				"Arthritis", "Mental health", "Diabetes", "Cancer" };
			/**
			 * Initialize the interest items, set the name and status (by default
			 * unchecked) of the item
			 */
			interestItems = new ArrayList<InterestItem>();
			for (String s : interestNames) {
				interestItems.add(new InterestItem(s, false));
			}
			e.printStackTrace();
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
				//generateRegsiteredHCP();
				new HttpRequestTask().execute();
				// Jump to home screen
				Intent intent = new Intent(AnonySurveyActivity3.this,
						HomeActivity.class);
				//new HttpRequestTask().execute();
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
			h.setHcp_Initial_Interest(s);
			//h.setHcpInitialInterests_hcp(hcp);
			initialInterestList.add(h);
			//Toast.makeText(getApplicationContext(), s, 500).show();
		}
		hcp.setHcp_hcpInitialInterests(initialInterestList);
		return hcp;
		
	}
	
	/**
	 * This method generate a profType and specialization
	 */
	protected InitialInterestModel generateInitInterestDetails() {
		InitialInterestModel initialInterestModel = new InitialInterestModel();

		initialInterestModel.setProfType(session.getAnonymousUserProfession().get("profession"));
		initialInterestModel.setSubspecialType(session.getAnonymousUserSpecialization().get("specialization"));
				
		return initialInterestModel;
		
	}


	public static class ViewHolder {
		public TextView text;
	}

	/************************************ Back end part **************************************************/
	/**
	 * Async class for Saving new anonymous user validation
	 */
	 private class HttpRequestTask extends AsyncTask<Void, Void, RegisteredHCP> {

		Gson gson=new Gson();
		
		RegisteredHCP hcp = generateRegsiteredHCP(); //new RegisteredHCP();//generateRegsiteredHCP();
		
		@Override
		protected RegisteredHCP doInBackground(Void... params) {
		//	AccessCode access_Code = new AccessCode(accessCode.getText().toString(), -1);
									
			 try {
				  // greeting the connection with the restful API
	                final String url = "http://" + IP.ip + ":8080/survey/saveNewAnonynousUser";
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                //HttpGet httpGet = new HttpGet(url);
	                
	                HttpPost httppost = new HttpPost(url);	           
	                httppost.setHeader("Content-type", "application/json");
	                String tmp = gson.toJson(hcp, RegisteredHCP.class);
	                httppost.setEntity(new StringEntity(tmp));
	                HttpResponse response = httpClient.execute(httppost, localContext);
	                
	                HttpEntity entity = response.getEntity();
	                String text = EntityUtils.toString(entity);
	                
	                // parsing the JSON response using GSON google API
	                hcp = gson.fromJson(text, RegisteredHCP.class);
	                
	                return hcp;
	                
	            } catch (Exception e) {
	                Log.e("AccessCodeActivity", e.getMessage(), e);
	            }

           return null;
		}
	     
	}
	 
	 /**
	 * Async class for Saving new anonymous user validation
	 */
	 private class HttpRequestTask_GetInteresets extends AsyncTask<Void, Void, InitialInterestModel> {

		Gson gson=new Gson();
		
		InitialInterestModel initialInterestModel = generateInitInterestDetails(); //new RegisteredHCP();//generateRegsiteredHCP();
		
		@Override
		protected InitialInterestModel doInBackground(Void... params) {
		//	AccessCode access_Code = new AccessCode(accessCode.getText().toString(), -1);
									
			 try {
				  // greeting the connection with the restful API
	                final String url = "http://" + IP.ip + ":8080/survey/getInitInteresets";
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                //HttpGet httpGet = new HttpGet(url);
	                
	                HttpPost httppost = new HttpPost(url);	           
	                httppost.setHeader("Content-type", "application/json");
	                String tmp = gson.toJson(initialInterestModel, InitialInterestModel.class);
	                httppost.setEntity(new StringEntity(tmp));
	                HttpResponse response = httpClient.execute(httppost, localContext);
	                
	                HttpEntity entity = response.getEntity();
	                String text = EntityUtils.toString(entity);
	                
	                // parsing the JSON response using GSON google API
	                initialInterestModel = gson.fromJson(text, InitialInterestModel.class);
	                
	                return initialInterestModel;
	                
	            } catch (Exception e) {
	                Log.e("AccessCodeActivity", e.getMessage(), e);
	            }

           return null;
		}
	     
	}
}
