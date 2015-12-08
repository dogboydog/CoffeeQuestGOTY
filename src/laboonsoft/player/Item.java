package laboonsoft.player;

public class Item
{
	public enum Type
	{
		COFFEE, CREAM, SUGAR
	};

	public Type type;

	public Item(Type type)
	{
		this.type = type;
	}

	// items are considered the same if they 
	// are of the same item type 
	// e.g. cream == cream 
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Item))
		{
			return false;
		}
		else
		{
			return type == ((Item) other).type;
		}
	}

	@Override
	public String toString()
	{
		return type.toString();
	}
}
