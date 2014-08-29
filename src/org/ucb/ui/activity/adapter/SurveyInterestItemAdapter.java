package org.ucb.ui.activity.adapter;

import java.util.ArrayList;
import org.ucb.model.InterestItem;
import org.ucb.ui.activity.survey.AnonySurveyActivity3.ViewHolder;
import org.ucb.ui.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * The adapter is for handling the data of the 3rd page of anonymous user
 * survey. In the page the user taps several items in the interest list and this
 * adapter class retrieve it and communicate with the back-end to save/update
 * it.
 */
public class SurveyInterestItemAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater layoutInflater;
	private ArrayList<InterestItem> interestItems;

	public SurveyInterestItemAdapter(Context context,
			ArrayList<InterestItem> interestItems) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.interestItems = interestItems;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		InterestItem object = interestItems.get(position);
		ViewHolder holder;

		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.survey_interest_item,
					null);
			holder = new ViewHolder();
			holder.text = (TextView) convertView
					.findViewById(R.id.interest_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text.setText(object.getTitle());

		if (object.isChecked() == true) {
			holder.text.setBackground(context.getResources().getDrawable(
					R.drawable.ic_button_blue));
			holder.text.setTextColor(context.getResources().getColor(
					R.color.ucb_grey1));
		} else {
			holder.text.setBackground(context.getResources().getDrawable(
					R.drawable.ic_button_white));
			holder.text.setTextColor(context.getResources().getColor(
					R.color.ucb_blue1));
		}
		return convertView;
	}

	@Override
	public int getCount() {
		return interestItems.size();
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
