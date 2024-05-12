# Shortest Word Distance
# Array
* Time Complexity: O(W)
* Space Complexity: O(1)
	* N as length of wordsDict
```
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = Integer.MAX_VALUE,
            b = Integer.MAX_VALUE,
            res = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++){
          if(wordsDict[i].equals(word1)){
            a = i;
          }else if(wordsDict[i].equals(word2)){
            b = i;
          }
          if(a != Integer.MAX_VALUE && b != Integer.MAX_VALUE){
            res = Math.min(res, Math.abs(a-b));
          }
        }
        return res;
    }
}
```