# Shortest Way to Form String

- Time Complexity: O(ST)
- Space Complexity: O(1)
  - S as length of source
    - T as length of target

```java
class Solution {
    public int shortestWay(String source, String target) {
        int[] cnt = new int[26];
        for(char c: source.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c: target.toCharArray()){
            if(cnt[c-'a'] == 0){
                return -1;
            }
        }
        int j = 0,
            res = 0;
        while(j < target.length()){
            int i = 0;
            while(i < source.length() && j < target.length()){
                if(source.charAt(i) == target.charAt(j)){
                    j++;
                }
                i++;
            }
            res++;
        }
        return res;
    }
}
```
