package voting;

import identification.AnonymousUser;

public class Voter {

	private AnonymousUser userID;
	private boolean voted;

	public AnonymousUser getUserID() {
		return userID;
	}

	public void setUserID(AnonymousUser userID) {
		this.userID = userID;
	}

	public boolean hasVoted() {
		return voted;
	}

	public void vote() {
		voted = true;
	}

}
