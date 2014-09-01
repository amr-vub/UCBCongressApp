package org.ucb.ui.activity.adapter;

import java.util.ArrayList;

import org.ucb.ui.R;
import org.ucb.ui.model.Session;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AgendaPagerAdapter extends BaseAdapter {
	private int position;
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private ArrayList<Session> mEntries = new ArrayList<Session>();
	boolean isSelected;

	public AgendaPagerAdapter(Context context, int position) {
		position = position + 1;
		mContext = context;
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		init(mEntries);
	}

	// this function should connect to the service part and retrieve data
	public void init(ArrayList<Session> entries) {
		isSelected = false;
		
		for (int i = 0; i < 10; i++) {
			Session s = new Session();
			s.setDate("2014-08-2" + i);
			s.setPlace("Room 50" + i);
			s.setTitle("Day " + position + ": Introduction " + i);
			s.setSpeaker("Speaker " + i);
			entries.add(s);
		}
	}

	@Override
	public int getCount() {
		return mEntries.size();
	}

	@Override
	public Object getItem(int position) {
		return mEntries.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RelativeLayout itemView;
		if (convertView == null) {
			itemView = (RelativeLayout) mLayoutInflater.inflate(
					R.layout.session_item, parent, false);

		} else {
			itemView = (RelativeLayout) convertView;
		}
		Button addToPersonalAgenda = (Button) itemView
				.findViewById(R.id.session_add_to_agenda);
		addToPersonalAgenda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isSelected) {
					v.setBackgroundResource(R.drawable.ic_action_event);
					Toast.makeText(mContext, "The session has been deleted.",
							Toast.LENGTH_SHORT).show();
					isSelected = false;
				}
				else{
					v.setBackgroundResource(R.drawable.ic_action_event_selected);
					Toast.makeText(mContext, "The session has been added.",
							Toast.LENGTH_SHORT).show();
					isSelected = true;
				}
			}

		});
		TextView sessionTitle = (TextView) itemView
				.findViewById(R.id.session_title);
		TextView sessionTime = (TextView) itemView
				.findViewById(R.id.session_time);
		TextView sessionPlace = (TextView) itemView
				.findViewById(R.id.session_place);
		TextView sessionSpeaker = (TextView) itemView
				.findViewById(R.id.session_speaker);

		String title = mEntries.get(position).getTitle();
		sessionTitle.setText(title);
		String time = mEntries.get(position).getDate();
		sessionTime.setText(time);
		String place = mEntries.get(position).getPlace();
		sessionPlace.setText(place);
		String speaker = mEntries.get(position).getSpeaker();
		sessionSpeaker.setText(speaker);

		return itemView;
	}

	public void upDateEntries(ArrayList<Session> entries) {
		mEntries = entries;
		notifyDataSetChanged();
	}
}
