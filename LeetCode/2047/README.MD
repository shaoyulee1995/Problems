# Number of Valid Words in a Sentence

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of sentence

```java
class Solution {
    public int countValidWords(String sentence) {
        String[] strs = sentence.strip().split("\\s+");
        int res = 0;
        for(String str: strs){
          if(isValid(str)){
            res++;
          }
        }
        return res;
    }

    public boolean isValid(String str){
        int hyphen = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                return false;
            }
            if(Character.isLowerCase(c)){
                continue;
            }
            if(c == '-'){
                hyphen++;
                if(hyphen > 1){
                    return false;
                }
                if(i-1 < 0 || !Character.isLowerCase(str.charAt(i-1)) || i+1 == str.length() || !Character.isLowerCase(str.charAt(i+1))){
                    return false;
                }
            }else if(c == '!' || c == '.' || c == ','){
                if(i+1 != str.length()){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
```