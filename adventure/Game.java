import java.util.Random;
import java.util.Scanner;

public class Game {
	
	//TODO: add printf statements, hashmap, switch statments, 
	
	public static void main(String[] args) {
		
		//System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variable
		String[] enemies = { "A Skeleton", "A Zombie", "A Warrior", "An Assassin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		//Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50;
		
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon!");
		
		GAME:
		while (running) {
			System.out.println("------------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[ rand.nextInt(enemies.length) ];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour power: " + health);
				System.out.println("\t" + enemy + "'s power: " + enemyHealth);
				System.out.println("\n\t What would you like to do?");
				System.out.println("\t 1. Attack");
				System.out.println("\t 2. Drink health potion");
				System.out.println("\t 3. Run!");
				
				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t > You struck the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t > You received " + damageTaken + " in retaliation!");
					if (health < 1) {
						System.out.println("\t > You've taken too much damage..too weak to go on!");
						break;
					}
					
				} else if (input.equals("2")) {
					if (numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t > You drank a health potion, healing yourself for " + healthPotionHealAmount + "."
											+ "\n\t > You now have " + health + " in power."
											+ "\n\t > You have " + numHealthPotions + " health potions left. \n");
					} else {
						System.out.println("\t > You have no health potions left! Defeat enemies for a chance to get one! \n");
					}
					
				} else if (input.equals("3")) {
						System.out.println("\t You ran away from " + enemy + "!");
						continue GAME;
				} else {
						System.out.println("\t Invalid Command!");
				}
			}
			
			if (health < 1) {
				System.out.println("You're limping out of the dungeon, too weak from battle.");
				break;
			} 
			
			System.out.println("------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" #  You have " + health + " in power left.  # ");
			if ( rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");
			
			String input = in.nextLine();
			
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid Command!");
				input = in.nextLine();
			}
			
			if (input.equals("1")) {
				System.out.println("Continue on your adventure!");
			} else if (input.equals("2")) {
				System.out.println("You're exiting the dungeon, successful from your adventures!");
				break;
			}
		}
		System.out.println("########################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("########################");
	}
}




























