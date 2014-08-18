package org.ucb.ui.activity.preference;

import org.ucb.ui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class WebinarFragment extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.webinar_frag, container, false);

        SeekBar sb = (SeekBar) v.findViewById(R.id.web_frequency_bar);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {       

            @Override       
            public void onStopTrackingTouch(SeekBar seekBar) {      
            }       

            @Override       
            public void onStartTrackingTouch(SeekBar seekBar) {    
            }       

            @Override       
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {     
                // TODO Auto-generated method stub      
            	Toast.makeText(getActivity(), String.valueOf(progress),Toast.LENGTH_LONG).show();

            }
            });

        return v;
    }

    public static WebinarFragment newInstance(String text) {

    	WebinarFragment f = new WebinarFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
