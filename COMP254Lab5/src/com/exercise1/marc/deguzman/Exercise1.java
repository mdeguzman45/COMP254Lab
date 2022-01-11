package com.exercise1.marc.deguzman;

import java.util.ArrayList;

import com.exercise.tree.AbstractBinaryTree;
import com.exercise.tree.AbstractTree;
import com.exercise.tree.LinkedBinaryTree;
import com.exercise.tree.Position;
import com.exercise.tree.Tree;

public class Exercise1 {
	/** Returns a string containing n spaces. */

	public static <E> void printPreorder(AbstractTree<E> T) {
		for (Position<E> p : T.preorder())
			System.out.println(p.getElement());
	}

	public static <E> void printPostOrder(AbstractTree<E> T) {
		for (Position<E> p : T.postorder())
			System.out.println(p.getElement());
	}

	public static <E> void printInOrder(AbstractBinaryTree<E> T) {
		for (Position<E> p : T.inorder())
			System.out.println(p.getElement());
	}

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
		
		System.out.println("In Order of tree:");
		printInOrder(lbt);
		
		Position<String> inOrderNextB = lbt.inorderNext(B);
		if (inOrderNextB != null) {
			System.out.println("inorder next of B: " + inOrderNextB.getElement()); // should return G
		} else {
			System.out.println("inorder next of B: null, this is the last node");
		}
		
		Position<String> inOrderNextH = lbt.inorderNext(H);
		if (inOrderNextH != null) {
			System.out.println("inorder next of H: " + inOrderNextH.getElement()); // should return A
		} else {
			System.out.println("inorder next of H: null, this is the last node");
		}
		
		Position<String> inOrderNextF = lbt.inorderNext(F);
		if (inOrderNextF != null) {
			System.out.println("inorder next of F: " + inOrderNextF.getElement()); // should return H
		} else {
			System.out.println("inorder next of F: null, this is the last node");
		}
		
		Position<String> inOrderNextJ = lbt.inorderNext(J);
		if (inOrderNextJ != null) {
			System.out.println("inorder next of J: " + inOrderNextJ.getElement()); // should return null
		} else {
			System.out.println("inorder next of J: null, this is the last node");
		}
		
		System.out.println("Post Order of tree:");
		printPostOrder(lbt);
		
		Position<String> postOrderNextE = lbt.postorderNext(E);
		if (postOrderNextE != null) {
			System.out.println("postorder next of E: " + postOrderNextE.getElement()); // should return G
		} else {
			System.out.println("postorder next of E: null, this is the last node");
		}
		
		Position<String> postOrderNextC = lbt.postorderNext(C);
		if (postOrderNextC != null) {
			System.out.println("postorder next of C: " + postOrderNextC.getElement()); // should return J
		} else {
			System.out.println("postorder next of C: null, this is the last node");
		}
		
		// this will return null since 
		Position<String> postOrderNextA = lbt.postorderNext(A);
		if (postOrderNextA != null) {
			System.out.println("postorder next of A: " + postOrderNextA.getElement()); // should return null
		} else {
			System.out.println("postorder next of A: null, this is the last node");
		}

		// lbt.printElementAndHeightPosition(A);
	}
}
