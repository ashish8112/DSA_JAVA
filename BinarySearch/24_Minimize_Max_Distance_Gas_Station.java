class Solution {
    public double minMaxDist(int[] stations, int K) {
        if(stations.length<=1)
        return 0;
        int maxGap = 0;
        for(int i=0;i<stations.length-1;i++){
            maxGap = Math.max(maxGap,stations[i+1]-stations[i]);
        }
        for(double i=1;i<=maxGap;i++)
        {
             double count =0;
             for(int j=0;j<stations.length-1;j++)
             {
                 double diff = stations[j+1]-stations[j];
                 count+=Math.ceil(diff/i) - 1;
             }
             if(count<=K)
             return i;
        }
        return (double)maxGap;
    }
}
//This code is working for integer but not for the decimal and float.

class Solution {
    public double minMaxDist(int[] stations, int k) {
        if(stations.length <= 1) return 0;
        int maxGap = 0;
        for(int i = 0; i < stations.length-1; i++)
            maxGap = Math.max(maxGap, stations[i+1]-stations[i]);
        double low = 1e-9, high = maxGap, ans = maxGap;
        for(int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double count = 0;
            for(int j = 0; j < stations.length-1; j++) {
                double diff = stations[j+1] - stations[j];
                count += Math.ceil(diff/mid) - 1;
            }
            if(count <= k) { ans = mid; high = mid; }
            else low = mid;
        }
        return ans;
    }
}


//Pattern - Binary Search on Answer 
// Approach - low = 1 and high = maximum gap between any two consectuive gas station 
// ex -> arr = [1,7] , k=2
//Note : ceil (distance between two consecutive / d) gives parts or sector which can divide that space in that number of parts or sector 
// ex -> 1 <--7--> 8 if we take floor 7/6 = 1 part which is length of 7(because one part eniter is 7)which is exceeding our given d = 6 so in 1-1 =0(because we cannot add anything which is already in 1 part , but to
// make anything in 2 equal part we can add one thing between them that 1-1 = 0(station required to split 1 enitre part)
// we do -1 because we have to get that number of station to fulfill that divided sector so ceil 7/6 = 2 equal part means we can divide 7 unit space in 2 equal part 3.5 and 3.5 and to make it possible we need 1 station 
// 1 <3.5> X <3.5> , that's why we required ceil.
// My observation is take any distance starts from 1 because the smallest distance between any two gas station is 1 so 
// we will try to set add gas station between two consecutive distance of gas station for that we will check 
// d(distance yet = 1) no of possible gas station between two distance = distance between two station / d (1) - 1 . ? why 
// -1 because it will divide that space between equal parts suppose arr = [1, 7] => (ceiling) 6/2 which is 3 so there are will be three space or three sector 1__x__x__7 so 
// there is three equal space of 2 which was d or distance so how many station can be fixed which 2 so count will be 2 1 <-2-> A <-2-> B <-2-> 7  gas station A and B 
//now come to the question we will start from 1 distance so 6/1-1 = 5 gas station required to get minimum distance 1 but question is given k=2 , so this is not possible 
// so we will take d = 2 so get 6/2 -1 = 2 so this possible answer because k is 2 and we get 2 gas station which help to minimize the distance between 2 gas station 
// so ans is 2 
// and 3 = d is also valid answer because 6/3 -1 = 1 k so 1 k only required to get minimum distance between two station, there is no need to add all k to get minimum 
// distance our main aim is to find minimum distance with given k 
// so out of 2 and 3 ...  2 is minimum answer which is maximum distance between two station 

// let see any another example 
// ex -> arr = [3, 6, 12, 19, 33], k = 3
// so all distance 3 <3> 6 <6> 12 <7> 19 <14> 33   , so there are 4 sector of space V X Y Z 
// let's start with d = 1 in first two consecutive distance there would be 2 station and in second consecutive 6/1 - 1 = 5 and so on but k is only 3 so it cannot minimize distance to 1 using k = 3 
// let's take d = 2 then V space = 3 / 2 = > 1.X take celling 2 => 2-1 we can fix 1 station here, X space = 6/2 = 3-1 = 2 and so on total 12 station required to get minimum distance as 2 
// let's take d = 5 then V space = 3/5 => 0.X => 1-1= 0 , X space = 6/5 = > 2-1 = 1 station , Y space = 7/5 => 2-1 = 1 station , Z space = 14 /5 => 3 -1 = 2 so total station required 4 but given is 3 this is also not valid
// let's take d = 6 then V space = 3/6 => 1-1= 0 , X space = 6/6 -1 = 0 , Y space = 7/6 => 2-1 = 1 station  and Z = 14/6 => 3-1 = 2 station so total is 3 station is required and possible minimum maximum distance with 
// 3 station is 6 so answer is 6. even though all distance above 6 distance like 7,8,9 and 14 is valid because it will take less than or equall to k station to minimize the distance but our aim is to find
// so distance in Y space is 7 unit so there would be only one station can be fixed so to fix one station we need to split 7 in station + 1 equal parts = 7/2 = 3.5 so 6 <3.5> A <3.5> 19
// and in Z space there is 14 unit so it requires 2 station as per above , so to fix 2 station we need 3 equall parts 14/3 = 4.7 => 19 <4.7> B <4.7> C <4.7> 33
// minimum distance which has maximum distance between two station so taking 6 will be like that -> 3 6 12 6 <3.5> A <3.5> 19 <4.7> B <4.7> C <4.7> 33  so three station A, B and C is used 
// we can notice that 6 is minimum maximum distance in between the gas station which is from 6 to 12 .
