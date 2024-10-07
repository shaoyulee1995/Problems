# Count Prefix and Suffix Pairs I

- Time Complexity: O(N<sup>2</sup>W)
- Space Complexity: O(1)
  - N as length of words
  - W as length of words[i]

```java
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for(int i = 0; i+1 < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean isPrefixAndSuffix(String a, String b){
        if(b.indexOf(a) != 0){
            return false;
        }
        if(!b.substring(b.length()-a.length()).equals(a)){
            return false;
        }
        return true;
    }
}
```
