# Find All Anagrams in a String

- Time Complexity: O(S)
- Space Complexity: O(P)
  - S as length of s
  - P as length of p

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : p.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        if (s.length() < p.length()) {
            return new ArrayList();
        }
        int i = 0,
            j = 0,
            size = map.size();
        while (i < s.length() && j < s.length()) {
            while (j < s.length() && size > 0) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.merge(c, -1, Integer::sum);
                    if (map.get(c) == 0) {
                        size--;
                    }
                }
                j++;
            }
            while (size == 0) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.merge(c, 1, Integer::sum);
                    if (map.get(c) > 0) {
                        size++;
                    }
                }
                if (j - i == p.length()) {
                    res.add(i);
                }
                i++;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(S)
- Space Complexity: O(P)
  - S as length of s
  - P as length of p

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int[] source = new int[26],
              target = new int[26];
        for(char c: p.toCharArray()){
            target[c-'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            source[c-'a']++;
            if(i >= p.length() - 1){
                int startIndex = i - p.length() + 1;
                if(Arrays.equals(target, source)){
                    res.add(startIndex);
                }
                source[s.charAt(startIndex)-'a']--;
            }
        }
        return res;
    }
}
```
