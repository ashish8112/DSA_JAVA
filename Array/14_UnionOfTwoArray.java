package DSA.Array;

import java.util.*;
class UnionOfTwoArray{
    public static void findUnion(int[] arr1, int[] arr2) { // Need to create a union in ascending order.
        // temp will store the union elements in sorted order
        ArrayList<Integer> temp = new ArrayList<Integer>();

        // i -> pointer for arr1
        // j -> pointer for arr2
        // k -> keeps track of number of elements added to temp (used to check last element for duplicates)
        int i = 0, j = 0, k = 0;

        // Traverse both arrays until one of them is completely processed
        while (i < arr1.length && j < arr2.length) {

            // Special handling for the first element of the union
            if (k == 0) {
                if (arr1[i] < arr2[j]) {
                    // arr1[i] is smallest, add it to temp
                    temp.add(arr1[i]);
                    i++;  // move pointer in arr1
                    k++;  // increase count of elements in temp
                } else if (arr1[i] == arr2[j]) {
                    // arr1[i] and arr2[j] are same, add only once
                    temp.add(arr1[i]);
                    i++; j++;  // move both pointers forward
                    k++;
                } else {
                    // arr2[j] is smallest, add it to temp
                    temp.add(arr2[j]);
                    j++;  // move pointer in arr2
                    k++;
                }
            }
            // Handling remaining elements after first element
            else {
                if (arr1[i] < arr2[j] && arr1[i] != temp.get(k - 1)) {
                    // arr1[i] is smaller than arr2[j] and not a duplicate → add it
                    temp.add(arr1[i]);
                    i++; k++;
                } else if (arr1[i] > arr2[j] && arr2[j] != temp.get(k - 1)) {
                    // arr2[j] is smaller than arr1[i] and not a duplicate → add it
                    temp.add(arr2[j]);
                    j++; k++;
                } else if (arr1[i] < arr2[j] && arr1[i] == temp.get(k - 1)) {
                    // arr1[i] is smaller but same as last added element → skip duplicate
                    i++;
                } else if (arr1[i] > arr2[j] && arr2[j] == temp.get(k - 1)) {
                    // arr2[j] is smaller but already in temp → skip duplicate
                    j++;
                } else if (arr1[i] == arr2[j] && arr1[i] != temp.get(k - 1)) {
                    // arr1[i] and arr2[j] are equal and not duplicate → add once
                    temp.add(arr1[i]);
                    i++; j++; k++;  // move both pointers forward and increase count
                } else if (arr1[i] == arr2[j] && arr1[i] == temp.get(k - 1)) {
                    // arr1[i] and arr2[j] are equal but already in temp → skip both
                    i++; j++;
                }
            }
        }

        // If arr1 has remaining elements
        while (i < arr1.length) {
            // Add element if first element or not duplicate
            if (k == 0 || arr1[i] != temp.get(k - 1)) {
                temp.add(arr1[i]);
                k++;
            }
            i++;  // move pointer forward
        }

        // If arr2 has remaining elements
        while (j < arr2.length) {
            // Add element if first element or not duplicate
            if (k == 0 || arr2[j] != temp.get(k - 1)) {
                temp.add(arr2[j]);
                k++;
            }
            j++;  // move pointer forward
        }

        // Print the union array
        for (int l = 0; l < temp.size(); l++)
            System.out.print(temp.get(l) + " ");
        System.out.println();
    }
    public static void main(String [] args)
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of first array");
    int sizeA=sc.nextInt();
    int [] a= new int[sizeA];
    System.out.println("Enter the "+sizeA+" values in first array");
    for(int i=0;i<sizeA;i++)
        a[i]=sc.nextInt();
    System.out.println("Enter the size of Second array");
    int sizeB=sc.nextInt();
    int [] b= new int [sizeB];
    System.out.println("Enter the "+sizeB+" values in Second array");
    for(int i=0;i<sizeB;i++)
        b[i]=sc.nextInt();
    findUnion(a,b);
}
}


/*
 * Union of Two Sorted Arrays
 *
 * Approach:
 * 1. Use two pointers i (arr1) and j (arr2) starting at 0.
 * 2. Initialize k = 0 to track last element added in temp ArrayList.
 * 3. Traverse both arrays using:
 *      while(i < arr1.length && j < arr2.length)
 *    - Compare arr1[i] and arr2[j]:
 *        a) If arr1[i] < arr2[j] and arr1[i] != temp.get(k-1) → add arr1[i], i++, k++
 *        b) If arr1[i] > arr2[j] and arr2[j] != temp.get(k-1) → add arr2[j], j++, k++
 *        c) If arr1[i] == arr2[j]:
 *            - If not duplicate → add once, i++, j++, k++
 *            - Else → i++, j++ (skip duplicate)
 * 4. After main loop, process remaining elements in arr1 or arr2 (if any), skipping duplicates.
 * 5. temp now contains the union in sorted order without duplicates.
 *
 * Pointer Logic:
 * - i moves forward through arr1
 * - j moves forward through arr2
 * - k tracks number of elements added to temp (last element = temp.get(k-1))
 * - When arr1[i] == arr2[j], move both pointers forward to avoid duplicates.
 *
 * Time Complexity:
 * - Main loop processes min(n, m) elements
 * - Remaining loops process leftover elements = |n - m|
 * - Total = O(n + m), linear in total elements
 *
 * Best Case:
 * - No duplicates, arrays balanced
 * - Each element visited once → O(n + m)
 *
 * Worst Case:
 * - Many duplicates or one array much bigger
 * - Each element still visited once → O(n + m)
 *
 * Space Complexity:
 * - temp stores union → O(n + m) in worst case
 * - Extra variables i, j, k → O(1)
 *
 * Key Learning:
 * - Two-pointer merge is optimal for sorted arrays
 * - Using last element tracking helps handle duplicates efficiently
 */
