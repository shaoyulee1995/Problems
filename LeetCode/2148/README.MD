# Count Elements With Strictly Smaller and Greater Elements

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int countElements(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt(),
            max = Arrays.stream(nums).max().getAsInt(),
            res = 0;
        for(int num: nums){
            if(num > min && num < max){
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int countElements(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt(),
            max = Arrays.stream(nums).max().getAsInt();
        return (int)Arrays.stream(nums).filter(x-> x < max && x > min).count();
    }
}
```
