# Find Indices With Index and Value Difference I

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for(int i = 0; i+indexDifference < nums.length; i++){
            for(int j = i+indexDifference; j < nums.length; j++){
                if(Math.abs(nums[j]-nums[i]) >= valueDifference){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int minIndex = 0,
            maxIndex = 0;
        for(int i = indexDifference; i < nums.length; i++){
            if(nums[i-indexDifference] < nums[minIndex]){
                minIndex = i-indexDifference;
            }
            if(nums[i-indexDifference] > nums[maxIndex]){
                maxIndex = i-indexDifference;
            }
            if(nums[i] - nums[minIndex] >= valueDifference){
                return new int[]{minIndex, i};
            }
            if(nums[maxIndex] - nums[i] >= valueDifference){
                return new int[]{maxIndex, i};
            }
        }
        return new int[]{-1, -1};
    }
}
```
