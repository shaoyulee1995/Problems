# Uncommon Words from Two Sentences

- Time Complexity: O(N+M)
- Space Complexity: O(N+M)
  - N as length of s1
  - M as length of s2

```
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap();
        for(String v: s1.split(" ")){
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        for(String v: s2.split(" ")){
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<String> res = new ArrayList();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                res.add(entry.getKey());
            }
        }
        return res.toArray(String[]:: new);
    }
}
```
