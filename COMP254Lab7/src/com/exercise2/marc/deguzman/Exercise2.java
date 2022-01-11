package com.exercise2.marc.deguzman;

import java.util.Comparator;

public class Exercise2 {

	public static <K> void merge(Queue<K> inQueue, Queue<K> outQueue, Comparator<K> comp, int start, int increment) 
	{
		int end1 = start + increment;		// boundary for run 1
		int end2 = start + 2 * increment; 	// boundary for run 2
		int x = start;						// index into run 1
		int y = start + increment;			// index into run 2
		
//		System.out.println("increment = " + increment);
//		System.out.println("x (start) = " + x);
//		System.out.println("end1 = " + end1);
//		
//		System.out.println("y (start + increment) = " + y);
//		System.out.println("end2 = " + end2);
		
		Queue<K> Q1 = new LinkedQueue<>();		// create first Queue for comparison						
		Queue<K> Q2 = new LinkedQueue<>();		// create second Queue for comparison

		// create the pair of queues and make sure the queue is not empty
		while (x < end1 && !inQueue.isEmpty()) {
			Q1.enqueue(inQueue.dequeue());		// get the elements for comparison
			x++;
		}
		
		while (y < end2 && !inQueue.isEmpty()) {
			Q2.enqueue(inQueue.dequeue());		// get the elements for comparison
			y++;
		}
		
		// compare queues by pair until either one of them is already empty
		while (!Q1.isEmpty() && !Q2.isEmpty()) 
		{
			if (comp.compare(Q1.first(), Q2.first()) < 0)
			{
				outQueue.enqueue(Q1.dequeue()); 
			}
			else
			{
				outQueue.enqueue(Q2.dequeue());
			}
		}

		// put to destination queue the remaining items
		while (!Q1.isEmpty())
		{
			outQueue.enqueue(Q1.dequeue());
		}

		while (!Q2.isEmpty())
		{
			outQueue.enqueue(Q2.dequeue());
		}
	}
	
	public static <K> void mergeSortBottomUp(Queue<K> aQueue, Comparator<K> comp) 
	{
		if (aQueue == null) {
			return;
		}
		
		int n = aQueue.size();
		
		if (n < 2) 
		{
			return;
		}
			
		Queue<K> srcQ = aQueue;					// alias for the original queue
		Queue<K> destQ = new LinkedQueue<>();	// make a new temporary queue
		
		for (int i = 1; i < n; i *= 2) {		// each iteration sorts all runs of length i
			
			for (int j = 0; j < n; j += 2*i) {	// each pass merges two runs of length i
//				System.out.println("i = " + i);
//				System.out.println("j = " + j);
				merge(srcQ, destQ, comp, j, i);
			}
			
			// System.out.println("srcQ before assigning destQ -> " + srcQ.size());
			
			// put the sorted result on the srcQ for the next iteration
			while (!destQ.isEmpty()) {
				srcQ.enqueue(destQ.dequeue());
			}
			
//			System.out.println("srcQ afer assigning destQ -> " + srcQ.size());
//			System.out.println("[mergeSort2] destQ.size() = " + destQ.size());
//			System.out.println(srcQ);
//			System.out.println("-------------------------------------------------");
		}
	}
	
	public static void main(String[] args)
	{
		Queue<Integer> aQueue = new LinkedQueue<>();
		// create a comparator
		Comparator<Integer> integerComparator = new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2);
			}
		};
		
		aQueue.enqueue(93);
		aQueue.enqueue(32);
		aQueue.enqueue(68);
		aQueue.enqueue(12);
		aQueue.enqueue(54);
		aQueue.enqueue(83);
		aQueue.enqueue(47);
		aQueue.enqueue(5);
		aQueue.enqueue(3);
		
		// print the original queue
		System.out.println(aQueue);
		
		mergeSortBottomUp(aQueue, integerComparator);
		
		// print the sorted queue
		System.out.println(aQueue);
	}
}
