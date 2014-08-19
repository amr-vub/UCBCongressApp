package org.ucb.ui.activity.home;

import java.util.ArrayList;

import org.ucb.ui.R;
import org.ucb.ui.activity.*;

import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends FragmentActivity {

	final String TAG = HomeActivity.class.getSimpleName();

	boolean userMode;
	SessionManager session;
	DrawerLayout mDrawerLayout;
	ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;

	CharSequence mDrawerTitle;
	CharSequence mTitle;
	ArrayList<String> mDrawerItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawerItems = new ArrayList<String>();
		session = new SessionManager(getApplicationContext());
		userMode = session.getUserMode();
		mTitle = mDrawerTitle = getTitle();

		mDrawerItems.add(getResources().getString(R.string.agenda));
		mDrawerItems.add(getResources().getString(R.string.speakers));
		if(session.getUserMode()){
			mDrawerItems.add(0,getResources().getString(R.string.user_profile));
			mDrawerItems.add(getResources().getString(R.string.preferences));
		}
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mDrawerItems));

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Set the default content area to item 0
		// when the app opens for the first time
		if (savedInstanceState == null) {
			navigateTo(1);
		}

	}

	/*
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			navigateTo(position);
		}
	}

	private void navigateTo(int position) {

		switch (position) {
		case 0:
			if (this.userMode) {
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.content_frame,
								UserProfileActivity.newInstance(),
								"UserProfileActivity").commit();
			}
			break;
		case 1:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, AgendaActivity.newInstance(),
							"Agenda").commit();
			break;
		case 2:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
							SpeakersActivity.newInstance(), "Speakers")
					.commit();
			break;
		case 3:
			if (this.userMode) {
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.content_frame,
								PreferenceActivity.newInstance(), "Preferences")
						.commit();
			}
			break;
		}
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home, menu);
		if(!this.userMode){
			menu.findItem(R.id.action_register).setVisible(true);
			menu.findItem(R.id.action_invitation).setVisible(false);
			invalidateOptionsMenu();
		}
		if(this.userMode){
			menu.findItem(R.id.action_register).setVisible(false);
			menu.findItem(R.id.action_invitation).setVisible(true);
			invalidateOptionsMenu();
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		} else {
			switch (item.getItemId()) {
			case R.id.action_register:
				openRegister();
				return true;
			case R.id.action_settings:
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}
	}

	private void openRegister() {
		Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
		startActivity(intent);
	}

}
