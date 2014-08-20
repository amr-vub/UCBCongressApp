package org.ucb.services.recommender;

import java.util.ArrayList;


public abstract class AbstractRecommender {

	//The underlying database
	//protected TranscriptMemHelper tmh;
	
	public abstract double recommend();
	
	// to be modified
	public abstract boolean add(Object entry);
	// To be implemented at this level
	
	public abstract ArrayList<Material> getUnratedEntries(int sid);
	
	public abstract void rankMaterial(int sid, ArrayList<Material> course);
	
	public ArrayList<Material> removeMaterialRanking(int level, ArrayList<Material> materials)
	{
		int count = 0;
		ArrayList<Material> materialsToRank = new ArrayList<Material>();
		
		for(Material m : materials)
		{
			//count = Integer.parseInt(m.get)
			
		}
		
		return materialsToRank;
	}
}
