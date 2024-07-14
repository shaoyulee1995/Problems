# Counting Words With a Given Prefix

- Time Complexity: O(WP)
- Space Complexity: O(1)
  - W as length of words
  - P as pref

```java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String word: words){
            if(word.indexOf(pref) == 0){
                res++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(WP)
- Space Complexity: O(1)
  - W as length of words
  - P as pref

```java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String word: words){
            if(word.length() >= pref.length() && word.substring(0, pref.length()).equals(pref)){
                res++;
            }
        }
        return res;
    }
}
```
