# Group Anagrams

- Time Complexity: O(Nwlog(w))
- Space Complexity: O(N)
  - N as length of strs
  - w as length of str

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sortedLetters = String.valueOf(letters);
            map.computeIfAbsent(sortedLetters, x -> new ArrayList());
            map.get(sortedLetters).add(str);
        }
        return new ArrayList(map.values());
    }
}
```

- Time Complexity: O(Nw)
- Space Complexity: O(N)
  - N as length of strs
  - w as length of str

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] letters = new char[26];
            for (char c : str.toCharArray()) {
                letters[c - 'a']++;
            }
            String sortedLetters = String.valueOf(letters);
            map.computeIfAbsent(sortedLetters, x -> new ArrayList());
            map.get(sortedLetters).add(str);
        }
        return new ArrayList(map.values());
    }
}
```