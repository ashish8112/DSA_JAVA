                           
int[]  -> comparator NAHI chalta (primitive)
Integer[] -> chalta hai because non-primitive
int[][]   → chalta hai (har row ek object hai)
List<>    → list.sort(...) chalta hain 

   Same Rule for 1D and 2D just in 2D a is enitre one row and b in entire another row for more checkout below 
   but note for 1D we cannot use Arrays.sort(nums,(a,b)->....) because it only works on 2D matrix or Objects 

  I have taken 1D array to understand sorting , it doesn't works only we have Arrays.sort(nums) for ascending and for descending reverse it or 
  if you want comparator convert it into object like Integer 
  
// Rule (a,b) -> return a-b  for understanding 
if +ve b return parameter value of b 
if -ve a return parameter value of a 
  Always it return b and a based on positive and negative respectively 

  // Actual 
  Comparator ek NUMBER return karta hai, a ya b nahi.
-ve → a pehle aata hai
+ve → b pehle aata hai
 0  → barabar
  for sequence in array or whatever
  

     (a,b) -> return a - b 
50 -> a=50, b=70 return 50-70  -ve means return a which is 50 
70 -> a=70, b=20 return 70-20 +ve means return b which is 20 now 70 becomes 20 and 70 goes down so a is 70 for down , basically swapped for sorting
20 -> a=70 , b=80 return 70-80 -ve means return a which is 70 
80 -> a=80, b=10 return 80-10 +ve means return b which is 10 
10

  after top sorting 
    (a,b) -> return a - b
50 -> a= 50 , b=20 return 50-20 +ve means return  b which is 20 means 50 is swapped with 20 and 50 goes down 
20 -> a= 50 , b=70 return 50-70 -ve means return a which is 50 
70 -> a=70 , b=10 return 70-10 +ve means return b which is 10 means 70 is swapped with 10 and 70 goes down
10 -> a =70, b=80 return  70-80 -ve means return a which is 70
80

  after top sorting 
20
50
10
70
80 
  that's how it works if we go two more step it will be sorted in ascending 


Rule is same 
// Rule (a,b) -> return a-b  
if +ve b return parameter value of b 
if -ve a return parameter value of a 
  Always it return b and a based on positive and negative respectively 

     (a,b) -> return b -a but return parameter a if negative and b if positive same as abve , note return a and b is same on both condition
50 -> a=50, b=70 return b-a -> 70-50 +ve means return b which is 70 means 50 is swapped with 70 and 50 goes down
70 -> a=50, b=20 return b-a -> 20-50 -ve means return a which is 50 
20 -> a=20,b=80 return b-a -> 80-20 +ve means return b which is 80 means 20 is swapped with 80 and 20 goes down
80 -> a=20 , b=10 return b-a -> 10-20 -ve means return a which is 20 
10 -> 

  after top sorting 
70
50
80
20
10

that's how it works if we go one more step it will be sorted in descending 


so conclusion is that (a,b) , a and b is parameter which takes two value and sort ascending if a-b is return and sort in descending if b-a is return

Note: It uses tim sort but for understanding we use bubble sort to understand


        // for 2d Array 
  Suppose we have Two Sum question where we have to return index.
  [3,2,4] and target is 6 

  create 2D array 
  pairs = [[3, 0], [2,1], [4,2]] 

now Arrays.sort(pairs,(a,b)->{ // here a is [3,0] and b  is [2,1] 
  return a[0]-b[0]; // for ascending a-b as we know in 1d array same here and for descending b-a; 
});


Another example 

  int[][] students = {{80, 3}, {90, 1}, {80, 1}, {70, 2}};   // {marks, roll}
Rule: marks zyada pehle, aur marks same ho to roll chhota pehle.

  Arrays.sort(students, (a, b) -> {
    if (a[0] == b[0])
        return a[1] - b[1];      // tie: roll chhota pehle because a-b is for ascending 
    return b[0] - a[0];          // marks bada pehle because b-a is for descending
});

Note : sort is done on rows not on values example 

  int[][] students asal me arrays ka array hai. Har row ek alag int[] object hai:

students[0] = {80, 3}
students[1] = {90, 1}
students[2] = {80, 1}
students[3] = {70, 2}

Arrays.sort in rows ko sort karta hai, andar ke numbers ko nahi. To jab wo compare karta hai, a ek poori row deta hai aur b doosri, jaise:
  a = {80, 3}
  b = {90, 1}

  Ab hum decide karte hain row ke kaunse hisse se compare karna hai: a[0] (marks) ya a[1] (roll).

Note: a - b overflow kar sakta hai agar values int ke kinaron pe hon.
     Safe: Integer.compare(a, b) ascending, Integer.compare(b, a) descending.
