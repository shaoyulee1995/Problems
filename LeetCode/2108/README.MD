# Find First Palindromic String in the Array

# String

- Time Complexity: O(Wm)
- Space Complexity: O(1)
  - W as length of words
  - m as maximum length of word

```
class Solution {
    public String firstPalindrome(String[] words) {
        for(String word: words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }

    public boolean isPalindrome(String word){
        int i = 0,
            j = word.length()-1;
        while(i < j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```
