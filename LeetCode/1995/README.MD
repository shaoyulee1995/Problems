# Count Special Quadruplets

- Time Complexity: O(N<sup>4</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length-3; i++){
            for(int j = i+1; j < nums.length-2; j++){
                for(int k = j+1; k < nums.length-1; k++){
                    for(int l = k+1; l < nums.length; l++){
                        if(nums[i] + nums[j] + nums[k] == nums[l]){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i = nums.length-2; i >= 1; i--){
            for(int j = i+1; j < nums.length; j++){
                int num = nums[j] - nums[i];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int j = 0; j < i-1; j++){
                int num = nums[j] + nums[i-1];
                res += map.getOrDefault(num, 0);
            }
        }
        return res;
    }
}
```
