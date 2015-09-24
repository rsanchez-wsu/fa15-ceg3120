package edu.wright.cs.fa15.ceg3120.concon.common.data;

public class JobRequest {

	/** 
	 * Signifies whether this request is a new job or a request for all jobs
	 * from a given account
	 */
	private String requestType;
	/** User making request */
	private HomeOwnerAccount user;
	/** Earliest construction can begin */
	private String dateRangeStart;
	/** Latest date construction can begin */
    private String dateRangeEnd;
    
	public JobRequest() {
		
	}

	public String getDateRangeStart() {
		return dateRangeStart;
	}

	public void setDateRangeStart(String dateRangeStart) {
		this.dateRangeStart = dateRangeStart;
	}

	public String getDateRangeEnd() {
		return dateRangeEnd;
	}

	public void setDateRangeEnd(String dateRangeEnd) {
		this.dateRangeEnd = dateRangeEnd;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public HomeOwnerAccount getUser() {
		//clone this?
		return user;
	}

	public void setUser(HomeOwnerAccount user) {
		this.user = user;
	}

}
