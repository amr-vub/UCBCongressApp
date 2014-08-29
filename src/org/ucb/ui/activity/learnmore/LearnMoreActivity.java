package org.ucb.ui.activity.learnmore;

import java.util.ArrayList;

import org.ucb.data.domain.LearnMoreItem;
import org.ucb.ui.R;
import org.ucb.ui.activity.adapter.SessionAdapter;
import org.ucb.ui.activity.survey.AnonySurveyActivity1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class LearnMoreActivity extends ListActivity {
	

	SessionAdapter sessionAdapter;


	@Override
	public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
 
        // 1. pass context and data to the custom adapter
        LearnMoreAdapter adapter = new LearnMoreAdapter(this, generateData());
 
        //2. setListAdapter
        setListAdapter(adapter);
    }
 
    private ArrayList<LearnMoreItem> generateData(){
        ArrayList<LearnMoreItem> items = new ArrayList<LearnMoreItem>();
        LearnMoreItem lmi = new LearnMoreItem();
        lmi.setPerson("Michael Jackson");
        lmi.setTime("2004");
        lmi.setTitle("General overview of Epilepsy");
        items.add(lmi);
        lmi.setPerson("Dan Brown");
        lmi.setTime("2005");
        lmi.setTitle("A medical practice: lessons learned from patients");
        items.add(lmi);
        return items;
    }


}
