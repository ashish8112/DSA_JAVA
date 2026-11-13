// Rule (a,b) -> return a-b  
if +ve b return parameter value of b 
if -ve a return parameter value of a 
  Always it return b and a based on positive and negative respectively 

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
