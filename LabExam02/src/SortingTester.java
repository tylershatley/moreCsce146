import java.util.*;
public class SortingTester {

	public static void main(String[] args) {
		System.out.println("Cylinder Sorter!");
		
		Cylinder[] org = makeArray();
		Cylinder[] a = org.clone();
		long beforeTime = System.currentTimeMillis();
		Sorter.bubbleSort(a);
		long afterTime = System.currentTimeMillis();
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for bubble sort");
		
		a = org.clone();
		beforeTime = System.currentTimeMillis();
		Sorter.mergeSort(a);
		afterTime = System.currentTimeMillis();
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for merge sort");
		
		a = org.clone();
		beforeTime = System.currentTimeMillis();
		Sorter.heapSort(a);
		afterTime = System.currentTimeMillis();		
		System.out.println("Sorted correctly? "+isSortedCorrectly(a));
		System.out.println("It took "+(afterTime-beforeTime)+"ms for heap sort");
		
		
	}
	//Checks to see if array a has been sorted correctly
	public static boolean isSortedCorrectly(Cylinder[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i].getVolume()>a[i+1].getVolume())
				return false;
		}
		return true;
	}
	//Creates an array of random cylinders
	public static Cylinder[] makeArray()
	{
		Cylinder[] a = new Cylinder[10000];//A big ole array
		Random r = new Random(100);//fixes the seed at 100
		for(int i=0;i<a.length;i++)
		{
			a[i] = makeRandomCylinder();//Makes a cylinder of a random dimension
		}
		return a;
	}
	//Creates a cylinder where the base radius and height are random
	static Random r = new Random(100);
	public static Cylinder makeRandomCylinder()
	{
		//nextDouble returns values from 0.0 to 1.0 this increases the range to 0.0 to 100.0
		return new Cylinder(r.nextDouble()*100.0,r.nextDouble()*100.0);
	}
}