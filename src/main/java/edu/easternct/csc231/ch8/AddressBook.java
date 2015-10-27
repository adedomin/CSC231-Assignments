package edu.easternct.csc231.ch8;

import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

/**
 * AddressBook object for retaining contacts and events
 *
 * @author Anthony DeDominic 
 */
public class AddressBook {

	private Map<String, Contact> contacts;
	private Map<String, Event> events;

	public AddressBook() {
		contacts = new TreeMap<String, Contact>();
		events = new TreeMap<String, Event>();
	}

	/**
	 * @param name of contact to fecth
	 * @return the contact with given name
	 *         or null if doesn't exist
	 */
	public Contact getContact(String name) {

		return contacts.get(name);
	}

	/**
	 * @param contact a contact to remove by
	 */
	public void removeContact(Contact contact) {

		contacts.remove(contact.name);
	}

	/**
	 * @param name name of contact to remove
	 */
	public void removeContact(String name) {
		
		contacts.remove(name);
	}

	/**
	 * @param contact a contact to add
	 */
	public void insertContact(Contact contact) {
		
		contacts.put(contact.name, contact);
	}

	/**
	 * @param title title to fetch by
	 * @return the event which 
	 *         contains said title
	 *         or null
	 */
	public Event getEvent(String title) {

		return events.get(title);
	}

	/**
	 * @param event object to remove
	 */
	public void removeEvent(Event event) {

		events.remove(event.title);
	}

	/**
	 * @param title of event to remove by
	 */
	public void removeEvent(String title) {
		
		events.remove(title);
	}

	/**
	 * @param event a new event to add
	 */
	public void insertEvent(Event event) {

		events.put(event.title, event);
	}

	/**
	 * @return string representation 
	 *         of all the contacts
	 */
	public String printContactList() {
	
		String ret = "";
		for (Contact contact : contacts.values()) {
			ret += contact.toString();	
		}

		return ret;
	}

	/**
	 * @return string representation
	 *         of all the events
	 */
	public String printEventList() {

		String ret = "";
		for (Event event : events.values()) {
			ret += event.toString();
		}
		return ret;
	}

	public static void main(String[] args) {

		AddressBook contactBook = new AddressBook();
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to enter Contact Information? Enter 'y' or 'n'. ");
		String answer = in.next();
		in.nextLine();

		while(answer.equals("y"))
		{	
			System.out.println("Enter the New Contact Names: ");
			String name = in.nextLine();
			System.out.println("Enter the New Contact Address: ");
			String address = in.nextLine();
			System.out.println("Enter the New Contact Birthday: ");
			String birthday = in.nextLine();

			contactBook.insertContact(new Contact(name, address, birthday));

			System.out.println("Would you like to enter Contact Information? Enter 'y' or 'n'. ");
			answer = in.next();
			in.nextLine();
		}		

		System.out.print("Would you like to enter Event Information? Enter 'y' or 'n'. \t");
		answer = in.next();
		in.nextLine();
		while(answer.equals("y"))
		{	
			System.out.print("Enter the New Event: \t");
			String title = in.nextLine();
			System.out.print("Enter the New Event Attendace Info: \t");
			String attendance = in.nextLine();

			contactBook.insertEvent(new Event(title, attendance));

			System.out.print("Would you like to enter more Event Information? Enter 'y' or 'n'. \t");
			answer = in.next();
			in.nextLine();
		}

		in.close();

		System.out.println("\nContact List ");
		System.out.println("\n" + contactBook.printContactList());
		System.out.println("\nEvents ");
		System.out.println("\n" + contactBook.printEventList());
		System.out.print("\nThank you for entering data into the system. ");
	}
}
