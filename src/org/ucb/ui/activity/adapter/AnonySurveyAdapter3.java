package org.ucb.ui.activity.adapter;

import java.util.ArrayList;

import org.ucb.ui.activity.*;
import org.ucb.ui.activity.object.InterestItem;
import org.ucb.ui.activity.survey.AnonySurveyActivity3;
import org.ucb.ui.activity.survey.AnonySurveyActivity3.ViewHolder;
import org.ucb.ui.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AnonySurveyAdapter3 extends BaseAdapter {
	private Context context;
	private LayoutInflater mInflater;
	private ArrayList<InterestItem> myObjects;

	public AnonySurveyAdapter3(Context context,
			ArrayList<InterestItem> myObjects) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
		this.myObjects = myObjects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		InterestItem object = myObjects.get(position);
		ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.survey_interest_options, null);
			holder = new ViewHolder();
			holder.text = (TextView) convertView.findViewById(R.id.interest_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text.setText(object.getTitle());

		if (object.isState() == true) {
			holder.text.setBackground(context.getResources().getDrawable(R.drawable.button_checked));
		} else {
			holder.text.setBackground(context.getResources().getDrawable(R.drawable.button));
			
		}
		return convertView;
	}

	@Override
	public int getCount() {
		return myObjects.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}
