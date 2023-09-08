///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    Assignment4.java
// File:               Monster.java
// Quarter:            CSE 8B Fall 2021
//
// Author:             Andrew Consiglio
// Instructor's Name:  Ben Ochoa
/**
 * Monster class. Contains constructor for Monster object and
 * methods to return the different attributes of monster
 * as well as actions made during the course of the RPG.
 * 
 * Bugs: N/A
 *
 * @author (Andrew Consiglio)
 */

public class Monster {

	private String name;
	private int health;
	private int attack;
	private int defense;
	private int speed;

	/**
	 * Constructor for monster object
	 * 
 	 *
 	 * @param (name) (Name of monster)
 	 * @param (health) (Health of monster)
	 * @param (attack) (Attack of monster)
	 * @param (defense) (Defense of monster)
	 * @param (speed) (Speed of monster)
	 *
	 *
	 */
	public Monster(String name, int health, int attack, int defense, int speed) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}

	/**
 	 * Allows monster to attack hero for certain amount
 	 * of damage determined by their attack - hero's defense
	 *
	 * @param (hero that monster will attack)
	 *
	 */
	public void attack(Hero hero) {
		int heroDefense = hero.getDefense();
		int monsterAttack = getAttack();
		int damage = 0;
		if(monsterAttack > heroDefense)
		{
			damage = monsterAttack-heroDefense;
		}
		else{
			damage = 1;
		}
		
		hero.receiveDamage(damage);
		System.out.println(name + " attacks " + hero.getName() + ", causing "
		+ damage + " damage");
		hero.printStats();
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
	 * @param (damage to monster)
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