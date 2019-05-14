/*
 * Tyler Shatley
 * csce 146
 * homework 06
 */
public class SheepHeap <Sheep extends Comparable<Sheep>>{
	
	private Sheep[] heap;
	public static final int DEF_SIZE = 128;
	private int lastIndex;

	
	public SheepHeap(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			return;
		heap = (Sheep[])(new Comparable[size]);
	}

	public void addSheep(Sheep aData) //insert a new sheep
	{
		if(lastIndex >= heap.length)
			return; //heap is full
		heap[lastIndex] = aData; //add new sheep to bottom of the heapArr
		ClimbUp();//Climb up compares new data to its parent and swaps accordingly.
		lastIndex++; //increment the last index because it no longer exists? Not sure
	}
	
	private void ClimbUp()//Climb up compares new data that is added to the heap.
	{
		int index = lastIndex;
		while(index > 0 && 
				heap[pIndex(index)].compareTo(heap[index]) < 0)
		{
			//swap
			Sheep temp = heap[pIndex(index)];
			heap[(pIndex(index))] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	
	private int pIndex(int index)//Easier for a test,so you dont have to do it in a different method...look above
	{
		return (index-1)/2;
	}
	
	
	public Sheep peek() //peek returns the current data? Which is sheep
	{
		return heap[0];
	}
	
	public void sheepRollCall()//prints the array of sheep
	{
		for(int i = 0; i< lastIndex; i++)
			System.out.println(heap[i].toString());
	}
	
	public Sheep removeSheep() //method that deletes the sheep
	{
		Sheep retVal = heap[0];//return value is the root
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		climbDown();
		return retVal;
	}
	
	public void climbDown()
	{
		int index = 0;
		while(lIndex(index) < lastIndex)//While we have a left child 
		{
			//Assume the left is larger
			int bigIndex = lIndex(index);
			//Confirm that it is
			if(rIndex(index) < lastIndex &&
					heap[lIndex(index)].compareTo(heap[rIndex(index)]) < 0)
				bigIndex = rIndex(index);
			//check if parent is larger than child
			if(heap[index].compareTo(heap[bigIndex]) < 0)
			{
				//if not swap
				Sheep temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;//parent was larger than both children
			index = bigIndex;
		}
	}
	
	private int rIndex(int index)//right index
	{
		return (index*2+2);
	}
	
	private int lIndex(int index)//left index
	{
		return (index*2+1);
	}
	
	public void sheepHeapSort()
	{
		//creating a new instance so when it does sort & print it doesnt affect the original heap
		SheepHeap tempSheepHeap = new SheepHeap(heap.length);
		Sheep cloner[] = heap.clone(); //
		
		//adding info to tempSheepHeap
		for(int i = 0; i < lastIndex; i++)
		{
			tempSheepHeap.addSheep(cloner[i]);
		}
		
		for(int i = 0; i < lastIndex-1; i++)
		{
			System.out.println(tempSheepHeap.removeSheep().toString());
		}
	}	
}
