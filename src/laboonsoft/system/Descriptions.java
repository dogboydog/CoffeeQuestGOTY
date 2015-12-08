/**
 * 
 */
package laboonsoft.system;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Descriptions
{
	String[] adjectives = { "zany", "awful", "putrescent", "gormless",
			"half-baked", "melty", "small", "bourgeois", "insignificant",
			"lonely", "tasty" };
	String[] furnishings = { "an incredible chair", "a light-absorbing lamp",
			"a chair named Tracy", "some kind of thing",
			"a human skeleton that looks really disappointed" };
	Set<String> usedAdjectives = new HashSet<String>();
	Set<String> usedFurnishings = new HashSet<String>();

	public String getAdjective(Random random)
	{
		String adj = adjectives[random.nextInt(adjectives.length)];
		usedAdjectives.add(adj);
		return adj;
	}

	public String getFurnishing(Random random)
	{
		String furn = adjectives[random.nextInt(furnishings.length)];
		usedFurnishings.add(furn);
		return furn;
	}
}
