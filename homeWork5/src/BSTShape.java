/*
 * Tyler Shatley
 * csce146
 * homework05
 */
public class BSTShape <T extends Shape>{
		
		private class Node
		{
			private Shape data;
			private Node leftChild; //Left child is always less than data 
			private Node rightChild;//Right child is always greater than data
			
			public Node(Shape aData)
			{
				data = aData;
				leftChild = rightChild = null;
			}
		}
		
		private Node root;
		
		public BSTShape()
		{
			root = null;
		}
		
		public void insert(Shape aData)
		{
			if(root == null)
				root = new Node(aData);
			else
				insert(root,aData);
		}
		
		private Node insert(Node aNode, Shape aData)
		{
			if(aNode ==  null)//we found a leaf
				aNode = new Node(aData);
			else if(aNode.data.getArea() > aData.getArea())//go left
				aNode.leftChild = insert(aNode.leftChild,aData);
			else if(aNode.data.getArea() < aData.getArea()) //go right
				aNode.rightChild = insert(aNode.rightChild,aData);
			return aNode;
		}
		
		public void delete(T aData)
		{
			root = delete(root,aData);
		}
		
		private Node delete(Node aNode, Shape aData)
		{
			//find the value
			if(aNode.data.getArea() > aData.getArea())//go left
				aNode.leftChild = delete(aNode.leftChild,aData);
		else if(aNode.data.getArea() < aData.getArea())//go right
			aNode.rightChild = delete(aNode.rightChild,aData);
			else//we found it
			{
				//either no children or only left child
				if(aNode.rightChild == null)
					return aNode.leftChild;
				if(aNode.leftChild == null)//only right child
					return aNode.rightChild;
				//if we reach here, it has two children
				Node temp = findMinEntry(aNode.rightChild);
				//delete duplicate
				aNode.rightChild = delete(aNode.rightChild,temp.data);	
			}
			return aNode;
		}
		
		public void deleteIF(double num)
		{
			while(getMax(root) >= num)
			{
				deleteIF(root,num);
			}
		}
		
		private Node deleteIF(Node aNode, double num)
		{
			if(aNode == null)
			{
				return null;
			}
			if(aNode.data.getArea() > num)
			{
				return aNode.leftChild;
			}
			else
			{
				aNode.rightChild = deleteIF(aNode.rightChild,num);
				return aNode;
			}
		}
		
		private Node findMinEntry(Node aNode)
		{
			if(aNode ==  null)
				return null;
			if(aNode.leftChild == null)
				return aNode;
			else
				return findMinEntry(aNode.leftChild);
		}
		
		public void printInOrder()
		{
			printInOrder(root);
		}
		
		private void printInOrder(Node aNode)
		{
			if(aNode == null)
				return;
			printInOrder(aNode.leftChild);//recursive left
			System.out.println(aNode.data);//process
			printInOrder(aNode.rightChild);//recursive right
		}
			
		public void printPreOrder()
		{
			printPreOrder(root);
		}
		
		private void printPreOrder(Node aNode)
		{
			if(aNode == null)
				return;
			System.out.println(aNode.data);//Process
			
			if(aNode.leftChild != null)//LEFT
				printPreOrder(aNode.leftChild);
			if(aNode.rightChild != null)//RIGHT
				printPreOrder(aNode.rightChild);
		}
		
		
		public void printPostOrder()
		{
			printPostOrder(root);
		}
		
		private void printPostOrder(Node aNode)
		{
			if(aNode == null)//found a leaf
			{
				return;
			}
			
			printPostOrder(aNode.leftChild);
			printPostOrder(aNode.rightChild);
			System.out.println(aNode.data);
		}
		
		public double getMax()
		{
			return getMax(root);
		}
		
		private double getMax(Node aNode)
		{
			if(aNode.rightChild == null)
			{
				return aNode.data.getArea();
			}
			else
			{
				return getMax(aNode.rightChild);
			}
		}
	}

