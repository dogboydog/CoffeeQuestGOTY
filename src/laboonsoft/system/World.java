package laboonsoft.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import laboonsoft.player.Inventory;
import laboonsoft.player.Item;

//represents the physical world of the game
public class World
{

	// this returns a list of rooms that will satisfy the
	// requirements of the game. It also sets up the doors
	// between the rooms
	public static List<Room> getGameRooms(Random random)
	{
		List<Room> rooms = new ArrayList<Room>();

		Room r1 = new Room(Descriptions.getAdjective(random),
				Descriptions.getFurnishing(random));
		Room r2 = new Room(Descriptions.getAdjective(random),
				Descriptions.getFurnishing(random));
		r2.setSouthRoom(r1);
		r1.setNorthRoom(r2);

		Room r3 = new Room(Descriptions.getAdjective(random),
				Descriptions.getFurnishing(random));
		r3.setSouthRoom(r2);
		r2.setNorthRoom(r3);
		Room r4 = new Room(Descriptions.getAdjective(random),
				Descriptions.getFurnishing(random));
		r4.setSouthRoom(r3);
		r3.setNorthRoom(r4);

		Room r5 = new Room(Descriptions.getAdjective(random),
				Descriptions.getFurnishing(random));
		r5.setSouthRoom(r4);
		r4.setNorthRoom(r5);
		// r1's south and r4's north should be null
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		rooms.add(r5);

		// choose the rooms that the items will be in
		int coffeeRoomNumber = random.nextInt(rooms.size());

		int creamRoomNumber = random.nextInt(rooms.size());
		while (coffeeRoomNumber == creamRoomNumber)
		{
			creamRoomNumber = random.nextInt(rooms.size());
		}

		int sugarRoomNumber = random.nextInt(rooms.size());
		while (sugarRoomNumber == creamRoomNumber
				|| sugarRoomNumber == coffeeRoomNumber)
		{
			sugarRoomNumber = random.nextInt(rooms.size());
		}
		rooms.get(coffeeRoomNumber).addItem(Item.Type.COFFEE);
		rooms.get(creamRoomNumber).addItem(Item.Type.CREAM);
		rooms.get(sugarRoomNumber).addItem(Item.Type.SUGAR);

		return rooms;
	}

	public static boolean checkWin(Inventory inventory)
	{
		return inventory.hasAll();
	}

}
