package org.ucb.services.recommender;

public abstract class Material {

	private Integer rankingMax = 5;

	// From 1 star up to 5 stars
	private Integer ranking;

	private int rankingCount;

	private int rankingTimes;

	public Material() {
		ranking = 0;

		rankingTimes = 0;
	}

	public Integer getCurrentRanking() {
		return ranking;
	}

	public void rank(Integer newRank) {

		rankingTimes++;
		this.ranking = (rankingCount + newRank) / (rankingTimes * rankingMax);

		// TODO: Store the current ranking into the DB
		//
	}

}
