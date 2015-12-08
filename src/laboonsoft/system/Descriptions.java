/**
 * 
 */
package laboonsoft.system;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Descriptions
{
	public static final String[] adjectives = { "zany", "awful", "dusty",
			"unassuming", "bright", "ghoulish", "putrescent", "gormless",
			"half-baked", "melty", "small", "bourgeois", "insignificant",
			"lonely", "tasty" };
	public static final String[] furnishings = { "an incredible chair",
			"a light-absorbing lamp", "a chair named Tracy",
			"some kind of thing",
			"a human skeleton that looks really disappointed" };

	public static String nonUniqueError = "NON-UNIQUE";
	static Set<String> usedAdjectives = new HashSet<String>();
	static Set<String> usedFurnishings = new HashSet<String>();
	static int adjectivesGenerated = 0;
	static int furnishingsGenerated = 0;

	public static String getAdjective(Random random)
	{
		boolean adjectiveChosen = false;
		String adj = null;
		while (!adjectiveChosen)
		{
			adj = adjectives[random.nextInt(adjectives.length)];
			if (usedAdjectives.add(adj))
			{
				// if this was a new adjective, we can quit
				// otherwise we'll go through the loop again
				adjectiveChosen = true;
			}
			else
			{
				if (adjectivesGenerated > adjectives.length)
				{
					// we ran out of adjectives
					adj = nonUniqueError;
					break;
				}
			}

		}

		adjectivesGenerated++;
		return adj;
	}

	public static String getFurnishing(Random random)
	{
		boolean furnishingChosen = false;
		String furn = null;
		while (!furnishingChosen)
		{
			furn = furnishings[random.nextInt(furnishings.length)];
			if (usedFurnishings.add(furn))
			{
				// if this was a new furnishing, we can quit
				// otherwise we'll go through the loop again
				furnishingChosen = true;
			}
			else
			{
				if (furnishingsGenerated > furnishings.length)
				{
					// we ran out of furnishings
					furn = nonUniqueError;
					break;
				}
			}

		}

		furnishingsGenerated++;
		return furn;
	}
}
