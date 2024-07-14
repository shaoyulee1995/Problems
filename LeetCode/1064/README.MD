# Fixed Point

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public int fixedPoint(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == i){
                return i;
            }
        }
        return -1;
    }
}
```
