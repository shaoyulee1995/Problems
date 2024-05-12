# Sort Characters By Frequency
# PriorityQueue, HashMap
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            char key = (char)e.getKey();
            int cnt = (int)e.getValue();
            while(cnt-- > 0){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}  }
}
```