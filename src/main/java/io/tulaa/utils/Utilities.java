package io.tulaa.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

	public static List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (rowIndex < 0)
			return result;

		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = result.size() - 2; j >= 0; j--) {
				result.set(j + 1, result.get(j) + result.get(j + 1));
			}
			result.add(1);
		}
		return result;
	}

	// Returns true if there is Pythagorean triplet in ar[0..n-1]
	public static boolean checkIfTriplet(int ar[], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					// Calculate square of array elements
					int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

					if (x == y + z || y == x + z || z == x + y)
						return true;
				}
			}
		}
		// Incase no triplet is found
		return false;
	}

	public static int countTriplets(int[] arr, int n, int sum) {
		// Sort input array
		Arrays.sort(arr);
		// Initialize result
		int result = 0;
		// Every iteration of loop counts triplet with
		// first element as arr[i].
		for (int i = 0; i < n - 2; i++) {
			// Initialize other two elements as corner elements
			// of subarray arr[j+1..k]
			int j = i + 1, k = n - 1;

			// Use Meet in the Middle concept
			while (j < k) {
				// If sum of current triplet is more or equal,
				// move right corner to look for smaller values
				if (arr[i] + arr[j] + arr[k] >= sum)
					k--;
				// Else move left corner
				else {
					// This is important. For current i and j, there
					// can be total k-j third elements.
					result += (k - j);
					j++;
				}
			}
		}
		return result;
	}

	public static int countTripletsFn(int[] arr, int n, int sum) {
		return countTriplets(arr, n, sum);
	}

	public static boolean isArrayTriplet(int array[], int n) {
		int arraySize = array.length;
		if (checkIfTriplet(array, arraySize) == true)
			return true;
		else
			return false;
	}
}
