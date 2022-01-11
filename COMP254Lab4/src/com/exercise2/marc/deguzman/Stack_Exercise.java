package com.exercise2.marc.deguzman;

import java.util.Stack;

public class Stack_Exercise {
	/*
	 * Student Number: 301171014
	 * Full Name: Marc Louis Gene A. De Guzman
	 */
	public static void main(String[] args) {
		Stack<String> stringStack = new Stack<String>(); // create Stack of String
		Stack<Integer> intStack = new Stack<Integer>(); // create Stack of Integer
		
		// populate the stack
		stringStack.push("pineapple");
		stringStack.push("orange");
		stringStack.push("mango");
		stringStack.push("grapes");
		
		intStack.push(500);
		intStack.push(400);
		intStack.push(300);
		intStack.push(200);
		
		System.out.println("string stack: " + stringStack);
		
		// remove all items via the recursive pop method
		popAllRecursive(stringStack);
		System.out.println("string stack after calling popAllRecursive : " + stringStack);
		
		System.out.println("int stack: " + intStack);
		
		// remove all items via the recursive pop method
		popAllRecursive(intStack);
		System.out.println("int stack after calling popAllRecursive : " + intStack);
	}
	
	// remove elements of a given stack recursively
	public static <E> void popAllRecursive(Stack<E> stack) {
		// nothing to do if the stack is already empty
		if (stack.isEmpty()) {
			return;
		}
		
		stack.pop(); // remove the top element
		
		popAllRecursive(stack); // remove elements recursively
	}
}
