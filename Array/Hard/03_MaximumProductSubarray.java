import java.util.*;

class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre *= nums[i];
            suf *= nums[nums.length - i - 1];
            max = Math.max(max, Math.max(pre, suf));
            if (pre == 0) pre = 1;
            if (suf == 0) suf = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Max Product: " + maxProduct(nums));
    }
}

//We will wonder why not only with prefix because when there is odd number of negative in array prefix will failed to find maximum product subarray 
//ex = 1 -2 -3 - 4 1
//prefix Max = 6 (left to right) ||  suffix Max = 24 (right to left)
