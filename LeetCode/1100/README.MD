# Find K-Length Substrings With No Repeated Characters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        HashSet<Character> seen = new HashSet();
        for(int i = 0, j = 0; j < s.length(); j++){
            while(seen.contains(s.charAt(j))){
                seen.remove(s.charAt(i++));
            }
            seen.add(s.charAt(j));
            if(j-i+1 >= k){
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(26)
  - N as length of s

```java
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0;
        int[] count = new int[26];
        for(int i = 0, j = 0; j < s.length(); j++){
            int indexJ = s.charAt(j)-'a';

            while(count[indexJ] > 0){
                count[s.charAt(i++)-'a']--;
            }
            count[indexJ]++;
            if(j-i+1 >= k){
                res++;
            }
        }
        return res;
    }
}
```