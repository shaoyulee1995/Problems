# Sliding Windows
* sliding the windows on the right pointer that contains all of the characters in String t
* sliding the windows on the left pointer to squeeze the windows' size; howevevr, you still have to contains all of the Character in String t

## Java
* Time Complexity: O(N*N)
* Space Complexity: O(N)
```
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0,
            j = 0,
            tSize = map.size(),
            ansStart = 0,
            ansEnd = Integer.MAX_VALUE;
        while(j < s.length()){
            while(j < s.length() && tSize > 0){
                char c = s.charAt(j++);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0){
                        tSize--;
                    }
                }
            }
            while(tSize == 0 && i < s.length()){
                if(ansEnd - ansStart > j - i){
                    ansEnd = j;
                    ansStart = i;
                }
                char c = s.charAt(i++);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) == 1){
                        tSize++;
                    }
                }
            }
        }
        if(ansEnd == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(ansStart, ansEnd);
    }
}
```

## C++
```
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