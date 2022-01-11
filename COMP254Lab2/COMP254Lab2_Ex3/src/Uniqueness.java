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

import java.util.Arrays;

/**
 * Demonstration of algorithms for testing element uniqueness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class Uniqueness {

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j=0; j < n-1; j++)
      for (int k=j+1; k < n; k++)
        if (data[j] == data[k])
          return false;                    // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  /** Returns true if there are no duplicate elements in the array. */
  public static boolean unique2(int[] data) {
    int n = data.length;
    int[] temp = Arrays.copyOf(data, n);   // make copy of data
    Arrays.sort(temp);                     // and sort the copy
    for (int j=0; j < n-1; j++)
      if (temp[j] == temp[j+1])            // check neighboring entries
        return false;                      // found duplicate pair
    return true;                           // if we reach this, elements are unique
  }

  // experimental analysis will run longer on the unique1 algorithm
  public static void main(String[] args) {
	  int n = 2500;		// starting n value
	  int trials = 10;	// lets try 10 times, adding more trials throws an out of memory exception
	  int start = n;	// remember the start value
	  long targetTime = 60000; // there is 60000 milliseconds in 1 minute
	  int[] nArray = new int[trials]; // create an array to hold n sizes
	  long[] elapsedTimeUnique1 = new long[trials]; // lets save the elapsed times of the n inputs, this will be parallel on nArray
	  long[] elapsedTimeUnique2 = new long[trials]; // lets save the elapsed times of the n inputs, this will be parallel on nArray
	  
	  int unique2LargestN = 0; // largest value of n such that the given algorithm runs in one minute or less in unique2 algorithm
	  int unique1LargestN = 0; // largest value of n such that the given algorithm runs in one minute or less in unique1 algorithm
	  
	  for(int i = 0; i < trials; i++) {
		  nArray[i] = n;
		  n += n; // increment n size by itself
	  }
	  
	  int begin = 0;
	  int last = nArray.length -1;
	  int mid = 0;
	  
	  // let's run version 2 (the quicker one) first with O(n)
	  System.out.println("Testing unique2...");
	  for (int t=0; t < trials; t++) {
		  // generate the array based on n size
		  // int inputArray[] = new int[n];
		  int nSize = nArray[t];
		  int inputArray[] = generateIntArray(nSize);
		  
		  // start performing experimental analysis
		  long startTime = System.currentTimeMillis();
		  unique2(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println(String.format("n: %9d took %12d milliseconds", nSize, elapsed));
		  
		  // lets store the elapsed time
		  elapsedTimeUnique2[t] = elapsed;
	  }
	  
	  // do binary search to determine the maximum effective value of n via the elapsed times recorded
	  // we assign the largest n on the if conditions since we wont exactly get a target elapsed time of 60000 milliseconds
	  while (begin <= last) {
		  mid = (begin + last) / 2;

		  if (targetTime < elapsedTimeUnique2[mid]) {
			  // recur left of the middle
			  last = mid - 1;
			  unique2LargestN = nArray[last];
		  }  else if (targetTime > elapsedTimeUnique2[mid]) {
			  // recur right of the middle
			  begin = mid + 1;
			  unique2LargestN = nArray[last];
		  } else {
			// found a match
			  unique2LargestN = nArray[mid];
			  break;
		  } 
	  }
	  
	  System.out.println("the maximum effective n value on unique2 in our experimental analysis is " + unique2LargestN);
	  
	  // let's run the function with O(n^2)
	  System.out.println("Testing unique1...");
	  n = start;	// restore n to its start value
	  for (int t=0; t < trials; t++) {
		  // generate the array based on n size
		  int nSize = nArray[t];
		  int inputArray[] = generateIntArray(nSize);
		  
		  // System.out.println("inputarray length -> " + inputArray.length);
		  
		  // start performing experimental analysis
		  long startTime = System.currentTimeMillis();
		  unique1(inputArray);
		  long endTime = System.currentTimeMillis();
		  long elapsed = endTime - startTime;
		  System.out.println(String.format("n: %9d took %12d milliseconds", nSize, elapsed));
		  
		// lets store the elapsed time
		  elapsedTimeUnique1[t] = elapsed;
	  }
	  
	  // reset points
	  begin = 0;
	  last = nArray.length -1;
	  mid = 0;
	  
	  // do binary search to determine the maximum effective value of n via the elapsed times recorded
	  // we assign the largest n on the if conditions since we wont exactly get a target elapsed time of 60000 milliseconds
	  while (begin <= last) {
		  mid = (begin + last) / 2;

		  if (targetTime < elapsedTimeUnique1[mid]) {
			  // recur left of the middle
			  last = mid - 1;
			  unique1LargestN = nArray[last];
		  }  else if (targetTime > elapsedTimeUnique1[mid]) {
			  // recur right of the middle
			  begin = mid + 1;
			  unique1LargestN = nArray[last];
		  } else {
			  // found a match
			  unique1LargestN = nArray[mid];
			  break;
		  } 
	  }
	  
	  System.out.println("the maximum effective n value on unique1 in our experimental analysis is " + unique1LargestN);
  }
  
  //helper function to generate and populate an array. Size will be based on n
  public static int[] generateIntArray(int n) {
	  int generatedArray[] = new int[n];
	  int numValue = 0;

	  for (int x = 0; x < n; x++) {
		  numValue += 2;
		  generatedArray[x] = numValue;
	  }

	  return generatedArray;
  }
}
