package laboonsoft.system;

import laboonsoft.player.Item;
import laboonsoft.player.Item.Type;

public class Room
{
	String adjective;
	String furnishing;

	Room northRoom = null;
	Room southRoom = null;
	Item item = null;

	public Room(String adj, String furn)
	{
		adjective = adj;
		furnishing = furn;
	}

	public void addItem(Type type)
	{
		this.item = new Item(type);
	}

	public Item search()
	{
		Item found = item;
		if (found != null)
		{
			// get rid of the item when the user finds it
			item = null;
		}
		return found;
	}

	public void setNorthRoom(Room north)
	{
		this.northRoom = north;
	}

	public void setSouthRoom(Room south)
	{
		this.southRoom = south;
	}

	public String toString()
	{
		return "You are in a " + adjective + " room with " + furnishing + ".";
	}

	public Room goNorth()
	{
		return northRoom;
	}

	public Room goSouth()
	{
		return southRoom;
	}

}
