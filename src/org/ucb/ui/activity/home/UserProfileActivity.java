package org.ucb.ui.activity.home;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

import org.ucb.ui.R;
import org.ucb.ui.activity.*;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class UserProfileActivity extends Fragment {

	public final static String TAG = UserProfileActivity.class.getSimpleName();
	TextView name;
	TextView profession;
	TextView specialization;
	

	public static UserProfileActivity newInstance() {
		return new UserProfileActivity();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.user_profile_frag, container, false);
		name = (TextView) v.findViewById(R.id.user_profile_name);
		profession = (TextView) v.findViewById(R.id.user_profile_profession);
		specialization = (TextView) v.findViewById(R.id.user_profile_specialization);
		
		/**
		 * SERVICE: need to get the following information
		 * first name, last name, profession, specialization
		 */
		name.setText("Sheldon Cooper");
		profession.setText("General practitioner");
		specialization.setText("Parkinson");
		return v;
	}


	
}
