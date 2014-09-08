package org.ucb.ui.activity.session;

import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
				Toast.makeText(getApplicationContext(), "Thank you! Your question will be processed.", Toast.LENGTH_SHORT);
				finish();
			}
		});

	}

}
