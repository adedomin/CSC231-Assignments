package edu.easternct.csc231.ch8;

public class Event {

	public String title;
	public String attendance;

	/**
	 * empty
	 */
	public Event() {

	}

	/**
	 * @param title
	 * @param attendance
	 */
	public Event(String title, String attendance) {

		this.title = title;
		this.attendance = attendance;
	}

	/**
	 * description of event as a string
	 *
	 * @return object as string
	 */
	public String toString() {

		return String.format("Title: %s\nAttendance: %s\n",
				title, attendance);
	}
}


