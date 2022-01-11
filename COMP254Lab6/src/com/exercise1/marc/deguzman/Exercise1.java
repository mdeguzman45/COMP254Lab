package com.exercise1.marc.deguzman;
import maps.*;

//Driver class for Exercise 1
public class Exercise1 {
	public static void main(String[] args) {
		ChainHashMap<Integer, String> mapWithPointFiveLoad = new ChainHashMap<Integer, String>(10, 0.5);
		
		mapWithPointFiveLoad.put(5, "AAA");
		mapWithPointFiveLoad.put(29, "BBB");
		mapWithPointFiveLoad.put(38, "CCC");
		mapWithPointFiveLoad.put(42, "DDD");
		mapWithPointFiveLoad.put(69, "EEE");
		
		// print original values first
		System.out.println("Printing original values:");
		for(Entry<Integer, String> p : mapWithPointFiveLoad.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		// this will overwrite the original values
		mapWithPointFiveLoad.put(5, "FFF");
		mapWithPointFiveLoad.put(29, "GGG");
		mapWithPointFiveLoad.put(38, "HHH");
		mapWithPointFiveLoad.put(42, "III");
		mapWithPointFiveLoad.put(69, "JJJ");
		
		// print the new values
		System.out.println("Printing new values:");
		for(Entry<Integer, String> p : mapWithPointFiveLoad.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		// new key found, chain map will resize
		mapWithPointFiveLoad.put(74, "KKK");
		mapWithPointFiveLoad.put(93, "LLL");
		System.out.println("Printing with new members:");
		for(Entry<Integer, String> p : mapWithPointFiveLoad.entrySet()) {
			System.out.println(p.getKey() + " - " +p.getValue());
		}
		
		
	}
	
}
