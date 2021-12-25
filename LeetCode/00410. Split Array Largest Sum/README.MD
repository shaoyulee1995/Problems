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
            max = Math.max(num, max);
            sum += num;
        }
        int low = max,
            high = sum;
        while(low < high){
            int mid = low + (high - low)/2;
            int pieces = split(nums, mid);
            if(pieces > m){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    private int split(int[] nums, int largestVal){
        int tempSum = 0,
            curPiece = 1;
        for(int num: nums){
            if(tempSum + num > largestVal){
                tempSum = num;
                curPiece++;
            }else{
                tempSum += num;
            }
        }
        return curPiece;
    }
}
```