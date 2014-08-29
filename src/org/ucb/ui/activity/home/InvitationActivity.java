package org.ucb.ui.activity.home;

import org.ucb.ui.R;
import org.ucb.ui.activity.SessionManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class InvitationActivity extends Activity {
	SessionManager session;
	RelativeLayout invitationLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		session = new SessionManager(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.invite_others);
		
	}
}
