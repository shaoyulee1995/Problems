# Largest Unique Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] cnt = new int[1000+1];
        for(int num: nums){
            cnt[num]++;
        }
        for(int i = cnt.length-1; i >= 0; i--){
            if(cnt[i] == 1){
                return i;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int largestUniqueNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i >=0; i--){
            if(i == 0 || nums[i] != nums[i-1]){
                return nums[i];
            }
            while(i > 0 && nums[i] == nums[i-1]){
                i--;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                res = Math.max(entry.getKey(), res);
            }
        }
        return res;
    }
}
```
