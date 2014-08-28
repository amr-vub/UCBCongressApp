package org.ucb.ui.activity;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

	SharedPreferences pref; // Shared preferences
	Editor editor; // Editor for shared preferences
	Context mContext; // Context
	final String PREF_NAME = "UserCredentials";// Shared preference file name
	// All Shared Preferences Keys
	// TRUE for logged in; FALSE for anonymous
	final String USER_MODE = "usermode";
	final String KEY_ACCESS_CODE = "accesscode";
	final String KEY_USERNAME = "username";
	final String KEY_PASSWORD = "password";
	final String FIRST_TIME = "firsttime";

	// Constructor
	public SessionManager(Context context) {
		this.mContext = context;
		pref = mContext.getSharedPreferences(PREF_NAME, mContext.MODE_PRIVATE);
		editor = pref.edit();
	}

	/**
	 * Create login session
	 * */
	public void createRegisteredUserSession(String username, String password) {
		// Storing login value as TRUE
		editor.putBoolean(USER_MODE, true);

		// Storing name in pref
		editor.putString(KEY_USERNAME, username);

		// Storing password in pref
		editor.putString(KEY_PASSWORD, password);

		// commit changes
		editor.commit();
	}
	
	/**
	 * Create login session
	 * */
	public void createAnonymousSession(String accessCode) {
		// Storing login value as TRUE
		editor.putBoolean(USER_MODE, false);

		// Storing name in pref
		editor.putString(KEY_ACCESS_CODE, accessCode);

		// commit changes
		editor.commit();
	}

	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getRegisteredUserDetails() {
		HashMap<String, String> user = new HashMap<String, String>();
		// user name
		user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));

		// user email id
		user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));

		// return user
		return user;
	}
	
	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getAnonymousUserDetails() {
		HashMap<String, String> user = new HashMap<String, String>();
		// user name
		user.put(KEY_ACCESS_CODE, pref.getString(KEY_ACCESS_CODE, null));

		// return user
		return user;
	}
	/**
	 * Clear session details
	 * */
	public void logoutUser() {
		// Clearing all data from Shared Preferences
		editor.clear();
		editor.commit();

		// After logout redirect user to Log in Activity
		Intent i = new Intent(mContext, StartActivity.class);
		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// Staring Login Activity
		mContext.startActivity(i);
	}

	/**
	 * Quick check for login
	 * **/
	// Get user mode: anonymous or logged in
	public boolean getUserMode() {
		return pref.getBoolean(USER_MODE, false);
	}
	
	public boolean getFirstTime(){
		return pref.getBoolean(FIRST_TIME, false);
	}
	public boolean setFirstTime(){
		SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("RanBefore", true);
        return editor.commit();
	}
}