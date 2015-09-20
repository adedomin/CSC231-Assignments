package edu.easternct.csc231.ch3;

/**
 * Sports Card invetory class;
 * for use with a db
 * <p>
 * class describes a card's player name
 * a short description, condition and value
 *
 * @author Anthony DeDominic
 */
public class SportsCard {

	// name of card
	// e.g. the player's full name
	private String name;
	// details about card
	private String description;
	// condition of card
	// Mint, Good, Fair, Poor, etc
	private String condition;
	// suggested retail price
	private double value;

	/**
	 * empty constructor
	 */
	public SportsCard() {
	}

	/**
	 * @param name
	 * @param description
	 * @param condition
	 * @param value
	 */
	public SportsCard(
			String name, String description, 
			String condition, double value) {
		this.name = name;
		this.description = description;
		this.condition = condition;
		this.value = value;
	}

	/**
	 * String representation of the object
	 */
	public String toString()
	{
		return String.format(
				"Player Name: %s\nDetails: %s\nCondition: %s\nValue: $%,.2f\n",
				name, description, 
				condition, value);
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	public static void main(String[] argv) {

		SportsCard sportsCard = new SportsCard();
	}
}
