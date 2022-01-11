/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


/**
 * Code for end-of-chapter exercises on asymptotics.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Exercises {

  /** Returns the sum of the integers in given array. */
	/** 
	 * Big O Characterization
	 * line 45 have two constant time so its O(1)
	 * line 46 will run O(n) since it is dependent on the input size
	 * line 47 have 3 constant time so its O(1)
	 * line 48 will have O(1)
	 * regardless how many constant operations are in a line it will equate to O(1) 
	 * the functions Big O characterization is O(1) + (O(n) x O(1)) + O(1) = O(n)
	 * */
  public static int example1(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      total += arr[j];
    return total;
  }

  /** Returns the sum of the integers with even index in given array. */
	/** 
	 * Big O Characterization
	 * line 62 have two constant time so its O(1)
	 * line 63 will run O(n) since it is dependent on the input size
	 * line 64 have 3 constant time so its O(1)
	 * line 65 will have O(1)
	 * regardless how many constant operations are in a line it will equate to O(1) 
	 * the functions Big O characterization is O(1) + (O(n) x O(1)) + O(1) = O(n)
	 * */
  public static int example2(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j += 2)    // note the increment of 2
      total += arr[j];
    return total;
  }

  /**
   *  line 79 have two constant time so its O(1)
   *  line 81 will run O(n) since it is dependent on the input size
   *  line 81 will run O(n) since it is dependent on j
   *  line 82 have 3 constant time so its O(1)
   *  line 83 will have O(1)
   *  regardless how many constant operations are in a line it will equate to O(1) 
   *  the functions Big O characterization is O(1) + (O(n) x O(n) x O(1)) + O(1) = O(n^2)
   *  */
  /** Returns the sum of the prefix sums of given array. */
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;
    for (int j=0; j < n; j++)       // loop from 0 to n-1
      for (int k=0; k <= j; k++)    // loop from 0 to j
        total += arr[j];
    return total;
  }

  /**
   * line 97 have 3 constant time so its O(1)
   * line 98 will run O(n) since it is dependent on the input size
   * line 99 have 3 constant time so its O(1)
   * line 100 have 2 constant time so its O(1)
   * line 102 have 1 constant time so its O(1)
   * regardless how many constant operations are in a line it will equate to O(1)
   * the functions Big O characterization is O(1) + (O(n) x O(1) x O(1)) + O(1) = O(n)
   */
  /** Returns the sum of the prefix sums of given array. */
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;
    for (int j=0; j < n; j++) {     // loop from 0 to n-1
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }

  
  /**
   * line 120 have 2 constant time so its O(1)
   * line 121 will run O(n) since it is dependent on the input size
   * line 122 have 1 constant time so its O(1)
   * line 123 will run O(n) since it is dependent on the input size
   * line 124 will run O(n) since it is dependent on j which depends on n
   * line 125 will have 3 constant time so its O(1)
   * line 126 will have 3 constant time so its O(1)
   * line 128 will have 1 constant time
   * regardless how many constant operations are in a line it will equate to O(1)
   * the functions big O characterization is O(1) + (O(n) (O(n) x (O(n) x O(1))) x O(1)) + O(1) = O(n^3)
   */
  /** Returns the number of times second array stores sum of prefix sums from first. */
  public static int example5(int[] first, int[] second) { // assume equal-length arrays
    int n = first.length, count = 0;
    for (int i=0; i < n; i++) {     // loop from 0 to n-1
      int total = 0;
      for (int j=0; j < n; j++)     // loop from 0 to n-1
        for (int k=0; k <= j; k++)  // loop from 0 to j
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }

}
