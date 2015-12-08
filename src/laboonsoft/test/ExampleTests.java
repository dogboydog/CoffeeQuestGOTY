package laboonsoft.test;

import static org.junit.Assert.*;

import org.junit.Test;

import laboonsoft.player.Inventory;
import laboonsoft.player.Item;
import laboonsoft.system.Main;
import laboonsoft.system.Room;

public class ExampleTests
{
	// an iteration of the game should win if we
	// have all three items and enter "D"
	// no matter what room we're in
	@Test
	public void allThreeItemsShouldWinTest()
	{
		Room dummy = new Room("", "");
		Inventory inventory = new Inventory();
		inventory.addItem(new Item(Item.Type.COFFEE));

		inventory.addItem(new Item(Item.Type.CREAM));

		inventory.addItem(new Item(Item.Type.SUGAR));
		assertEquals(Main.iterate(dummy, "D", inventory), Main.Outcome.WIN);
	}

	// if the player has no items, they should
	// lose no matter what room they're in
	@Test
	public void noItemsShouldLoseTest()
	{
		Room dummy = new Room("", "");
		Inventory emptyInventory = new Inventory();
		assertEquals(Main.iterate(dummy, "D", emptyInventory),
				Main.Outcome.LOSE);
	}
}
