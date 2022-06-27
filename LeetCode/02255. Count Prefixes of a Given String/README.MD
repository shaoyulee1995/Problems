# String
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(String word: words){
            if(s.indexOf(word) == 0){
                res++;
            }
        }
        return res;
    }
}
```