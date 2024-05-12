# Shortest Distance to Target String in a Circular Array
# Array
* Time Complexity: O(NT)
* Space Complexity: O(1)
    * N as length of words
    * T as target
```
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                int d = Math.abs(startIndex - i);
                res = Math.min(res, d);
                res = Math.min(res, words.length-d);
            }
        }
        return res==Integer.MAX_VALUE? -1: res;
    }
}
```