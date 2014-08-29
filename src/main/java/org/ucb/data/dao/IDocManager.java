package org.ucb.data.dao;

import org.ucb.data.domain.Docs;

public interface IDocManager {

	public Docs getDocById(int docId);
	
	public Docs getDocByName(String docName);
	
	public void storeDoc(Docs doc);
	
	public void updateDoc(Docs doc);
	
	public void deleteDoc(Docs doc);
}
