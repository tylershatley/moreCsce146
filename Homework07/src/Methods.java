/*
 * Tyler Shatley
 */
import java.util.LinkedList;
import java.util.*;
import java.io.*;
public class Methods {

	GenLL <String> words = new GenLL<String>();
	GenLL<String>foundWord = new GenLL<String>();
	char [][] letters = new char[5][5];
	boolean [][] checkSpot = new boolean[5][5];
	
	public void populateArr(String fileName,char[][]a)//populates the 2d array "letters" by taking in a txt file.
	{
		try 
		{
			Scanner fileReader = new Scanner(new File(fileName));
			int i = 0;//i dont know why i did this? why in a while loop?
			
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				
				for(int j = 0; j < line.length(); j++)
				{
					a[i][j] = line.charAt(j);
				}
				
				for(int j = 0; j < line.length(); j++)
				{
					letters[i][j] = line.charAt(j);
				}
				i++;
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		for(int j = 0; j < 5; j++)
		{
			for(int k = 0; k < 5; k++)
			{
				System.out.print(letters[j][k]);
			}
			System.out.println();
		}
	}
	
	public void addWordFound(String str)//methods that adds a unique found word to the list
	{
		foundWord.insert(str);
	}
	
	public boolean duplicate(String str)//method that checks for duplicate words
	{
		foundWord.moveToHead();
		
		while(foundWord.hasMore())
		{
			if(str.equalsIgnoreCase(foundWord.getCurrent())) 
			{
				return true;
			}
			else
				foundWord.gotoNext();
		}
		return false;
	}
	
	public void populateWords(String fileName)//populates the linked list by reading in a txt file
	{
		try 
		{
			Scanner fileReader = new Scanner(new File(fileName));
			
			while(fileReader.hasNextLine())
			{
				String line = fileReader.nextLine();
				words.insert(line);
			}
			fileReader.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public boolean checkWord(String word)//boolean that checks for word matches
	{
		
		if(word.length() < 2)
			return false;
		
		
		words.moveToHead();
		
		
		while(words.hasMore())
		{
			if(word.equalsIgnoreCase(words.getCurrent()))
				return true;
			else
				words.gotoNext();
		}
		return false;
	}
	
	public String delete(String str)//method that removes the last invalid character of a string
	{
		if(str != null && str.length()> 0)
		{
			str = str.substring(0,str.length()-1);
		}
		else
		{
			str = str;
		}
		return str;
	}
	
	public void wordFinder(char[][] letters)//recursive method to find if words exist.
	{
		String str = new String();
		for(int i = 0; i < letters.length; i++)
		{
			for(int j = 0; j < letters.length; j++)
			{
				System.out.println("Started at " + "["+i+","+j+"]");
				strBuilder(letters,str,i,j, checkSpot);
			}
		}
	}
	
	private void strBuilder(char[][]letters, String str, int i, int j, boolean[][] checkSpot)//method that trys all combinations to build strings
	{
		checkSpot[i][j] = true;
		
		if(str.length() >= 7)//invalid size string
			return;
		
		str = str + letters[i][j];//adding a new character to the String
		
		if(checkWord(str) == true)
		{
			if(duplicate(str) == false)
			{
				System.out.println("Word Found! " + str);
				addWordFound(str);
			}
		}
		
		for(int y = i-1; y <= y+1 && y < 5; y++)
		{
			for(int x = j-1; x <= x+1 && x < 5; x++)
			{
				if(y >= 0 && x >= 0 && checkSpot[y][x] == false)
				{
					strBuilder(letters, str, y,x,checkSpot);
				}		
			}
		}
		
		delete(str);
		checkSpot[i][j] = false;
	}
}
	
