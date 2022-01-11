package com.exercise3.marc.deguzman;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SortedPriorityArray<K,V> extends AbstractPriorityQueue<K,V>  {
	/** empty array list */
	private List<Entry<K, V>> list = new ArrayList<>();

	/** Creates an empty priority queue based on the natural ordering of its keys. */
	public SortedPriorityArray() { super(); }


	/**
	 * Creates an empty priority queue using the given comparator to order keys.
	 * @param comp comparator defining the order of keys in the priority queue
	 */
	public SortedPriorityArray(Comparator<K> comp) { super(comp); }
	
	/* Inserting is now more difficult because we have to insert in the right place. */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newest = new PQEntry<>(key, value);
		if(list.size()==0) // first item to be added
			list.add(newest);
		else {
			//tries to find appropriate insertion location in the ArrayList
			for (int i = 0; i < list.size(); i++) {
				if (compare(list.get(i), newest) <= 0) {
					list.add(i, newest);
					return newest;
				}
			}
			//if we reached here, means new element is min
			list.add(list.size(), newest);
		}
		return newest;
	}
	
	// fetching min is much easier now because we are sorted, minimal is always at the end of list.
	@Override
	public Entry<K, V> min() {
		if(list.isEmpty()) return null;
		return list.get(list.size()-1); //O(1)
	}

	//removing is much easier because we are sorted, minimal is always first.
	@Override
	public Entry<K, V> removeMin() {
		if(list.isEmpty()) return null;
		return list.remove(list.size()-1); //O(1) as we don't have to shift anything
	}
	
	/**
	 * Returns the number of items in the priority queue.
	 * @return number of items
	 */
	@Override
	public int size() { return list.size(); }

	public static void main(String args[]) {

		SortedPriorityArray<String, String> sortedArray = new SortedPriorityArray<>();

		sortedArray.insert("5", "A");
		sortedArray.insert("3", "B");
		sortedArray.insert("9", "C");

		//
		// list min value
		System.out.println(sortedArray.min().getValue());
		
		// list sorted array
		for(Entry<String, String> arrayItem: sortedArray.list) {
			System.out.println( "(" + arrayItem.getKey() + ", " + arrayItem.getValue() + ")" );
		}


				//		for (Position<Entry<String,String>> walk : sortedArray.list.positions())
				//			System.out.println( "(" + walk.getElement().getKey() +
				//					", " + walk.getElement().getValue() + ")" );
				//		//print the key of the first entry
				//		Position<Entry<String,String>> first = queue.list.first();
				//		System.out.println(first.getElement().getKey());
				//		//print the entry with minimal key
				//		System.out.println("Entry with minimal key: (" +queue.min().getKey() +
				//				", " + queue.min().getValue() + ")" );
				//		//


	}

}
