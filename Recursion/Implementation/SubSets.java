class OptimalV1Solution {
    void solve (List<List<Integer>>list, int [] nums, int index,List<Integer>res)
    {
        if(index >=nums.length)
        return;
        for(int i=index;i<nums.length;i++)
        {
            List<Integer> ans = new ArrayList<>(res); // this is creating new ans in every itearion we can optmize it 
            ans.add(nums[i]);
            list.add(ans);
            solve(list,nums,i+1,ans);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();
        list.add(ans);
        solve(list,nums,0,ans);
        return list;
    }
}


class OptimalSolution {
    void solve (List<List<Integer>>list, int [] nums, int index,List<Integer>res)
    {
        list.add(new ArrayList<>(res));
        for(int i=index;i<nums.length;i++)
        {
            res.add(nums[i]);
            solve(list,nums,i+1,res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        solve(list,nums,0,new ArrayList<>());
        return list;
    }
}

// Time complexity = o(2^n * n) 
// Space complexity = o(n)


/*
Pattern: Subsets via Index-based Backtracking (Power Set)

Trigger: "Saare subsets/combinations banao" jahan order matter nahi karta
         aur duplicates nahi chahiye.

Template:
    void solve(list, nums, index, curr) {
        list.add(new ArrayList<>(curr));      // har call ek valid subset hai
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            solve(list, nums, i+1, curr);      // i+1, NOT index+1 - reuse na ho
            curr.remove(curr.size()-1);        // undo
        }
    }

Key Insights:
1) list.add() function ke SHURU me hai, base case ke andar nahi -
   har recursive call apne aap ek valid subset hai (empty se lekar poora).
2) i+1 (loop variable), index+1 nahi - warna same element dobara use
   ho sakta hai usi subset me.
3) Ek hi curr object poore tree me reuse hota hai. list.add() ke waqt
   COPY zaroori hai (new ArrayList<>(curr)) - warna sab entries
   same reference point karengi aur baad ke remove() se purani
   entries bhi badal jaayengi.
4) Yahi choose-recurse-unchoose shape hai jo Generate Parenthesis me tha -
   sirf StringBuilder ki jagah List, aur append/deleteCharAt ki jagah
   add/remove(size-1).

Complexity: Time O(2^n * n)  - 2^n subsets, har ek O(n) copy
            Space O(n)       - recursion depth, output ko auxiliary nahi ginte
*/



class CascadingSolution { // Approach Level Order or add yourselves means current value with all previous pair and make new pair that is what subset is called.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++)
        {
            int size = list.size();
            for(int j=0;j<size;j++)//subset means add current num value with every previous value
            {
                List<Integer>currentValue = new ArrayList<>(list.get(j));
                currentValue.add(nums[i]);
                list.add(currentValue);
            }
        }
        return list;
    }
}

// Time complexity = O(2^n * n)
// Space complexity (auxiliary) = O(1) - no recursion stack, unlike backtracking version

/*
Pattern: Cascading (Iterative Power Set Doubling)

Trigger: Subsets/power set chahiye, bina recursion ke.

Template:
    list.add(new ArrayList<>());              // empty subset se shuru
    for (int num : nums) {
        int size = list.size();                // SNAPSHOT - zaroori hai
        for (int j = 0; j < size; j++) {
            List<Integer> copy = new ArrayList<>(list.get(j));
            copy.add(num);
            list.add(copy);
        }
    }

Key Insights:
1) size = list.size() loop se PEHLE zaroori hai - warna naye add hue
   subsets pe bhi loop chalega, infinite growth. Yahi discipline
   BFS ke q.size() snapshot jaisi hai.
2) Har number pe list DOUBLE hoti hai - purane sab subsets ka copy
   banao, naya number jodo, list me add karo. 1 -> 2 -> 4 -> 8...
3) Backtracking se time complexity same hai (O(2^n * n)), par
   auxiliary space behtar hai - koi recursion stack nahi lagta,
   list khud hi seedha badhti hai.

Complexity: Time O(2^n * n)
            Space (auxiliary) O(1) - recursion nahi, sirf output list badhti hai
*/
