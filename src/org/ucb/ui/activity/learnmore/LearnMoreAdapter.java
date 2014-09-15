package org.ucb.ui.activity.learnmore;

import java.util.ArrayList;

import org.ucb.data.domain.LMRelatedWebsites;
import org.ucb.data.domain.LearmMore;
import org.ucb.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LearnMoreAdapter extends ArrayAdapter<LearmMore> {

	private final Context context;
	private final ArrayList<LearmMore> itemsArrayList;

	public LearnMoreAdapter(Context context,
			ArrayList<LearmMore> itemsArrayList) {

		super(context, R.layout.session_learn_more, itemsArrayList);

		this.context = context;
		this.itemsArrayList = itemsArrayList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// 1. Create inflater
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// 2. Get rowView from inflater
		View rowView = inflater.inflate(R.layout.session_item, parent, false);

		// 3. Get the two text view from the rowView
		TextView titleView = (TextView) rowView
				.findViewById(R.id.session_title);
		TextView timeView = (TextView) rowView.findViewById(R.id.session_time);
		// 4. Set the text for textView
		titleView.setText(itemsArrayList.get(position).getTitle());
		timeView.setText(itemsArrayList.get(position).getOverview());

		// 5. retrn rowView
		return rowView;
	}
}
