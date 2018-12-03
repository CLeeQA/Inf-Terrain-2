
package infTerrSim;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static String diffChoice;
	public static int goalCount;
	public static String tileType;
	public static String optionChoice;
	public static int playerX;
	public static int playerY;
	public static int goalX;
	public static int goalY;
	public static double goalDis;
	public static boolean gameEnd = false;

	public static void main(String[] args) {

		Main.difficulty();

		Main.goalCountTracker();

		System.out.println(
				"You feel the boat below you jolt as you pull up onto the shore of the small island. The small gruff ferryman turns to you and nods for you to get off. His lips showing no signs of opening. You thank him anyway and climb out of");
		System.out.println(
				"the boat, your feet hitting the sand of the shore below you. The trees of the island are black and gloomy, not a single green leaf in sight. A shiver of both nervousness and excitement runs down your spine as you take the first ");
		System.out.println("steps towards the treasure that you heard about in the tavern tales.");
		System.out.println("");
		System.out.println(
				"Suddenly, you feel something hard hit the back of your head, forcing you to your knees. You feel your vision start to darken. Just before you pass out, you manage to turn your head, just in time to see a hooded figure behind you.");
		System.out.println("");
		System.out.println(
				"You wake up to the feeling of cold and wet mud below your body. You push yourself to your feet, bringing a hand to the back of your head, which still aches from the blow it took previously. As your eyes adjust to the darkness,");
		System.out.println(" you start to piece together your surroundings.");
		System.out.println("");
		System.out.println(
				"You're in the middle of what appears to be a swamp that extends for as far as the eye can see in all directions. You notice a small compass in your palm, it's hand pointing off in random directions. With nothing left to do, you ");
		System.out.println("decide to set out.");

		Main.goalPlacer();

		Main.options();

		Main.endGame();

	}

	public static void difficulty() {

		Boolean playerHappy = false;

		while (playerHappy == false) {

			System.out.println("Please choose a difficulty:");
			System.out.println("Easy");
			System.out.println("Medium");
			System.out.println("Hard");

			Scanner s = new Scanner(System.in);
			diffChoice = s.nextLine();

			System.out.println("You have chosen " + diffChoice + ". Are you happy with this?");
			System.out.println("Yes");
			System.out.println("No");

			Scanner t = new Scanner(System.in);
			String happyChoice = t.nextLine();

			if (happyChoice.equals("Yes")) {
				playerHappy = true;
			}

		}
	}

	public static void goalCountTracker() {

		if (diffChoice.equals("Easy")) {
			goalCount = 1;
		}

		if (diffChoice.equals("Medium")) {
			goalCount = 3;
		}

		if (diffChoice.equals("Hard")) {
			goalCount = 5;
		}

	}

	public static void tile() {

		if (diffChoice.equals("Easy")) {

			Random rand = new Random();
			int tile = rand.nextInt(5) + 1;

			if (tile == 1) {
				tileType = "Normal";
			}

			if (tile == 2) {
				tileType = "Tree";
			}

			if (tile == 3) {
				tileType = "Mud";
			}

			if (tile == 4) {
				tileType = "Monster";
			}

			if (tile == 5) {
				tileType = "Item";
			}

		}

		if (diffChoice.equals("Medium")) {

			Random rand = new Random();
			int tile = rand.nextInt(10) + 1;

			if (tile >= 1 && tile <= 2) {
				tileType = "Normal";
			}

			if (tile >= 3 && tile <= 4) {
				tileType = "Tree";
			}

			if (tile >= 5 && tile <= 6) {
				tileType = "Mud";
			}

			if (tile >= 7 && tile <= 9) {
				tileType = "Monster";
			}

			if (tile == 10) {
				tileType = "Item";
			}
		}

		if (diffChoice.equals("Hard")) {

			Random rand = new Random();
			int tile = rand.nextInt(20) + 1;

			if (tile >= 1 && tile <= 4) {
				tileType = "Normal";
			}

			if (tile >= 5 && tile <= 8) {
				tileType = "Tree";
			}

			if (tile >= 9 && tile <= 12) {
				tileType = "Mud";
			}

			if (tile >= 13 && tile <= 19) {
				tileType = "Monster";
			}

			if (tile == 20) {
				tileType = "Item";
			}

		}

	}

	public static void options() {

		while (gameEnd == false) {

			System.out.println("What do you want to do?");
			System.out.println("North");
			System.out.println("East");
			System.out.println("South");
			System.out.println("West");
			System.out.println("Check");
			System.out.println("Look");
			System.out.println("Help");

			Scanner s = new Scanner(System.in);
			optionChoice = s.nextLine();

			if (optionChoice.equals("Help")) {

				String helpDone = "Not Done";

				while (helpDone.equals("Not Done")) {

					System.out.println("Choose \"North\" to go North.");
					System.out.println("Choose \"East\" to go East.");
					System.out.println("Choose \"South\" to go South.");
					System.out.println("Choose \"West\" to go West.");
					System.out.println(
							"Choose \"Check\" to check the compass and figure out how close you are to the nearest goal.");
					System.out
							.println("Choose \"Look\" to go look around and get a description of the tile you're on.");
					System.out.println("Enter \"Done\" to return to the options menu:");

					Scanner t = new Scanner(System.in);
					helpDone = t.nextLine();

				}

			}

			if (optionChoice.equals("Check")) {
				System.out.println(Main.compass());
			}

			else if (optionChoice.equals("Look")) {
				Main.checkTile();
			}

			else if (optionChoice.equals("North") | optionChoice.equals("South") | optionChoice.equals("East")
					| optionChoice.equals("West")) {
				Main.moveTile();
			}

			else {
				System.out.println("That isn't a valid input, please enter one of the options.");

			}

		}

	}

	public static void goalPlacer() {

		if (goalCount > 0) {

			Random rand = new Random();

			goalX = playerX + (rand.nextInt(10) - 5);
			goalY = playerY + (rand.nextInt(10) - 5);

		}

	}

	public static String compass() {

		boolean posX = false;
		boolean posY = false;
		boolean sameX = false;
		boolean sameY = false;
		int xDis = 0;
		int yDis = 0;

		if (goalX > playerX) {
			posX = true;
		}

		if (goalY > playerY) {
			posY = true;
		}

		if (goalX == playerX) {
			sameX = true;
		}

		if (goalY == playerY) {
			sameY = true;
		}

		if (posX == true && posY == true) {
			xDis = goalX - playerX;
			yDis = goalY - playerY;
		}

		if (posX == true && posY == false) {
			xDis = goalX - playerX;
			yDis = playerY - goalY;
		}

		if (posX == false && posY == true) {
			xDis = playerX - goalX;
			yDis = goalY - playerY;
		}

		if (posX == false && posY == false) {
			xDis = playerX - goalX;
			yDis = playerY - goalY;
		}

		if (sameX == true) {
			xDis = 0;
		}

		if (sameY == true) {
			yDis = 0;
		}

		goalDis = Math.sqrt((xDis * xDis) + (yDis * yDis));

		return "You are " + goalDis + " metres away from the next goal.";

	}

	public static void moveTile() {

		if (optionChoice.equals("North")) {

			playerY = playerY + 1;

			Main.tile();

		}

		if (optionChoice.equals("East")) {

			playerX = playerX + 1;

			Main.tile();

		}

		if (optionChoice.equals("West")) {

			playerX = playerX - 1;

			Main.tile();

		}

		if (optionChoice.equals("South")) {

			playerY = playerY - 1;

			Main.tile();

		}

	}

	public static void checkTile() {

		if (playerX == goalX && playerY == goalY) {

			System.out.println(
					"You notice a small treasure chest sitting on a raised platform. It's wood looks weathered and old, but not so bad that it might fall apart. You take a few steps over to it and reach out towards it.");
			System.out.println(
					"The chest opens easily, it's hinges creaking slightly. Inside is a small blue gem that seems to give off a little light.");
			System.out.println("You've gained a power crystal.");

			goalCount = goalCount - 1;

			if (goalCount == 0) {

				gameEnd = true;

			}

		}

		if (playerX == 0 && playerY == 0) {

			System.out.println("You're at the start.");

		}

		else if (tileType.equals("Normal")) {

			System.out.println("Normal");

		}

		else if (tileType.equals("Tree")) {

			System.out.println("Tree");

		}

		else if (tileType.equals("Mud")) {

			System.out.println("Mud");

		}

		else if (tileType.equals("Monster")) {

			System.out.println("Monster");

		}

		else if (tileType.equals("Item")) {

			System.out.println("Item");

		}

	}

	public static void endGame() {
		System.out.print("You have won!");
	}

}
