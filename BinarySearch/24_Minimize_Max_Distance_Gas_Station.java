// ex -> arr = [1,7] , k=2
// My observation is take any distance starts from 1 because the smallest distance between any two gas station is 1 so 
// we will try to set add gas station between two consecutive distance of gas station for that we will check 
// d(distance yet = 1) no of possible gas station between two distance = distance between two station / d (1) - 1 . ? why 
// -1 because it will divide that space between equal parts suppose arr = [1, 7] => 6/2 which is 3 so there are will be three space or three sector 1__x__x__7 so 
// there is three equal space of 2 which was d or distance so how many station can be fixed which 2 so count will be 2 1 <-2-> A <-2-> B <-2-> 7  gas station A and B 
//now come to the question we will start from 1 distance so 6/1-1 = 5 gas station required to get minimum distance 1 but question is given k=2 , so this is not possible 
// so we will take d = 2 so get 6/2 -1 = 2 so this possible answer because k is 2 and we get 2 gas station which help to minimize the distance between 2 gas station 
// so ans is 2 
// and 3 = d is also valid answer because 6/3 -1 = 1 k so 1 k only required to get minimum distance between two station, there is no need to add all k to get minimum 
// distance our main aim is to find minimum distance with given k 
// so out of 2 and 3 ...  2 is minimum answer which is maximum distance between two station 

// let see any another example 
// ex -> arr = [3, 6, 12, 19, 33], k = 3
// 
