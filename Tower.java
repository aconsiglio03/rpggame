///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Assignment4.java
// File:              Tower.java
// Quarter:            CSE 8B Fall 2021
//
// Author:             Andrew Consiglio
// Instructor's Name:  Ben Ochoa
/**
 * Tower class. Contains constructor for Tower object and
 * methods to return the height of tower as well as which
 * items and monsters are on each floor/level.
 *
 * Bugs: N/A
 *
 * @author (Andrew Consiglio)
 */
public class Tower {

	private int height;
	private Monster[] monsterEachLevel;
	private Item[] itemEachLevel;


	/**
	 * Constructor for tower object.
	 * 
 	 *
 	 * @param (height) (Number of levels in RPG)
	 * 
	 */
	public Tower(int height) {
		if(height > 0){
			this.height = height;
			monsterEachLevel = new Monster[height];
			itemEachLevel = new Item[height];
		}
		else {
			height = 1;
			monsterEachLevel = new Monster[height];
			itemEachLevel = new Item[height];
		}
	}

	/**
	 * Iterates through each level of RPG allowing hero to
	 * fight different monsters.
 	 *
 	 * @param (level) (Specified level to set monster and item)
 	 * @param (monster) (Chooses monster for this level)
	 * @param (item) (Chooses item for this level)
	 */
	public void setOneLevel(int level, Monster monster, Item item) {
		monsterEachLevel[level] = monster;
		itemEachLevel[level] = item;
	}

	/**
 	 * Returns height attribute.
 	 * 
	 * @return (int of height)
	 */
	public int getHeight() {
		return height;
	}

	/**
 	 * Returns Monster at specified level.
 	 * 
	 * @param (level of tower)
	 *
	 * @return (Object monster at level)
	 */
	public Monster getMonsterAtLevel(int level) {
		return monsterEachLevel[level];
	}

	/**
 	 * Returns Item at specified level.
 	 * 
	 * @param (level of tower)
	 *
	 * @return (Object item at level)
	 */
	public Item getItemAtLevel(int level) {
		return itemEachLevel[level];
	}
}