///////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment5.java
// File:               Item.java
// Quarter:            Fall 2021
//
// Author:             Andrew Consiglio
// Instructor's Name:  Ben Ochoa
//
//////////////////////////// 80 columns wide //////////////////////////////////


/**
 * This class creates a superclass for Berry.java and Pokeball.java with
 * an attribute for name.
 *
 * Bugs: Unknown
 *
 * @author Andrew Consiglio
 */

public class Item {
	private String name;
	private static final String ITEM = "Item";

	/**
     	 * Constructor for item object, defaults to "Item" for name parameter
     	 * 
     	 */
	public Item() {
		name = ITEM;
	}

	/**
     	 * Constructor for item object, defaults to "Item" for name parameter
     	 * 
	 * @parameter String for name of Item
     	 */
	public Item(String name) {
		this.name = name;
	}

	/**
     	 * Getter for name attribute
     	 * 
	 * @return String name attribute
     	 */
	public String getName() {
		return name;
	}

	/**
     	 * Setter for name attribute
     	 * 
	 * @parameter String for name attribute
     	 */
	public void setName(String name) {
		this.name = name;
	}
}