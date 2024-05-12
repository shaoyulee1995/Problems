# Gas Station
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of gas
```
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSum = 0,
            totalSum = 0,
            idx = 0;
        for(int i = 0; i < gas.length; i++){
            totalSum += gas[i] - cost[i];
            if(totalSum < minSum){
                minSum = totalSum;
                idx = (i+1)%gas.length;
            }
        }
        if(totalSum < 0){
            return -1;
        }
        return idx;
    }
}
```