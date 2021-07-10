# Sliding Windows
* sliding the windows on the right pointer that contains all of the characters in String t
* sliding the windows on the left pointer to squeeze the windows' size; howevevr, you still have to contains all of the Character in String t

## Java
```
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int ansFrom = 0, ansEnd = Integer.MAX_VALUE;
        int tSize = map.size();
        while(right < s.length()){
            while(right < s.length() && tSize > 0){
                char cur = s.charAt(right);
                if(map.containsKey(cur)){
                    map.put(cur, map.get(cur) - 1);
                    if(map.get(cur) == 0){
                        tSize--;
                    }
                }
                right++;
            }
            
            while(left < s.length() && tSize == 0){
                if(ansEnd - ansFrom > right - left){
                    ansEnd = right;
                    ansFrom = left;
                }
                char cur = s.charAt(left);
                if(map.containsKey(cur)){
                    map.put(cur, map.get(cur) + 1);
                    if(map.get(cur) == 1){
                        tSize++;
                    }
                }
                left++;
            }
        }
        return (ansEnd == Integer.MAX_VALUE)?"":s.substring(ansFrom, ansEnd);
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