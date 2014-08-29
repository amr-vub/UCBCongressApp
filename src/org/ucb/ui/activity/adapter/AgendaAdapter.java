package org.ucb.ui.activity.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ucb.ui.R;
import org.ucb.ui.activity.session.SessionActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AbsListView.OnScrollListener;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one
 * of the sections/tabs/pages.
 */
public class AgendaAdapter extends PagerAdapter {

	private String[] titles = new String[] { "Day 1", "Day 2", "Day 3" };
	private final Context context;
	private int[] scrollPosition = new int[titles.length];

	public AgendaAdapter(Context context) {
		this.context = context;
		for (int i = 0; i < titles.length; i++) {
			scrollPosition[i] = 0;
		}
	}

	@Override
	public String getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public int getCount() {
		return titles.length;
	}

	/** SERVICE retrieve all the sessions*/
	@Override
	public Object instantiateItem(View pager, final int position) {
		
		ListView v = new ListView(context);
		AgendaPagerAdapter adapter = new AgendaPagerAdapter(context, position);
		v.setAdapter(adapter);
		((ViewPager) pager).addView(v, 0);
		v.setSelection(scrollPosition[position]);
		v.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				scrollPosition[position] = firstVisibleItem;
			}
		});
		
		v.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(AgendaAdapter.this.context,SessionActivity.class);
				AgendaAdapter.this.context.startActivity(i);
			}
			
		});
		return v;
	}

	@Override
	public void destroyItem(View pager, int position, Object view) {
		((ViewPager) pager).removeView((ListView) view);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

	@Override
	public void finishUpdate(View view) {
	}

	@Override
	public void restoreState(Parcelable p, ClassLoader c) {
		if (p instanceof ScrollState) {
			scrollPosition = ((ScrollState) p).getScrollPos();
		}
	}

	@Override
	public Parcelable saveState() {
		return new ScrollState(scrollPosition);
	}

	@Override
	public void startUpdate(View view) {
	}
}
