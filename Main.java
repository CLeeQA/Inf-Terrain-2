
package infTerrSim;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static String diffChoice;
	public static int goalCount;

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

		System.out.println("What do you want to do?");
		System.out.println("1. Head North");
		System.out.println("2. Head East");
		System.out.println("3. Head West");
		System.out.println("4. Head South");
		System.out.println("5. Check Compass");
		System.out.println("6. Look around");

	}

	public static String difficulty() {

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

		return diffChoice;
	}

	public static void goalCountTracker() {

		if (diffChoice == "Easy") {
			goalCount = 1;
		}

		if (diffChoice == "Medium") {
			goalCount = 3;
		}

		if (diffChoice == "Hard") {
			goalCount = 5;
		}

	}

	public void tileType() {

		Random rand = new Random();
		int tile = rand.nextInt(5) + 1;

	}

}
