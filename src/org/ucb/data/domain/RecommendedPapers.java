package org.ucb.data.domain;

import java.util.List;

/** 
 * This class reflects papers that HCP recommends for reading peers
 * to expand knowledge in peer's specialty or sub-specialty
 * 
 * TODO do we need more details???!!!
 */

public class RecommendedPapers {

	private int paperID;
	
	private String recPaperName;
	
	private String recPaperAuthor;
	
	private String recPaperYear;
	
	private int recPaperRanking;
	
	// each paper can be recommended by one or more reg hcp
	private List<RegisteredHCP> RecommendedPapers_RegHCP;
	
	public RecommendedPapers(){
		
	}

	public List<RegisteredHCP> getRecommendedPapers_RegHCP() {
		return RecommendedPapers_RegHCP;
	}

	public void setRecommendedPapers_RegHCP(
			List<RegisteredHCP> recommendedPapers_RegHCP) {
		RecommendedPapers_RegHCP = recommendedPapers_RegHCP;
	}

	public int getPaperID() {
		return paperID;
	}

	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}

	public String getRecPaperName() {
		return recPaperName;
	}

	public void setRecPaperName(String recPaperName) {
		this.recPaperName = recPaperName;
	}

	public String getRecPaperAuthor() {
		return recPaperAuthor;
	}

	public void setRecPaperAuthor(String recPaperAuthor) {
		this.recPaperAuthor = recPaperAuthor;
	}

	public String getRecPaperYear() {
		return recPaperYear;
	}

	public void setRecPaperYear(String recPaperYear) {
		this.recPaperYear = recPaperYear;
	}

	public int getRecPaperRanking() {
		return recPaperRanking;
	}

	public void setRecPaperRanking(int recPaperRanking) {
		this.recPaperRanking = recPaperRanking;
	}
	
	
}
