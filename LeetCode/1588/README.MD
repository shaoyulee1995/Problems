# Sum of All Odd Length Subarrays

# Math

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            int start = i+1,
                end = arr.length - i,
                total = start * end,
                cnt = total / 2;
            if(total%2 == 1){
                cnt++;
            }
            res += cnt * arr[i];
        }
        return res;
    }
}
```
