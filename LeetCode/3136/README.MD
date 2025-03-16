# Valid Word

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the word

```java
class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        boolean isVowel = false,
                isConsonant = false;
        for(char c: word.toCharArray()){
            if(!Character.isDigit(c) && !Character.isLetter(c)){
                return false;
            }
            if(Character.isLetter(c)){
                if(isVowel(c)){
                    isVowel = true;
                }else{
                    isConsonant = true;
                }
            }
        }
        return isVowel && isConsonant;
    }

    private boolean isVowel(char c){
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
               c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```