package edu.easternct.csc231.ch3;

/**
 * To track parking spaces and users who have reserved them;
 * serializable to allow for persistent storage
 * <p>
 * intended to be stored and looked up
 *
 * @author Anthony DeDominic
 */
public class ParkingSpace {

	// specific location of space
	private String spaceId;
	// name or reserver
	private String name;
	// the parking garage location
	private String address;
	
	/**
	 * empty constructor
	 */
	public ParkingSpace() {
	}
	
	/**
	 * @param spaceId
	 * @param name
	 * @param address
	 */
	public ParkingSpace(String spaceId, String name, String address) {
		this.spaceId = spaceId;
		this.name = name;
		this.address = address;
	}

	/**
	 * represent object as a printable string
	 */
	public String toString()
	{
		return String.format(
				"Space ID: %s\nName: %s\nGarage: %s\n",
				spaceId, name, address);
	}

	/**
	 * @return the spaceId
	 */
	public String getSpaceId() {
		return spaceId;
	}

	/**
	 * @param spaceId the spaceId to set
	 */
	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] argv) {

		ParkingSpace parkingSpace = new ParkingSpace();

		parkingSpace.setSpaceId("235-A");
		parkingSpace.setName("Anthony");
		parkingSpace.setAddress("234 Main St. Walla Walla, WA");

		System.out.printf("%s\n", parkingSpace);

		ParkingSpace parkingSpace2 = new ParkingSpace(
				"12-B", "DeDominic", "1 Infinity Loop Dr. Cupertino, CA");

		System.out.printf("%s", parkingSpace2);
	}
}
