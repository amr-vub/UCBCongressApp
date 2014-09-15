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

public class CongressFragment extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.congress_frag, container, false);

        SeekBar sb = (SeekBar) v.findViewById(R.id.cong_frequency_bar);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {       

            @Override       
            public void onStopTrackingTouch(SeekBar seekBar) {      
            }       

            @Override       
            public void onStartTrackingTouch(SeekBar seekBar) {    
            }       

            @Override       
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {     
                // TODO Auto-generated method stub      
            	Toast.makeText(getActivity(), "Your preferences have been saved.",Toast.LENGTH_LONG).show();

            }
            });

        return v;
    }

    public static CongressFragment newInstance(String text) {

    	CongressFragment f = new CongressFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
