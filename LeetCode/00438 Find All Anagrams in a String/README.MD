# Sliding Windows
* Time Complexity: O(max(N, M))
* Space Complexity: O(1)
	* N: length of t
	* M: length of p

## Java

```
class Solution {
    public List<Integer> findAnagrams(String t, String p) {
        List<Integer> result = new LinkedList();
        if(t.length() < p.length()){
            return result;
        }
        HashMap<Character, Integer> map = new HashMap();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int l = 0, r = 0, len = Integer.MAX_VALUE, head = 0;
        while(r < t.length()){
            char cur = t.charAt(r);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0){
                    counter--;
                }
            }
            r++;
            while(counter == 0){
                char temp = t.charAt(l);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0){
                        counter++;
                    }
                }
                if(r-l == p.length()){
                    result.add(l);
                }
                l++;
            }
        }
        return result;
    }
}
```