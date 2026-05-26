//Brute Force
class Solution {
    public int findPages(int[] arr, int k) {
        if(arr.length<k)
        return -1;
        int maximumPage = arr[0];
        int totalPage = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            maximumPage=Math.max(maximumPage,arr[i]);
            totalPage+=arr[i];
        }
        for(int i=maximumPage;i<=totalPage;i++)
        {
            int count =0;
            int pageAllocated=0;
            for(int j=0;j<arr.length;j++)
            {
                if(pageAllocated+arr[j]<=i)
                pageAllocated+=arr[j];
                else{
                    pageAllocated=arr[j];
                    count++;
                }
            }
            count++;
            if(count<=k)
            return i;
        }
        return totalPage;
    }
}
//Time Complexity = o(n * (sum(arr)-max(arr)) = o(n * (sum-max))

//Optimal Approach
class Solution {
    public int findPages(int[] arr, int k) {
        int ans =-1;
        if(arr.length<k)
        return ans;
        int maximumPage = arr[0];
        int totalPage = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            maximumPage=Math.max(maximumPage,arr[i]);
            totalPage+=arr[i];
        }
        int low = maximumPage;
        int high = totalPage;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int pageAllocated=0;
            int count =0;
            for(int i=0;i<arr.length;i++)
            {
                if(pageAllocated+arr[i]<=mid)
                pageAllocated+=arr[i];
                else
                {
                    pageAllocated=arr[i];
                    count++;
                }
            }
            count++;
            if(count<=k)
            {
                ans = mid;
                high = mid -1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}
//Time Complexity = o(n*log(sum-max))

//Pattern : Binary search on Answer
//Approch : Greedy method on search space find first minimum of pages which which statisfy count == k but not count==k it count <=k why see below context with example. 
//In such question think like that how to thing any X number to fit index entirely first or using greedy how much should pages or books should I give to first student.. 
// this will click we need a range to search to get a X number to first first student in that limit of X then fill another student in that range and find total number of student allocated with that range of X
//We want the smallest mid for which the greedy allocation needs at most k students. We don't rely on exactly k because a valid k-student split might naturally use fewer students at a given page limit.
//Key Point : Minimum of Maximum or Maximum of Minimum 
//Avoid arrangement of array to statisy k it is a wrong approach and Searching sequence to fit the indexes to statisfy k and exponential posibilites like permutation . 
// always avoid Fix students, arrange books , Searching over arrangements, Exponential possibilities
//What Question wants -> Question wants to allocated the each index to in such manner that atleast each student get one book and one book cannot shared with more than 1 student 
// and find minimum no of pages which is maximum any student can hold 
// Let's take example 
// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113
// Explanation: Allocation can be done in following ways:
// => [12] and [34, 67, 90] Maximum Pages = 191
// => [12, 34] and [67, 90] Maximum Pages = 157
// => [12, 34, 67] and [90] Maximum Pages = 113.
// The third combination has the minimum pages assigned to a student which is 113.

// such that we have to allocate 

// Approach -> while assigning books to student we must ensure that whole book must be given to any one student so we need to start searching from maximum value of array which 90 
// because if we take less than that and starts assiging to student it is impossible to give book with 90 page to any single student so before 90 page everything is useless 
// for highest search is sum of entire pages because 1 student can have all books which is maximum , more than that no of pages is useless because no pages are there more than that totoal of sum of pages 
// so we will take any number between than and start filling that pages of entire one index if no of pages is greater than our choosen number of pages then we will allot that much of page to one student 
// greedy approach becasue we assume that no of pages is fit for first student that's how we will assign books -> pages+book[i]<=totalPageTogive then only we add pages else stdCount++ means one student acquired 
// that much of pages

// Main concern where I stuck why stdCount<=k is correct because question wants each student must hold atleast one book but in this case number of student is smaller than no of student given than that would be wrong 
// but no it is correct why let's see 
// first if there are 3 books and 3 student each should will have 1 book only which is correct but if books are 3 and student are 4 so it is imposible to distribute among the students with that 
// because here constraint will fail that each student must have atleast 1 book 
// that's why at the top we have handled edge case of returning -1. 
//Now come to main point why count <= k is valid , it is  because except greater than no of student which is handled with -1 , there would be  same number of students with book or less than no of books 
//so when no of student is smaller and equall to no of pages while allocating the books pages to student if we get count as less than k means atleast one student has got more than one book so we can distribute that
// extra book to any remaining student for details let's see below example 
// arr[] = {10, 15, 19, 10, 5, 18, 7}
//output = 25 
// suppose we are performing linear search on so we will start with i = 19 which is maximum so we get count as 6 students which is greater than k and we want minimum maximum no of page that any student can carry
// so we should increase the size of allocation of page so when i = 24 we get 6 till then also like -> 10 (1), 15 (2),  19(3), 10+5 (4), 18 (5), 7(6) so we allocated this pages to six students 
// now when i = 25 we get 4 student, allocation is like (10+15, 19, 10+5, 18+7) so two students are taking more than one book so one extra book can be allocated to that 5 student like 18 to 4th and 7 to 5 so 
// so minimum maximum we get 25 for allocating among 4 student .

// so while doing binary seach we are finding possible ans where count of student is smaller than k and then moving left side to check minimum possible pages to allocate.
