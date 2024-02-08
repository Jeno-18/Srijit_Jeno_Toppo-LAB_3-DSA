package com.greatlearning.LabSession3.Question1;

import java.util.*;

public class BalancingBrackets {

	static Stack<Character> stack=new Stack<>();
	
	public static void main(String[] args) 
	{
		Scanner x=new Scanner(System.in);
		System.out.println("Enter an expression");
		
		String input=x.next();
		
		BalancingBrackets vob=new BalancingBrackets();
		
		boolean validity=vob.checkValidity(input);
			
		if(validity)
		   System.out.println("The entered String has Balanced Brackets");
		else
		   System.out.println("The entered Strings do not contain Balanced Brackets");

		x.close();
	}
	
	
	
	Boolean checkValidity(String expression)
	{
		for (int i=0; i<expression.length(); i++)
		{
			char ch=expression.charAt(i);
			
			if(ch=='(' || ch=='{' || ch=='[')
			{
				stack.push(ch);
				continue;
			}
			
			if(!stack.empty()) {       //for checking invalid brackets in the middle of the given expression
			if(ch==')' || ch=='}' || ch==']')
			{
				char check=stack.pop();
				if((check=='(' && ch==')') || (check=='{' && ch=='}') || (check=='[' && ch==']'))
				{
					continue;
				}
				else
				{
					return false;
				}
			}
		  }
			
			if((ch==')' || ch=='}' || ch==']') && stack.empty())    //for checking if there are any invalid EXTRA brackets after the expression
			return false;
			
	}
		
		return stack.empty();
	}

}
