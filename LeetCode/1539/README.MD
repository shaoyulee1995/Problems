# Kth Missing Positive Number

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of arr

```
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int a: arr){
            if(a > k){
                break;
            }
            k++;
        }
        return k;
    }
}
```
