package laboonsoft.player;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
	public List<Item> items;

	public Inventory()
	{
		items = new ArrayList<Item>();
	}

	public boolean addItem(Item item)
	{
		if (!items.contains(item))
		{
			items.add(item);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean hasCream()
	{
		return items.contains(new Item(Item.Type.CREAM));
	}

	public boolean hasSugar()
	{
		return items.contains(new Item(Item.Type.SUGAR));
	}

	public boolean hasCoffee()
	{
		return items.contains(new Item(Item.Type.COFFEE));
	}

	public boolean hasNone()
	{
		return !hasCream() && !hasSugar() && !hasCoffee();
	}

	public boolean hasAll()
	{
		return hasCream() && hasSugar() && hasCoffee();
	}
}
