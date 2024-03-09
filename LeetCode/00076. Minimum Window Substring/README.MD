# Sliding Windows
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
```
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: t.toCharArray()){ 
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int size = map.size(),
            i = 0,
            j = 0,
            minStart = 0,
            minEnd = Integer.MAX_VALUE;
        while(j < s.length()){
            while(j < s.length() && size > 0){
                char c = s.charAt(j);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)-1);
                    if(map.get(c) == 0){
                        size--;
                    }
                }
                j++;
            }
            while(size == 0 && i < s.length()){
                if(minEnd - minStart > j - i){
                    minEnd = j;
                    minStart = i;
                }
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    if(map.get(c) == 1){
                        size++;
                    }
                }
                i++;
            }
        }
        return minEnd == Integer.MAX_VALUE? "": s.substring(minStart, minEnd);
    }
}
```
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