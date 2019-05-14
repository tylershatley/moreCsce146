/*
 * Tyler Shatley
 * csce 146
 */
import java.util.*;
import java.io.*;
public class MainMethod {
public static final String DELIM = "\t";
	public static void main(String[] args) {
		
		BSTShape BST = new BSTShape();
		System.out.println("Welcome to the shape tree tester!");
		double side1 = 0;
		double side2 = 0;
		double radius = 0;
		
		try
		{
			Scanner fileScanner = new Scanner(new File("shapes.txt"));
			
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String [] splitLine = fileLine.split(DELIM);
				
				if(splitLine.length < 2 || splitLine.length > 4)
				{
					System.out.println("Improper format...");
					continue;
				}
				String type = splitLine[0];
				
				switch(type)
				{
				case "Rectangle": 
					Rectangle rect = new Rectangle();
					side1 = Double.parseDouble(splitLine[1]);
					side2 = Double.parseDouble(splitLine[2]);
					rect = new Rectangle(type,side1,side2);
					BST.insert(rect);
					break;
				case "Right Triangle":
					RightTriangle RT = new RightTriangle();
					side1 = Double.parseDouble(splitLine[1]);
					side2 = Double.parseDouble(splitLine[2]);
					RT = new RightTriangle(type,side1,side2);
					BST.insert(RT);
					break;
				case "Circle":
					Circle circle = new Circle();
					radius = Double.parseDouble(splitLine[1]);
					circle = new Circle(type,radius);
					BST.insert(circle);
					break;
				}
				System.out.println(fileLine);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("\nPrinting pre-order");
		BST.printPreOrder();
		
		System.out.println("\nPrinting in-order");
		BST.printInOrder();
		
		System.out.println("\nPrinting post-order");
		BST.printPostOrder();
		
		System.out.println("\nMax node");
		System.out.print(BST.getMax());
		
		System.out.println("\nDeleting values larger than 30\n");
		BST.deleteIF(30);
		System.out.println("Printing in-order");
		BST.printInOrder();
	}

}
