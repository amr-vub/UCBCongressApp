package org.ucb.ui.activity.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.ucb.ui.*;
import org.ucb.ui.adapter.ScrollState;
import org.ucb.ui.adapter.ViewPagerAdapter;

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

public class AgendaActivity extends Fragment {

	Context mContext;
	ViewPager mViewPager; // ViewPager will host the tabs and contents
	ViewPagerAdapter mSectionsPagerAdapter;

	public static AgendaActivity newInstance() {
		return new AgendaActivity();
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
		View v = inflater.inflate(R.layout.agenda, container, false);
		mViewPager = (ViewPager) v.findViewById(R.id.agenda_view_pager);

		mSectionsPagerAdapter = new ViewPagerAdapter(mContext);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		return v;
	}

}
