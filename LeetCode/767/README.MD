# Reorganize String

# HashMap

- Time Complexity: O(N^2logN)
- Space Complexity: O(N)

```
class Solution {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c: S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(pq.size() > 1){
            char current = pq.poll(),
                 next =pq.poll();
            map.put(current, map.get(current) - 1);
            map.put(next, map.get(next) - 1);
            sb.append(current);
            sb.append(next);

            if(map.get(current) > 0){
                pq.add(current);
            }
            if(map.get(next) > 0){
                pq.add(next);
            }
        }

        if(!pq.isEmpty()){
            char last = pq.poll();
            if(map.get(last) > 1){
                return "";
            }
            sb.append(last);
        }
        return sb.toString();
    }
}
```
