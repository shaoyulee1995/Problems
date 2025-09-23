# Find Resultant Array After Removing Anagrams

- Time Complexity: O(NWlogW)
- Space Complexity: O(N)
  - N as length of nums
  - W as length of word

```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList();
        String prev = null;
        for(String word: words){
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            if(!String.valueOf(characters).equals(prev)){
                res.add(word);
                prev = String.valueOf(characters);
            }
        }
        return res;
    }
}
```

- Time Complexity: O(NW)
- Space Complexity: O(N)
  - N as length of nums
  - W as length of word

```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        if(words.length == 0){
            return new ArrayList();
        }
        List<String> res = new ArrayList();
        res.add(words[0]);
        for(int i = 1; i < words.length; i++){
            if(!isAnagram(words[i], words[i-1])){
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean isAnagram(String current, String prev){
        if(current.length() != prev.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(char c: current.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c: prev.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a'] < 0){
                return false;
            }
        }
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
}
```