package org.ucb.ui.activity.adapter;


import java.util.*;
import org.ucb.ui.R;
import org.ucb.ui.activity.preference.*;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
 * of the sections/tabs/pages.
 */
public class PreferenceAdapter extends FragmentPagerAdapter {
	String[] pagerTitle = new String[] {"Congress", "UCB info"};

	public PreferenceAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		switch(position){
			case 0:
				return new CongressFragment();
			case 1:
				return new ProductFragment();
			default:
				return new CongressFragment();
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
	    return pagerTitle[position];
	}
}
