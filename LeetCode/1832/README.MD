# Check if the Sentence Is Pangram

# Counting Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of sentence

```
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        for(char c: sentence.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 0){
                return false;
            }
        }
        return true;
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of sentence

```
class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26){
            return false;
        }
        for(char c = 'a'; c <= 'z'; c++){
            if(!sentence.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }
}
```
