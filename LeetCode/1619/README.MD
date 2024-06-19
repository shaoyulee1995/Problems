# Mean of Array After Removing Some Elements

# Math

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of arr

```
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double res = 0;
        for(int i = arr.length/20; i < (arr.length-arr.length/20); i++){
            res += arr[i];
        }
        return res/(arr.length*0.9);
    }
}
```
