package com.android.ehealthdesk;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SpeakersActivity extends Fragment {

	public static Fragment newInstance() {
		// TODO Auto-generated method stub
		return new SpeakersActivity();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.speakers, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ListView speakerList;

		// get the ListView reference from xml file
		speakerList = (ListView) view.findViewById(R.id.list_speakers);

		// arrayColumns is the array which will contain all speakers' name in
		// your cursor, where the cursor will get the data from contacts
		// database.
		// Here we are displaying name only from the contacts database
		String[] arrayColumns = new String[] { "Amr Gamil", "David Aberspach",
				"Radu Vadana", "Xin Pang" };
		// arrayViewID is the ID of the view it will map to
		// here is the speaker.xml file
		int[] arrayViewID = new int[] { R.id.speaker };

//		// reference to the database using Cursor and URI in android.
//		Cursor cursor;
//		cursor = view.getContentResolver().query(
//				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

		/*
		 * Create an Adapter with arguments layoutID, Cursor, Array Of Columns,
		 * and Array of Views which is to be Populated This adapter will be
		 * associated with the listview to populate items directly. So this
		 * adapter is associated with the each_speaker.xlm file to view in a
		 * activity
		 */
//		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
//				R.layout.each_speaker, cursor, arrayColumns, arrayViewID);
//		speakerList.setAdapter(adapter);

		/*
		 * this is extra code for click event of any item in the list view. when
		 * you will click on na contact's name in the list view. it will give
		 * you the item name and position in a listview. Note that: if you want
		 * to query the contacts name details(like phone number for the clicked
		 * contact name & all details, we need to query it again. i will explain
		 * it in my a separate post in my blog.
		 */

		// To handle the click on List View Item
		speakerList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				// position parameter gives the index or position of ListView
				// Item which is Clicked
				TextView tv = (TextView) v.findViewById(R.id.speaker);
				String name = tv.getText().toString();
//				Toast.makeText(getApplicationContext(),
//						"Contact Selected: " + name, Toast.LENGTH_LONG).show();
			}
		});
	}

}