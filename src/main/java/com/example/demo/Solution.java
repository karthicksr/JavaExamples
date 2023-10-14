package com.example.demo;

public class Solution {
	public int solution(int[] A) {

		int n = A.length;

		// Step 1: Rearrange elements to put each positive integer at its correct index
		for (int i = 0; i < n; i++) {
			while (A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
				// Swap A[i] with A[A[i] - 1] to place A[i] at its correct index
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}

		// Step 2: Find the smallest positive integer that is missing
		for (int i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		// If all positive integers from 1 to n are present, return n + 1
		return n + 1;

	}
	
	public static void main(String args[]) {
		Solution s=new Solution();
		int A[]= {1,2,3};
		System.out.println(s.solution(A));
	}
}
