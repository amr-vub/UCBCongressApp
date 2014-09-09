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
import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;
import org.ucb.ui.model.IP;
import org.ucb.ui.model.QuestionObject;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionsActivity extends Activity{
	
	SessionManager session;
	EditText question;
	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_questions);

		// Get references of views
		question = (EditText) findViewById(R.id.questions_editText1);
		submit = (Button) findViewById(R.id.questions_submit);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// get rating value
				String questionContent = question.getText().toString();
				// calling the backend service				
				new HttpRequestTaskQs().execute();
				Toast.makeText(getApplicationContext(), "Thank you! Your question will be processed.", Toast.LENGTH_SHORT);
				finish();
			}
		});

	}
	
	 /**
		 * Fake for testing Qs
		 */
		 private class HttpRequestTaskQs extends AsyncTask<Void, Void, Boolean> {

			Gson gson=new Gson();
			@Override
			protected Boolean doInBackground(Void... params) {
				QuestionObject qs = new QuestionObject();
				qs.setSessionID(1);
				qs.setAskedQuestion("Can you elaborate more on X and Y");
										
				 try {
					  // greeting the connection with the restful API
		                final String url = "http://" + IP.ip + ":8080/askQuestion"; //"http://" + IP.getIP() + ":8080/checkIn";
		                HttpClient httpClient = new DefaultHttpClient();
		                HttpContext localContext = new BasicHttpContext();
		                //HttpGet httpGet = new HttpGet(url);
		                
		                HttpPost httppost = new HttpPost(url);	           
		                httppost.setHeader("Content-type", "application/json");
		                httppost.setEntity(new StringEntity(gson.toJson(qs, QuestionObject.class)));
		                HttpResponse response = httpClient.execute(httppost, localContext);
		                
		                HttpEntity entity = response.getEntity();
		                String text = EntityUtils.toString(entity);
		                
		                // parsing the JSON response using GSON google API
		                boolean retValue = gson.fromJson(text, Boolean.class);
		                
		               // accessCode.setText(String.valueOf(retValue));
		                
		                return retValue;
		                
		            } catch (Exception e) {
		                Log.e("AccessCodeActivity", e.getMessage(), e);
		            }

	           return null;
			}
		 }
		 

}
