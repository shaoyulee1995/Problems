# Valid Word Abbreviation

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```java
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0,
            j = 0;
        while(i < word.length() && j < abbr.length()){
            char w = word.charAt(i),
                 a = abbr.charAt(j);
            if(w == a){
                i++; j++;
                continue;
            }
            if(a > '9' || a <= '0'){
                return false;
            }
            int numIdx = j;
            while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
                ++j;
            }
            int numLength = Integer.valueOf(abbr.substring(numIdx, j));
            i += numLength;
        }
        return i == word.length() && j == abbr.length();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```java
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        return validWordAbbreviation(word, 0, abbr, 0);
    }
    public boolean validWordAbbreviation(String word, int i, String abbr, int j){
        if(i == word.length() && j == abbr.length()){
            return true;
        }
        if(i == word.length() || j == abbr.length()){
            return false;
        }
        if(word.charAt(i) == abbr.charAt(j)){
            return validWordAbbreviation(word, i+1, abbr, j+1);
        }
        if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9'){
            return false;
        }
        int len = 0;
        while(j < abbr.length() && abbr.charAt(j) <= '9' && abbr.charAt(j) >= '0'){
            len = len*10 + (abbr.charAt(j) - '0');
            j++;
        }
        return validWordAbbreviation(word, len + i, abbr, j);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of word

```java
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0,
            j = 0,
            number = 0;
        while(i < word.length() && j < abbr.length()){
            if(Character.isDigit(abbr.charAt(j))){
                number = number*10 + abbr.charAt(j) - '0';
                if(number == 0){
                    return false;
                }
                j++;
            }else{
                i += number;
                if(i >= word.length() || word.charAt(i) != abbr.charAt(j)){
                    return false;
                }
                i++;
                j++;
                number = 0;
            }
        }
        i += number;
        return i == word.length() && j == abbr.length();
    }
}
```
