package com.android.ehealthdesk;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;

public class LoginAdapter {
	static final String DATABASE_NAME = "";
	// Context of the application using the database.
	private final Context context;

	public LoginAdapter(Context _context) {
		context = _context;
	}

	public LoginAdapter open() throws SQLException {
		return this;
	}

	public void close() {
	}

	public void insertEntry(String username, String password) {
		ContentValues newValues = new ContentValues();
		// Assign values for each row.
		newValues.put("username", username);
		newValues.put("password", password);
		System.out.println(username+" "+password);
	}

	public int deleteEntry(String UserName) {
		return 0;
	}

	public String getSinlgeEntry(String username) {
		return "good";
	}

	public void updateEntry(String username, String password) {
		System.out.println(username + " " + password);
	}
}
