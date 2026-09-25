class Solution {
    void combinationSolve(List<List<Integer>> list , int [] nums, int target,int sum,List<Integer>curr,int index)
    {
        if(sum>=target)
        {
            if(sum==target)
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            curr.add(nums[i]);
            combinationSolve(list,nums,target,sum+nums[i],curr,i);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>list = new ArrayList<>();
        combinationSolve(list,nums,target,0,new ArrayList<>(),0);
        return list;
    }
}

//Time complexity = O(2^target) roughly , exact depend on nums values , because for same target different nums values have different operational cost.
//Space complexity = O(target/min(nums)) => O(t/min(n));
// why ? suppose min in array is 2 and target is 10 so maximum depth can 5 time  so 10 /2 =5 because if any another than this 2 number 
// max Depth cannot exceed 5 supose array was 2 3 4 so for , with 2 5 time itself now pruning after getting target or extra at sum = 8 + 3(2nd index) 11 prune again 5 stack only 
// now 8 + with any number in array will be 5 now , with 6 (3 stack currently in with recursion because of 3 time 2 ) 6 + 3 + 3 again 5 stack then pruned, 6 + 3 + 4 again 5 stack and pruned
// with any combination maximum 5 stack will be created in stack for solving 



/*
Pattern: Combination Sum (Backtracking with Repetition Allowed)

Trigger: Target sum banana hai, elements repeat ho sakte hain,
         order matter nahi karta (combinations).

Template:
    void solve(list, nums, target, sum, curr, index) {
        if (sum >= target) {
            if (sum == target) list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            solve(list, nums, target, sum + nums[i], curr, i);   // i for repeating itself
            curr.remove(curr.size()-1);
        }
    }

Key Insights:
1) i pass karo, i+1 nahi - REPETITION allowed hai isliye. Subsets me
   i+1 tha kyunki har element ek baar. Yahan same element dobara
   use ho sakta hai, isliye range "khud se aage" nahi "khud samet aage".
2) sum >= target pe turant return - positive numbers hone ki wajah se
   sum sirf badhega, isliye ye safe pruning hai (koi valid path miss nahi hota).
3) Wahi choose-recurse-unchoose shape jo Subsets aur Generate Parenthesis
   me tha - curr.add / recurse / curr.remove(size-1).
4) Optimization (agar nums sorted ho): loop ke andar hi break kar sakte ho
   jab sum+nums[i] > target - us point ke aage sab numbers bhi bade honge.

Complexity: Time O(2^target) roughly - exact bound nums ki values pe depend
            Space O(target / min(nums)) - worst case recursion depth
*/
