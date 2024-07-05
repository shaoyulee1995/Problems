# Detect Capital

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean detectCapitalUse(String word) {
        int capital = 0;
        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c)){
                capital++;
            }
        }
        if(capital == word.length() || capital == 0){
            return true;
        }
        return capital == 1 && Character.isUpperCase(word.charAt(0));
    }
}
```
