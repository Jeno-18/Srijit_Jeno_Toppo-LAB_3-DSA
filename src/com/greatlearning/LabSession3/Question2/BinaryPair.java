package com.greatlearning.LabSession3.Question2;

import java.util.*;

public class BinaryPair 
{
	class Node
	{
		int data;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	static Node root;
	List<Integer> array=new ArrayList<>();
	
	Node insert(int value)      //Method to insert values into the Binary Search Tree
	{
		
		Node newNode=new Node(value);
		Node currentNode=root;
		Node prevNode=null;
		
		if(root==null)
		{
			return newNode;
		}
		
		while(currentNode!=null) {
		if(value<currentNode.data)
		{
			prevNode=currentNode;
			currentNode=currentNode.left;
		}
		else if(value>currentNode.data)
		{
			prevNode=currentNode;
			currentNode=currentNode.right;
		}
		else
		{
			System.out.println("Duplicate value");
			return root;
		}
		
	}

		if(value<prevNode.data)
		{
			prevNode.left=newNode;
			return root;
		}
		else
		{
			prevNode.right=newNode;
			return root;
		}

	}
	
	void displayInfix(Node tempRoot)    //Method to print the infix version of the Binary Search Tree
	{
		if(tempRoot==null)
			return;
		
		displayInfix(tempRoot.left);
		System.out.print(tempRoot.data+" ");
		array.add(tempRoot.data);
		displayInfix(tempRoot.right);
	}
	
	void findPair(int sum)      //Method to find the pair of the BST and display a message accordingly
	{
		int length=array.size();
		
		for(int i=0; i<length; i++)
		{
			int num=array.get(i);
			int diff=sum-num;
			
			for(int j=i+1; j<length; j++)
			{
				if(array.get(j)==diff)
				{
					System.out.println("Pair Found :"+"("+array.get(i)+","+array.get(j)+")");
					return;
				}
			}
		}
		System.out.println("Pair not Found");
	}
	

	public static void main(String[] args) {       //main Driver method of the Class
		BinaryPair BST=new BinaryPair();
		
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the sum of a number :");
		int sum=in.nextInt();
		
		while(true) {
		System.out.println("Enter element for the Binary Search Tree(Enter -1 to stop input) :");
		int x=in.nextInt();
		if(x==-1)
			break;
		root=BST.insert(x);
	}
		in.close();
		System.out.println("Binary Search Tree in infix is :");
		Node tempRoot=root;
		BST.displayInfix(tempRoot);
		System.out.println();
		BST.findPair(sum);

	}

}
