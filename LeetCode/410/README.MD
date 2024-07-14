# Split Array Largest Sum

- Time Complexity: O(Nlog(S-Mx))
- Space Complexity: O(1)
  - S represents sum of nums array
  - Mx represets the current max for that group

```java
class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum(),
            max = Arrays.stream(nums).max().getAsInt();
        return binarySearch(nums, max, sum, k);
    }

    public int binarySearch(int[] nums, int low, int high, int k){
        int i = low,
            j = high;
        while(i < j){
            int m = i + (j-i)/2;
            if(isValid(nums, m, k)){
                j = m;
            }else{
                i = m+1;
            }
        }
        return i;
    }

    public boolean isValid(int[] nums, int targetSum, int k){
        int piece = 1,
            sum = 0;
        for(int num: nums){
            if(sum + num > targetSum){
                piece++;
                sum = 0;
            }
            if(piece > k){
                return false;
            }
            sum += num;
        }
        return true;
    }
}
```
