package edu.easternct.csc231.ch8;

/**
 * a class describing an address book
 * contact
 *
 * @author Anthony DeDominic
 */
public class Contact {

	public String name;
	public String address;
	public String birthday;

	/**
	 * empty contact
	 */
	public Contact() {

		name = "";
		address = "";
		birthday = "";
	}

	/**
	 * full contact
	 *
	 * @param name
	 * @param address
	 * @param birthday
	 */
	public Contact(String name, String address, String birthday) {

		this.name = name;
		this.address = address;
		this.birthday = birthday;
	}

	/**
	 * description of object as a string
	 * @return the string
	 */
	public String toString() {
		
		return String.format("Name: %s\nAddress: %s\nBirthday: %s\n",
				name, address, birthday);
	}
}
