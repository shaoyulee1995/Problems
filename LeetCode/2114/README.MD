# Maximum Number of Words Found in Sentences

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of sentences
    - M as length of sentence

```java
class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for(String sentence: sentences){
            res = Math.max(res, sentence.split(" ").length);
        }
        return res;
    }
}
```

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of sentences
    - M as length of sentence

```java
class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for(String sentence: sentences){
            int total = 0;
            for(char c: sentence.toCharArray()){
               total += (c == ' ')? 1: 0;
            }
            res = Math.max(res, total);
        }
        return res+1;
    }
}
```
