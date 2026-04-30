class Solution { //But it violates the constraint of o(1) space complexity
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
        if(!set.contains(nums[i]))
        set.add(nums[i]);
        else
        return nums[i];
        }
        return -1;
    }
}
