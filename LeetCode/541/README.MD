# Reverse String II

- Time Complexity: O((N)
- Space Complexity: O(N)

```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i+=2*k){
            int start = i,
                end = Math.min(s.length()-1, i+k-1);
            while(start < end){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; end--;
            }
        }
        return new String(arr);
    }
}
```
