# Two Sum Less Than K

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int res = -1;
        for(int i = 0; i+1 < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum < k && sum > res){
                    res = sum;
                }
            }
        }
        return res;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0,
            j = nums.length-1,
            res = -1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < k){
                res = Math.max(res, sum);
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet();
        int res = -1;
        for(int num: nums){
            Integer prev = set.lower(k-num);
            if(prev != null){
                res = Math.max(res, prev+num);
            }
            set.add(num);
        }
        return res;
    }
}
```
