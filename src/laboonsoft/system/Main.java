package laboonsoft.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import laboonsoft.player.Inventory;
import laboonsoft.player.Item;

public class Main
{
	public enum Outcome
	{
		WIN, LOSE, CONTINUE
	};

	final static String COFFEE_ASCII_PATH = "coffee_ascii.txt";
	static Room currentRoom = null;

	public static void main(String[] args)
	{

		// TODO Auto-generated method stub
		File asciiFile;
		FileInputStream asciiStream = null;
		asciiFile = new File(COFFEE_ASCII_PATH);
		try
		{
			asciiStream = new FileInputStream(asciiFile);
		}
		catch (FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
			System.out.println("Couldn't find ascii file.");
			System.exit(-1);
		}

		byte[] asciiData = new byte[(int) asciiFile.length()];
		try
		{
			asciiStream.read(asciiData);
			asciiStream.close();
			// the new line characters are escaped when they're read in
			// so we'll un-escape them
			System.out.println(
					new String(asciiData, "UTF-8").replace("\\n", "\n"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error reading from file");
			System.exit(-1);
		}
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine(); // wait for enter key
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		Inventory inventory = new Inventory();
		List<Room> rooms = World.getGameRooms(new Random());
		currentRoom = rooms.get(0);

		Outcome outcome = Outcome.CONTINUE;
		System.out.println(
				"Wow, you have to study, but first you must drink a hot coffee beverage.");
		System.out.println(currentRoom.toString()); // print the initial
													// description
		while (outcome == Outcome.CONTINUE)
		{
			String input = scanner.nextLine().toUpperCase();
			outcome = iterate(currentRoom, input, inventory);
		}
		scanner.close();
		System.exit(0);
	}

	/**
	 * Play one iteration of the game
	 * 
	 * @return whether or not you win the game
	 */
	public static Outcome iterate(Room currentRoom, String input,
			Inventory inventory)
	{
		System.out.println(currentRoom.toString());
		if (input.equalsIgnoreCase("S"))
		{
			if (currentRoom.goSouth() != null)
			{
				Main.currentRoom = currentRoom.goSouth();
				System.out.println("You head south.");

				System.out.println(Main.currentRoom.toString());
			}
			else
			{
				System.out.println("There is no door to the south.");
			}
		}
		else if (input.equalsIgnoreCase("H"))
		{
			System.out.println("Coffee quest help: \n"
					+ "S: South (head south from the current room, if possible)\n"
					+ "H : Help"
					+ "L: Look (search for items in the current room\n"
					+ "I: Inventory (list currently held items)\n"
					+ "N: North (head north from the current room, if possible)\n"
					+ "D: Drink \n" + "It's easy, just remember: Shlind. \n");
		}
		else if (input.equalsIgnoreCase("L"))
		{
			System.out.println("You look around the room...");
			Item foundItem = currentRoom.search();
			if (foundItem == null)
			{
				System.out.println("But you didn't find anything.");
			}
			else
			{
				System.out.println(
						"You found some " + foundItem.type.toString() + " ! ");
				inventory.addItem(foundItem);
			}

		}
		else if (input.equalsIgnoreCase("I"))
		{
			if (inventory.hasNone())
			{
				System.out.println("You have nothing! ");
			}
			if (inventory.hasCoffee())
			{
				System.out.println("You've got coffee! ");
			}
			if (inventory.hasCream())
			{
				System.out.println("You've got some creamy cream!");
			}
			if (inventory.hasSugar())
			{
				System.out.println("You've got some sweet sugar!");
			}
		}
		else if (input.equalsIgnoreCase("N"))
		{
			if (currentRoom.goNorth() != null)
			{
				System.out.println("You head north.");

				Main.currentRoom = currentRoom.goNorth();
				System.out.println(Main.currentRoom.toString());
			}
			else
			{
				System.out.println("There is no door to the north.");
			}
		}
		else if (input.equalsIgnoreCase("D"))
		{
			if (inventory.hasAll())
			{
				System.out.println(
						"You drink the sweet, creamy coffee. You can study now. ");
				return Outcome.WIN;
			}
			else if (inventory.hasNone())
			{
				System.out.println(
						"You drank the nothing. You lose. You fail your classes.");

			}
			else
			{
				// the player has at least one item

				System.out.println(
						"You drank what you had. It wasn't enough to help you study. You fail your classes.");
			}
			return Outcome.LOSE;
		}
		else
		{
			// Unknown command
			System.out.println("What?");
		}
		// they only win if they drink even if they have all items
		return Outcome.CONTINUE;
	}
}
