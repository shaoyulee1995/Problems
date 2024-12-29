# Sort Integers by The Number of 1 Bits

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] %= 10001;
        }
        return arr;
    }
}
```