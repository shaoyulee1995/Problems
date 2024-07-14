# First Unique Character in a String

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i)-'a';
            arr[index]++;
        }
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i)-'a';
            if(arr[index] == 1){
                return i;
            }
        }
        return -1;
    }
}
```
