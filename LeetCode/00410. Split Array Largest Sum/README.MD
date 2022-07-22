# Binary Search
* Time Complexity: O(Nlog(S-Mx))
	* S represents sum of nums array
	* Mx represets the current max for that group
* Space Complexity: O(1)
```
class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0,
            max = 0;
        for(int num: nums){
            sum += num;
            max = Math.max(num, max);
        }
        
        int i = max, j = sum;
        while(i < j){
            int k = i + (j-i)/2;
            int pieces = split(nums, m, k);
            if(pieces == -1){
                i = k + 1;
            }else{
                j = k;
            }
        }
        return i;
    }
    
    public int split(int[] nums, int m, int k){
        int curSum = 0, 
            piece = 1;
        for(int num: nums){
            if(curSum + num > k){
                piece++;
                curSum = 0;
            }
            if(piece > m){
                return -1;
            }
            curSum += num;
        }
        return piece;
    }
}
```