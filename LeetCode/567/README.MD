# Permutation in String

- Time Complexity: O(max(N, M))
- Space Complexity: O(26)
  - N: length of t
  - M: length of p

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i - s1.length() >= 0) {
                char added = s2.charAt(i - s1.length());
                cnt[added - 'a']++;
            }
            char removed = s2.charAt(i);
            cnt[removed - 'a']--;
            if (isZero(cnt)) {
                return true;
            }
        }
        return false;
    }

    private boolean isZero(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(max(N, M))
- Space Complexity: O(26)
  - N: length of s1
  - M: length of s2

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s1.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int size = map.size();
        for (int i = 0; i < s2.length(); i++) {
            if (i - s1.length() >= 0) {
                char added = s2.charAt(i - s1.length());
                map.merge(added, 1, Integer::sum);
            }
            char removed = s2.charAt(i);
            map.merge(removed, -1, Integer::sum);
            if (isFreqZero(map)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFreqZero(HashMap<Character, Integer> map) {
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
```