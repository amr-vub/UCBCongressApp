package org.ucb.data.dao;

import org.ucb.data.domain.Preferences;

public interface IPreferenceManager {

	public Preferences getPrefByID(int prefId);
	
	public void storePref(Preferences pref);
	
	public void updatePref(Preferences pref);
	
	public void deletePref(Preferences pref);
}
