# Check if Word Equals Summation of Two Words

# String

- Time Complexity: O(Max(F,S,T))
- Space Complexity: O(1)
  - F as length of firstWord
  - S as length of secondWord
  - T as length of targetWord

```
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getInt(targetWord) == getInt(firstWord) + getInt(secondWord);
    }

    public int getInt(String word){
        int res = 0;
        for(char c: word.toCharArray()){
            res = res*10 + (c-'a');
        }
        return res;
    }
}
```
