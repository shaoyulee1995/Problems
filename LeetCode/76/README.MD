# Minimum Window Substring

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int i = 0,
            j = 0,
            minStart = 0,
            minEnd = Integer.MAX_VALUE,
            size = map.size();
        while (j < s.length()) {
            char c = s.charAt(j++);
            if (map.containsKey(c)) {
                map.merge(c, -1, Integer::sum);
                if (map.get(c) == 0) {
                    size--;
                }
            }
            while (size == 0 && i < s.length()) {
                if (j - i < minEnd - minStart) {
                    minEnd = j;
                    minStart = i;
                }
                c = s.charAt(i++);
                if (map.containsKey(c)) {
                    map.merge(c, 1, Integer::sum);
                    if (map.get(c) == 1) {
                        size++;
                    }
                }
            }
        }
        return (minEnd == Integer.MAX_VALUE) ? "" : s.substring(minStart, minEnd);
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of s
  
```java
class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128],
              sFreq = new int[128];
        int i = 0,
            j = 0,
            minStart = 0,
            minEnd = Integer.MAX_VALUE,
            size = 0;
        for (char c : t.toCharArray()) {
            if (tFreq[c] == 0) {
                size++;
            }
            tFreq[c]++;
        }
        while (j < s.length()) {
            char c = s.charAt(j++);
            if (tFreq[c] > 0) {
                sFreq[c]++;
                if (sFreq[c] == tFreq[c]) {
                    size--;
                }
            }
            while (size == 0 && i < s.length()) {
                if (j - i < minEnd - minStart) {
                    minEnd = j;
                    minStart = i;
                }
                c = s.charAt(i++);
                if (tFreq[c] > 0) {
                    sFreq[c]--;
                    if (sFreq[c] < tFreq[c]) {
                        size++;
                    }
                }
            }
        }
        return (minEnd == Integer.MAX_VALUE) ? "" : s.substring(minStart, minEnd);
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of s

```cpp
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> m;
        for(auto c: t){
            m[c]++;
        }
        size_t start = 0, end = 0, counter = t.size(), minStart = 0, minLen = INT_MAX;
        size_t size = s.size();

        while(end < size){
            if(m[s[end]] > 0){
                counter--;
            }
            m[s[end]]--;
            end++;
            while(counter == 0){
                if(end - start < minLen){
                    minStart = start;
                    minLen = end - start;
                }
                m[s[start]]++;
                if(m[s[start]] > 0){
                    counter++;
                }
                start++;
            }
        }
        return (minLen == INT_MAX)?"":s.substr(minStart, minLen);
    }
};
```
