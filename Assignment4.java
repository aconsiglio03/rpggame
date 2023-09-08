///////////////////////////////////////////////////////////////////////////////
//                   
// Title:              Assignment4.java
// Files:              Assignment4.java, Hero.java, Monster.java, Item.java, Tower.java
// Quarter:            CSE8B Fall 2021
//
// Author:             Andrew Consiglio
// Email:              aconsiglio@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * Main class for assignment 4. Has a variety of testers to check other
 * classes' methods as well as a playGame() method to actually run
 * the RPG. Static void main runs these testers as well as the playGame()
 * method.
 *
 * Bugs: N/A
 *
 * @author (Andrew Consiglio)
 */
public class Assignment4 {

	public static Tower setUpTower() {
		// Initialize the tower with 5 levels
		Tower tower = new Tower(5);
		// Initialize the different monsters
		// Parameters: Name, HP, Attack, Defense, Speed
		Monster slime = new Monster("slime", 2, 2, 0, 2);
		Monster mummy = new Monster("mummy", 5, 3, 1, 1);
		Monster ghost = new Monster("ghost", 9, 5, 2, 7);
		Monster yeti = new Monster("yeti", 15, 5, 4, 2);
		Monster wyvern = new Monster("wyvern", 20, 7, 6, 8);
		tower.setOneLevel(0, slime, new Item("Knight Sword"));
		tower.setOneLevel(1, mummy, new Item("HP Elixir"));
		tower.setOneLevel(2, ghost, new Item("Platinum Shield"));
		tower.setOneLevel(3, yeti, new Item("Thunder Hammer"));
		tower.setOneLevel(4, wyvern, new Item("Treasure"));
		return tower;
	}

	/**
	 * Iterates through each level of RPG allowing hero to
	 * fight different monsters.
 	 *
 	 * @param (hero) (Hero object, character of rpg)
 	 * @param (tower) (Tower object, determines number of levels)
	 * 
	 */

	public static void playGame(Hero hero, Tower tower) {
		//Iterates through each level of tower
		for(int i = 0; i < tower.getHeight(); i++){
			if(i==0)
			{
				System.out.println();
			}

			Monster currentMonster = tower.getMonsterAtLevel(i);
			System.out.println("Level " + i + ": " + hero.getName()
			+ " encounters " + currentMonster.getName());
			currentMonster.printStats();

			//Allows whichever has more speed to attack first
			if(currentMonster.getSpeed() < hero.getSpeed()){
				//Continue to attack each other while both are alive
				while(hero.getHealth()>0 && currentMonster.getHealth()>0)
				{
					hero.attack(currentMonster);
					if(currentMonster.getHealth()>0){
						currentMonster.attack(hero);
					}
					currentMonster.isStillAlive();
					hero.isStillAlive();
				}
			}
			else{
				while(hero.getHealth()>0 && currentMonster.getHealth()>0)
				{
					currentMonster.attack(hero);
					if(hero.getHealth()>0){
						hero.attack(currentMonster);
					}
					currentMonster.isStillAlive();
					hero.isStillAlive();
				}	
					
			
			}

			//Ends game if hero dies
			if(!hero.isStillAlive()){
				System.out.println("Game Over!");
				break;
			}
			
			//Equips item if monster is defeated
			hero.equipItem(tower.getItemAtLevel(i));
			
			if(i!=tower.getHeight()-1)
			{
				System.out.println();
			}
			
			if(i == tower.getHeight()-1 && hero.getHealth() > 0)
			{
			System.out.println("The Hero Wins!");
			}	

			
		}
	
				
	}


	/**
	 * Tests methods created in other classes.
	 * 
 	 *
 	 * 
 	 * 
	 * @return (boolean result, true if tests are correct, false if not)
	 */
	public static boolean unitTests() {
		boolean result = true;
		
		//Constructs test objects
		Item itemTestHero = new Item("Knight Sword");
		Monster testMonster = new Monster("Monster Test", 10, 3, 3, 2);
		Hero testHero = new Hero("Hero Test", 15, 4, 2, 4, itemTestHero);
		Item itemTest = new Item("Thunder Hammer");
		Tower testTower = new Tower(3);

		//Checks attributes of each object to test constructor and get methods
		if(testMonster.getHealth()!=10)
		{
			result = false;
			System.out.println(testMonster.getHealth());
		}
		if(testHero.getDefense()!=2)
		{
			result = false;
			System.out.println(testHero.getName());
		}
		if(itemTest.getHealth()!=0)
		{
			result = false;
		}
		if(testTower.getHeight()!=3)
		{
			result = false;
		}

		
		//Tests if equipItem() method is correctly working
		

		if(testHero.getAttack()!=10)
		{
			result = false;
		}

		//Testing attack methods
		testHero.attack(testMonster);
		testMonster.attack(testHero);
		testHero.attack(testMonster);
		if(testMonster.isStillAlive()!=false)
		{
			result = false;
		}
		if(testHero.isStillAlive()!=true)
		{
			result = false;
		}


		return result;
	}

	public static void main(String[] args) {
		// Perform unitTests first
		if(unitTests()) {
			System.out.println("All unit tests passed.");
		} else {
			System.out.println("Failed test.\n");
			return;
		}
		
		Tower tower = setUpTower();
		Hero hero = new Hero("CSE_8B_Hero", 10, 3, 3, 4, new Item("Small Knife"));
		playGame(hero, tower);
	}
}
