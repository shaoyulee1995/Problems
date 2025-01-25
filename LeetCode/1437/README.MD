# Check If All 1's Are at Least Length K Places Away

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N is the length of the input array

```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        Integer prev = null;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1 && prev == null){
                prev = i;
            }else{
                if(nums[i] == 1){
                    if(i - prev <= k){
                        return false;
                    }
                    prev = i;
                }
            }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N is the length of the input array
  
```java
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                prev = i;
                break;
            }
        }
        for(int i = prev+1; i < nums.length; i++){
            if(nums[i] == 1){
                if(i-prev <= k){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
```