package com.exercise2.marc.deguzman;

import maps.*;

//Driver class for Exercise 2
public class Exercise2 {

	public static void main(String[] args) {
		UnsortedTableMap<String, String> aMap = new UnsortedTableMap<>();
		
		// Populate Map
		aMap.put("BigBang", "Sheldon Cooper");
		aMap.put("Friends", "Chandler Bing");
		aMap.put("Brooklyn99", "Jake Peralta");
		aMap.put("GreenArrow", "Oliver Queen");
		
		// Test containsKey
		System.out.println("containsKey of ('BigBang'): " + aMap.containsKey("BigBang"));
		System.out.println("containsKey of ('GreenArrow'): " + aMap.containsKey("GreenArrow"));
		
		// null key
		System.out.println("containsKey of ('Spartacus'): " + aMap.containsKey("Spartacus"));
	}
}
