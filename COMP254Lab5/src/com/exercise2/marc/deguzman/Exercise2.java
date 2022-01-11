package com.exercise2.marc.deguzman;

import com.exercise.tree.AbstractTree;
import com.exercise.tree.LinkedBinaryTree;
import com.exercise.tree.Position;
import com.exercise.tree.Tree;

public class Exercise2 {
	/** Prints parenthesized representation of subtree of T rooted at p. */
	public static <E> void parenthesize(Tree<E> T, Position<E> p) {
		System.out.print(p.getElement());
		if (T.isInternal(p)) {
			boolean firstTime = true;
			for (Position<E> c : T.children(p)) {
				System.out.print( (firstTime ? " (" : ", ") ); // determine proper punctuation
				firstTime = false;                             // any future passes will get comma
				parenthesize(T, c);                            // recur on child
			}
			System.out.print(")");
		}
	}

	public static void main(String[] args)
	{
		// create the binary tree starting with A
		LinkedBinaryTree lbt = new LinkedBinaryTree();
		Position<String> A = lbt.addRoot("A");

		// children of A
		Position<String> B = lbt.addLeft(A, "B");
		Position<String> D = lbt.addRight(A, "D");

		// children of B
		Position<String> E = lbt.addLeft(B, "E");
		Position<String> F = lbt.addRight(B, "F");

		// children of F
		Position<String> G = lbt.addLeft(F, "G");
		Position<String> H = lbt.addRight(F, "H");

		// children of D
		Position<String> C = lbt.addLeft(D, "C");
		Position<String> J = lbt.addRight(D, "J");

		parenthesize(lbt, A);
		
		// print height of every position in the binary tree
		System.out.println("");
		printPostOrderWithHeight(lbt);
	}

	// exercise 2
	public static <E> void printPostOrderWithHeight(AbstractTree<E> T) {
		for (Position<E> p : T.postorder()) {
			System.out.println("Element: " + p.getElement() + "[Height = " + T.height(p) + "]");
		}
	}
}
