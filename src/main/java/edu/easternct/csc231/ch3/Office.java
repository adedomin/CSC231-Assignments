package edu.easternct.csc231.ch3;

import java.io.Serializable;

/**
 * Object describing an office, 
 * where it is located, 
 * and who is occupying it
 * <p>
 * For storage in a database system
 *
 * @author Anthony DeDominic
 */
public class Office implements Serializable {

	static final long serialVersionUID;
	// name of org or professor using office
	private String userName;
	// building name
	private String buildingName;
	// location as in a number
	private String officeId;

	/**
	 * @param userName
	 * @param buildingName
	 * @param officeId
	 */
	public Office(String userName, String buildingName, String officeId) {
		this.userName = userName;
		this.buildingName = buildingName;
		this.officeId = officeId;
	}

	/**
	 * empty constructor
	 */
	public Office() {
	}

	/**
	 * a string representation of all 
	 * the member variables
	 */
	public String toString() {
		return String.format(
				"Professor/Organization: %s\nBuilding: %s\nOffice #: %s",
				userName, buildingName, officeId);
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the officeId
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
}
