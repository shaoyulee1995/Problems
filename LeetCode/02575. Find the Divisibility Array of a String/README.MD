# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of word
```
class Solution {
    public int[] divisibilityArray(String word, int m) {
        long v = 0;
        int[] res = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            v = ((v*10) + (word.charAt(i) -'0'))%m;
            res[i] = (v == 0)? 1: 0;
        }
        return res;
    }
}
```