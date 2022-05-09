# Sliding Windows
* Time Complexity: O(S)
* Space Complexity: O(P)
	* S as length of s
	* P as length of p
## Java
```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int size = map.size(),
            left = 0, 
            right = 0,
            n = s.length(),
            m = p.length();
        if(n < m){
            return new ArrayList();
        }
        List<Integer> list = new ArrayList();
        
        while(left < n && right < n){
            while(right < n && size > 0){
                char r = s.charAt(right);
                if(map.containsKey(r)){
                    map.put(r, map.get(r) - 1);
                    if(map.get(r) == 0){
                        size--;
                    }
                }
                right++;
            }
            while(size == 0){
                char l = s.charAt(left);
                if(map.containsKey(l)){
                    map.put(l, map.get(l) + 1);
                    if(map.get(l) > 0){
                        size++;
                    }
                }
                if(right - left == m){
                    list.add(left);
                }
                left++;
            }
        }
        return list;
    }
}
```