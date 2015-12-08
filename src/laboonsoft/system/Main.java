package laboonsoft.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
	final static String COFFEE_ASCII_PATH = "coffee_ascii.txt";

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

		scanner.close();
		System.exit(0);
	}

	public static int iterate()
	{
		return 1;
	}
}
