# Subarray Sum Equals K

# HashMap

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
```

# Cumulative Sum

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= nums.length; j++){
                if(sums[j] - sums[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
```

# Cumulative Sum without Space

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    res++;
                }
            }
        }
        return res;
    }
}
```
