# Detect Pattern of Length M Repeated K or More Times

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of arr
```java
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i = 0, j = m+i, count = 0; j < arr.length; j++, i++){
            if(arr[i] != arr[j]){
                count = 0;
            }else if(++count == (k-1)*m){
                return true;
            }
        }        
        return false;
    }
}
```