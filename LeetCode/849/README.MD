# Maximize Distance to Closest Person
# Two Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of seats
```
class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = -1,
            res = Integer.MIN_VALUE;
        for(int j = 0; j < seats.length; j++){
            if(seats[j] == 0){
                continue;
            }
            if(i == -1){
                res = Math.max(res, j);
            }else{
                res = Math.max(res, (j-i)/2);
            }
            i = j;
        }
        if(seats[seats.length-1] == 0){
            res = Math.max(res, seats.length-1-i);
        }
        return res;
    }
}
```