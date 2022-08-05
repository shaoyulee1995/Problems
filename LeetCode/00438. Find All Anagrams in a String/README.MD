# Sliding Windows
* Time Complexity: O(S)
* Space Complexity: O(P)
	* S as length of s
	* P as length of p
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
# Counting Array
* Time Complexity: O(S)
* Space Complexity: O(P)
	* S as length of s
	* P as length of p
```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cntS = new int[26],
              cntP = new int[26];
        for(char pp: p.toCharArray()){
            cntP[pp-'a']++;
        }
        List<Integer> res = new ArrayList();
        for(int i = 0; i < s.length(); i++){
            char ss = s.charAt(i);
            cntS[ss-'a']++;
            
            if(i-p.length() >= 0){
                char restore = s.charAt(i-p.length());
                cntS[restore-'a']--;
            }
            if(i - p.length() + 1 >= 0){
                boolean same = true;
                for(int j = 0; j < 26; j++){
                    if(cntP[j] != cntS[j]){
                        same = false;
                        break;
                    }
                }
                if(same){
                    res.add(i - p.length() + 1);
                }
            }
        }
        return res;
    }
}
```