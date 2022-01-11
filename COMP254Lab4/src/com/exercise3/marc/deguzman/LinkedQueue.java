package com.exercise3.marc.deguzman;

public class LinkedQueue<E> implements Queue<E> {

	/** The primary storage for elements of the queue */
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

	/** Constructs an initially empty queue. */
	public LinkedQueue() { }                  // new queue relies on the initially empty list

	/**
	 * Returns the number of elements in the queue.
	 * @return number of elements in the queue
	 */
	@Override
	public int size() { return list.size(); }

	/**
	 * Tests whether the queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() { return list.isEmpty(); }

	/**
	 * Inserts an element at the rear of the queue.
	 * @param element  the element to be inserted
	 */
	@Override
	public void enqueue(E element) { list.addLast(element); }

	/**
	 * Returns, but does not remove, the first element of the queue.
	 * @return the first element of the queue (or null if empty)
	 */
	@Override
	public E first() { return list.first(); }

	/**
	 * Removes and returns the first element of the queue.
	 * @return element removed (or null if empty)
	 */
	@Override
	public E dequeue() { return list.removeFirst(); }

	/** Produces a string representation of the contents of the queue.
	 *  (from front to back). This exists for debugging purposes only.
	 */
	public String toString() {
		return list.toString();
	}

	public void concatenate(LinkedQueue<E> Q2)
	{
		// assign Q2 to the list when empty
		if (list == null)
		{
			list = Q2.list;
		}
		else
		{
			// loop thru Q2 content
			while (Q2.isEmpty() == false)
			{
				// insert dequeued element of Q2 to the list
				list.addLast(Q2.dequeue());
			}
		}
	}
}
