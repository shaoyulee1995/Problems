# Sliding Windows
* Time Complexity: O(S)
* Space Complexity: O(P)

## Java

```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList();
        if(s.length() < p.length()){
            return result;
        }
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int size = map.size();
        while(right < s.length()){
            while(right < s.length() && size > 0){
                char c = s.charAt(right);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0){
                        size--;
                    }
                }
                right++;
            }
            while(size == 0){
                char c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0){
                        size++;
                    }
                }   
                if(right - left == p.length()){
                    result.add(left);
                }
                left++;
            }
        }
        return result;
    }
}
```