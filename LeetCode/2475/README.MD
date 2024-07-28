# Number of Unequal Triplets in Array
- Time Complexity: O(N<sup>3</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        for(int i = 0; i+2 < nums.length;i++){
            for(int j = i+1; j+1 < nums.length;j++){
                for(int k = j+1; k < nums.length; k++){
                    res += (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k])? 1: 0;
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>3</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int unequalTriplets(int[] nums) {
        int res = 0,
            i = 0,
            j = i+1,
            k = j+1;
        while(i+2 < nums.length){
            if(nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]){
                res++;
            }
            k++;
            if(k == nums.length){
                j++;
                k = j+1;
            }
            if(j == nums.length-1){
                i++;
                j = i+1;
                k = j+1;
            }
        }
        return res;
    }
}
```
