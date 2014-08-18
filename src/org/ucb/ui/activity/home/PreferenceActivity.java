package org.ucb.ui.activity.home;

import org.ucb.ui.R;
import org.ucb.ui.activity.*;
import org.ucb.ui.activity.adapter.PreferenceAdapter;
import org.ucb.ui.activity.adapter.ScrollState;
import org.ucb.ui.activity.adapter.AgendaAdapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AbsListView.OnScrollListener;

public class PreferenceActivity extends Fragment {

	Context mContext;
	ViewPager mViewPager; // ViewPager will host the tabs and contents
	PreferenceAdapter mSectionsPagerAdapter;

	public static PreferenceActivity newInstance() {
		return new PreferenceActivity();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		mContext = getActivity();
		View v = inflater.inflate(R.layout.preference, container, false);
		mViewPager = (ViewPager) v.findViewById(R.id.pref_view_pager);

		mSectionsPagerAdapter = new PreferenceAdapter(getFragmentManager());
		mViewPager.setAdapter(mSectionsPagerAdapter);

		return v;
	}

}
