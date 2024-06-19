# Replace Elements with Greatest Element on Right Side

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of arr

```
class Solution {
    public int[] replaceElements(int[] arr) {
        for(int max = arr[arr.length-1], i = arr.length-2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        arr[arr.length-1] = -1;
        return arr;
    }
}
```
