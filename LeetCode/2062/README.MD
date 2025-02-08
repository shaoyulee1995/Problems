# Count Vowel Substrings of a String

- Time Complexity: O(Nk)
- Space Complexity: O(N)
  - N as the length of the string
  - k as the number of vowels

```java

class Solution {
    public int countVowelSubstrings(String word) {
        return atMost(word, 5) - atMost(word, 4);
    }

    public int atMost(String word, int k){
        HashMap<Character, Integer> map = new HashMap();
        int res = 0;
        for(int i = 0, j = 0; j < word.length(); j++){
            char c = word.charAt(j);
            if(!isVowel(c)){
                map.clear();
                i = j+1;
                continue;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                char prev = word.charAt(i);
                map.put(prev, map.get(prev)-1);
                if(map.get(prev) == 0){
                    map.remove(prev);
                }
                i++;
            }
            res += (j-i+1);
        }
        return res;
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as the length of the string

```java
class Solution {

    public int countVowelSubstrings(String word) {
        int res = 0;
        for(int i = 0; i+4 < word.length(); i++){
            HashSet<Character> set = new HashSet();
            for(int j = i; j < word.length(); j++){
                if(!isVowel(word.charAt(j))){
                    break;
                }
                set.add(word.charAt(j));
                if(set.size() == 5){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
```