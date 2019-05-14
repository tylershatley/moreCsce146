public class GenLL <T>
{
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T xData, ListNode xLink)
		{
			data = xData;
			link = xLink; //link points to new link. Points to something else
		}
	}
	
	private ListNode head; //point to the first item in the list
	private ListNode curr;// current nde of interest
	private ListNode prev;//one node behind current
	
	public GenLL()
	{
		head = curr = prev = null;
	}
	
	public void insert(T xData) // Inserts at the end of the list
	{
		ListNode newNode = new ListNode(xData,null);
		if(head == null)//The list is empty
		{
			head = newNode;
			curr = head;// curr = new node
			return;
		}
		ListNode temp = head;
		
		while(temp.link != null)
			temp = temp.link;
		temp.link = newNode;
	}
	
	public void deleteCurrent()
	{
		if(curr != null && prev != null)//means its pointing to anything but the head
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null)//means prev is = to null. cut off the head
		{
			head = head.link;
		}
	}
	
	public T getCurrent()
	{
		if(curr != null)
			return curr.data;
		return null;
	}
	public void setCurrent(T xData)
	{
		if(curr != null)
			curr.data = xData;
	}
	
	public void gotoNext()
	{
		if(curr == null)
			return;
		prev = curr;
		curr = curr.link;
	}
	
	public void gotoBack()
	{
		if(prev != null)
			curr = prev;
			prev = prev.link;
	}
	
	public void moveToHead() 
	{
		curr = head;
	}
	
	
	public boolean hasMore()
	{
		return curr != null; 
	}
	
	public void print()
	{
		for(ListNode temp = head; temp != null; temp = temp.link)
		{
			System.out.println(temp.data);
		}
		System.out.println();
	}
}