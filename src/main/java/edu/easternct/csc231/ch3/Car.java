package edu.easternct.csc231.ch3;

import java.io.Serializable;

/**
 * class which describes a car in a dealership
 * <p>
 * includes make,model,year,price and location;
 * to be managed by a database
 *
 * @author Anthony DeDominic
 */
public class Car implements Serializable {

	static final long serialVersionUID;

	// lot location id
	// location of the car in the dealership
	private String lotId;
	// make of automobile
	private String make;
	// model of automobile
	private String model;
	// year of car
	private String year;
	// MSRP of vehicle
	// manufacturer suggested retail price
	private double msrp;

	/**
	 * empty constructor
	 */
	public Car() {
	}

	/**
	 * @param lotId
	 * @param make
	 * @param model
	 * @param year
	 * @param msrp
	 */
	public Car(String lotId, String make, String model, String year, double msrp) {
		this.lotId = lotId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.msrp = msrp;
	}

	/**
	 * represent class as string;
	 * for visualization or debugging
	 */
	public String toString() {
		return String.format(
				"Make: %s\nModel: %s\nYear: %s\nMSRP: $%,.2\nLocation: %s",
				make, model, year, msrp, lotId);
	}

	/**
	 * @return the lotId
	 */
	public String getLotId() {
		return lotId;
	}

	/**
	 * @param lotId the lotId to set
	 */
	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the msrp
	 */
	public double getMsrp() {
		return msrp;
	}

	/**
	 * @param msrp the msrp to set
	 */
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
}
