package org.ucb.ui.activity.learnmore;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LearmMore;
import org.ucb.ui.R;
import org.ucb.ui.activity.adapter.SessionAdapter;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;
import org.ucb.ui.model.IP;
import org.ucb.ui.model.LearnMoreObject;
import org.ucb.ui.model.LoginInfo;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class LearnMoreActivity extends ListActivity {
	

	SessionAdapter sessionAdapter;


	@Override
	public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
 
        // 1. pass context and data to the custom adapter
        LearnMoreAdapter adapter = new LearnMoreAdapter(this, generateData());
 
        //2. setListAdapter
        setListAdapter(adapter);
    }
 
    private ArrayList<LearmMore> generateData(){
//    	LearnMoreObject learnMoreObj;
//    	try 
//    	{
//    		learnMoreObj = new HttpRequestTask().execute().get();
//    		if(learnMoreObj != null)
//    			return (ArrayList<LMRelatedWebsites>) learnMoreObj.getLearnMoreOutput();
//    			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	return null;
    	
    	
    	ArrayList<LearmMore> items = new ArrayList<LearmMore>();
        LearmMore lmi = new LearmMore();
        lmi.setPerson("Michael Jackson");
        lmi.setTime("2004");
        lmi.setTitle("General overview of Epilepsy");
        items.add(lmi);
        lmi.setPerson("Dan Brown");
        lmi.setTime("2005");
        lmi.setTitle("A medical practice: lessons learned from patients");
        items.add(lmi);
        return items;
        
    }

    /**
	 * Async class for learn more part
	 */
	 private class HttpRequestTask extends AsyncTask<Void, Void, LearnMoreObject> {

		  
		 Gson gson=new Gson();
		 LearnMoreObject learnMoreObj = new LearnMoreObject();
		  
		@Override
		protected LearnMoreObject doInBackground(Void... params) {

									
			 try {
				  // greeting the connection with the restful API
	                final String url = "http://" + IP.ip + ":8080/getLearnMoreWebsite";
	                HttpClient httpClient = new DefaultHttpClient();
	                HttpContext localContext = new BasicHttpContext();
	                //HttpGet httpGet = new HttpGet(url);
	                
	                HttpPost httppost = new HttpPost(url);	           
	                httppost.setHeader("Content-type", "application/json");
	                
	                // preparing the model obj TODO static id for now
	                learnMoreObj.setSessionID(2);
	                
	                httppost.setEntity(new StringEntity(gson.toJson(learnMoreObj, LearnMoreObject.class)));
	                HttpResponse response = httpClient.execute(httppost, localContext);
	                
	                HttpEntity entity = response.getEntity();
	                String text = EntityUtils.toString(entity);
	                
	                // parsing the JSON response using GSON google API
	                learnMoreObj = gson.fromJson(text, LearnMoreObject.class);
	                
	                return learnMoreObj;		
	                
	            } catch (Exception e) {
	                Log.e("AccessCodeActivity", e.getMessage(), e);
	            }

           return null;
		}
	     
	 }
}
