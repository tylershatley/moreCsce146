/*
 * Tyler Shatley
 */
public class ProcessHeap <Process extends Comparable<Process>>{
	
	private Process[] heap;
	private int size;//points to the first null element
	public static final int DEF_SIZE = 128;
	public ProcessHeap(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			return;
		heap = (Process[])(new Comparable[size]);
		size = 0;
	}
		
	public void insert(Process aData)
	{
		if(size >= heap.length)
			return;//heap is full
		heap[size] = aData;
		bubbleUp();
		size++;
	} 
	private void bubbleUp()
	{
		int index = size;//start from newly added item
		while(index > 0 &&
				heap[pIndex(index)].compareTo(heap[index]) < 0)
		{
			//swap
			Process temp = heap[pIndex(index)];
			heap[pIndex(index)] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	
	private int pIndex(int index)
	{
		return (index-1)/2;
	}
	
	private int rIndex(int index)
	{
		return (index*2)+2;
	}
	
	private int lIndex(int index)
	{
		return (index*2)+1;
	}
	
	public Process peek()
	{
		return heap[0];
	}
	
	public Process remove() //method that deletes the sheep
	{
		Process retVal = heap[0];//return value is the root
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		climbDown();
		return retVal;
	}
	
	public void climbDown()
	{
		int index = 0;
		while(lIndex(index) < size)//While we have a left child 
		{
			//Assume the left is larger
			int bigIndex = lIndex(index);
			//Confirm that it is
			if(rIndex(index) < size &&
					heap[lIndex(index)].compareTo(heap[rIndex(index)]) < 0)
				bigIndex = rIndex(index);
			//check if parent is larger than child
			if(heap[index].compareTo(heap[bigIndex]) < 0)
			{
				//if not swap
				Process temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;//parent was larger than both children
			index = bigIndex;
		}
	}
	
	
	public void printHeap()
	{
		for(int i = 0; i< size; i++)
			System.out.println(heap[i].toString());
	}
	
	public void heapSort()
	{
		//creating a new instance so when it does sort & print it doesnt affect the original heap
		ProcessHeap PH = new ProcessHeap(heap.length);
		Process cloner[] = heap.clone(); //
		
		//adding info to tempSheepHeap
		for(int i = 0; i < size; i++)
		{
			PH.insert(cloner[i]);
		}
		
		for(int i = 0; i < size-1; i++)
		{
			System.out.println(PH.remove().toString());
		}
	}
	
	public boolean isEmpty()
	{
		if(peek() != null)
		{
			return false;
		}
		else
		{
			return true;
		}
			
	}
	
	
}

