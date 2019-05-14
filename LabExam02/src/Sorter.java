/*
 * Tyler Shatley
 * csce 146
 */
public class Sorter{
	
	public static void bubbleSort(Cylinder[] a)
	{
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < a.length -1; i++)
			{
				if(a[i].getVolume() > a[i+1].getVolume())
				{
					Cylinder temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
	}
	
	public static void mergeSort(Cylinder[] a)
	{
		int size = a.length;
		if(size < 2)
			return;
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		Cylinder [] left = new Cylinder[leftSize];
		Cylinder [] right = new Cylinder[rightSize];
		
		for(int i = 0; i < leftSize; i++)
			left[i] = a[i];
		
		for(int i = mid; i < size; i++)
			right[i-mid] = a[i];
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,a);
	}
	
	public static void merge(Cylinder [] left, Cylinder [] right, Cylinder[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//left index
		int j = 0; //right index
		int k = 0; //a index
	
		while(i < leftSize && j < rightSize)
		{
			if(left[i].getVolume() <= right[j].getVolume())
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i < leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	private static Cylinder[] heap;
	public static final int DEF_SIZE = 128;
	private static int lastIndex;
	
	public Sorter(int size)
	{
		init(size);
	}
	
	private void init(int size)
	{
		if(size <= 0)
			return;
		heap = (Cylinder[])(new Comparable[size]);
	}
	
	public void addCylinder(Cylinder aData) //insert a new sheep
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
			Cylinder temp = heap[pIndex(index)];
			heap[(pIndex(index))] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	
	private int pIndex(int index)//Easier for a test,so you dont have to do it in a different method...look above
	{
		return (index-1)/2;
	}
	
	
	public Cylinder peek() //peek returns the current data? Which is sheep
	{
		return heap[0];
	}
	
	
	public Cylinder removeCylinder() //method that deletes the sheep
	{
		Cylinder retVal = heap[0];//return value is the root
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
				Cylinder temp = heap[index];
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
	
	
	public static void heapSort(Cylinder [] a)
	{
		Sorter temp = new Sorter(heap.length);
		Cylinder cloner[] = heap.clone(); //
		
		//adding info to tempSheepHeap
		for(int i = 0; i < lastIndex; i++)
		{
			temp.addCylinder(cloner[i]);
		}
		
		for(int i = 0; i < lastIndex-1; i++)
		{
			temp.removeCylinder();
		}
	}
	public class sorter2 
}


