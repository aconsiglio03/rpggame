///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Assignment4.java
// File:               Hero.java
// Quarter:            CSE 8B Fall 2021
//
// Author:             Andrew Consiglio
// Instructor's Name:  Ben Ochoa
/**
 * Hero class. Contains constructor for Hero object and
 * methods to return the different attributes of hero
 * as well as actions made during the course of the RPG.
 * 
 * Bugs: N/A
 *
 * @author (Andrew Consiglio)
 */
public class Hero {

	private String name;
	private int health;
	private int attack;
	private int defense;
	private int speed;

	/**
	 * Constructor for hero object
	 * 
 	 *
 	 * @param (name) (Name of hero)
 	 * @param (health) (Health of hero)
	 * @param (attack) (Attack of hero)
	 * @param (defense) (Defense of hero)
	 * @param (speed) (Speed of hero)
	 * @param (Item) (Initial item hero gets)
	 *
	 */
	public Hero(String name, int health, int attack, int defense, int speed, Item initialItem) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		equipItem(initialItem);
	}
	
	/**
 	 * Allows hero to attack monster for certain amount
 	 * of damage determined by their attack - monster's defense
	 *
	 * @param (monster that hero will attack)
	 *
	 */
	public void attack(Monster monster) {
		int monsterDefense = monster.getDefense();
		int heroAttack = getAttack();
		int damage = 0;
		if(heroAttack > monsterDefense)
		{
			damage = heroAttack - monsterDefense;
		}
		else{
			damage = 1;
		}
		
		monster.receiveDamage(damage);
		System.out.println(name + " attacks " + monster.getName() + ", causing "
		+ damage + " damage");
		monster.printStats();
	}

	/**
 	 * Allows hero to equip an Item, adds stats to attributes
 	 * 
	 *
	 * @param (Item to be equipped)
	 *
	 */
	public void equipItem(Item item) {
		health += item.getHealth();
		attack += item.getAttack();
		defense += item.getDefense();
		speed += item.getSpeed();
		System.out.println(name + " received " + item.getName());
	}

	/**
 	 * Checks if hero's speed is greater than monster's.
 	 * 
	 *
	 * @param (Monster to be compared to)
	 *
	 */
	public boolean isFasterThan(Monster monster) {
		if(speed > monster.getSpeed()){
			return true;
		}
		else {
			return false;
		}
	}

	/**
 	 * Checks to see if hero's health is above 0
	 *
	 * @return (true if yes, false if not)
	 */
	public boolean isStillAlive() {
		if(health>0) {
			return true;
		}
		else {
			System.out.println(name + " is defeated");
			return false;
		}
	}

	/**
 	 * Reduces hero's health based on damage done.
	 *
	 * @param (damage to hero)
	 */
	public void receiveDamage(int damage) {
		health -= damage;
	}

	/**
 	 * Returns name attribute.
 	 * 
	 * @return (String of name)
	 */
	public String getName() {
		return name;
	}
	
	/**
 	 * Returns health attribute.
 	 * 
	 * @return int of health)
	 */
	public int getHealth() {
		return health;
	}
	
	/**
 	 * Returns attack attribute.
 	 * 
	 * @return int of attack)
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
 	 * Returns defense attribute.
 	 * 
	 * @return int of defense)
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
 	 * Returns speed attribute.
 	 * 
	 * @return int of speed)
	 */
	public int getSpeed() {
		return speed;
	}

	public void printStats() {
		String str = String.format("\t%s - health: %d, attack: %d, defense: %d, speed: %d", this.name, this.health, this.attack, this.defense, this.speed);
		System.out.println(str);
	}
}