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
 * Demonstration of algorithms for computing the prefix averages of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class PrefixAverage {

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    for (int j=0; j < n; j++) {
      double total = 0;            // begin computing x[0] + ... + x[j]
      for (int i=0; i <= j; i++)
        total += x[i];
      a[j] = total / (j+1);        // record the average
    }
    return a;
  }

  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];    // filled with zeros by default
    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
    for (int j=0; j < n; j++) {
      total += x[j];               // update prefix sum to include x[j]
      a[j] = total / (j+1);        // compute average based on current sum
    }
    return a;
  }
  
  public static void main(String[] args) {
	  int n = 2000;		// starting value
	  int trials = 10;	// lets try 10 times
	  int start = n;	// remember the start value
	    
	  // let's run version 2 (the quicker one) first with O(n)
	  System.out.println("Testing prefixAverage2...");
	  for (int t=0; t < trials; t++) {
		  // generate the array based on n size
		  double inputArray[] = new double[n];
		  
		  // start performing experimental analysis
		  long startTime = System.currentTimeMillis();
		  double[] prefixArray = prefixAverage2(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
		  n *= 2;                                // double the problem size
	  }
	  
	  // let's run the function with O(n^2)
	  System.out.println("Testing prefixAverage1...");
	  n = start;	// restore n to its start value
	  for (int t=0; t < trials; t++) {
		  // generate the array based on n size
		  double inputArray[] = new double[n];
		  
		  // start performing experimental analysis
		  long startTime = System.currentTimeMillis();
		  double[] prefixArray = prefixAverage1(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
		  n *= 2;                                // double the problem size
	  }
  }

}
