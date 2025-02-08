# Neither Minimum nor Maximum

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the array

```java
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length == 2){
            return -1;
        }
        int max = Arrays.stream(nums).max().getAsInt(),
            min = Arrays.stream(nums).min().getAsInt();
        for(int num: nums){
            if(num != min && num != max){
                return num;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as the length of the array

```java

class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length < 3){
            return -1;
        }
        Arrays.sort(nums, 0, 3);
        return nums[1];
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {

    public int findNonMinOrMax(int[] nums) {
        if(nums.length < 3){
            return -1;
        }
        int min = Math.min(nums[0], 
                  Math.min(nums[1],
                           nums[2])),
            max = Math.max(nums[0], 
                  Math.max(nums[1],
                           nums[2]));
        for(int i = 0; i < 3; i++){
            if(nums[i] > min && nums[i] < max){
                return nums[i];
            }
        }
        return -1;
    }
}
```
