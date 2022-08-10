# HashMap, PriorityQueue
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of ranks
```
class Solution {
    public String bestHand(int[] ranks, char[] s) {
        if(s[0] == s[1] && s[1] == s[2] && s[2] == s[3] && s[3] == s[4]){
            return "Flush";
        }
        HashMap<Integer, List<Character>> map = new HashMap();
        for(int i = 0; i < ranks.length; i++){
            map.putIfAbsent(ranks[i], new ArrayList());
            map.get(ranks[i]).add(s[i]);
        }
        PriorityQueue<Map.Entry<Integer, List<Character>>> pq = new PriorityQueue<>((a,b) -> b.getValue().size() - a.getValue().size());
        for(Map.Entry<Integer, List<Character>> entry: map.entrySet()){
            pq.add(entry);
        }
        while(!pq.isEmpty()){
            Map.Entry<Integer, List<Character>> entry = pq.poll();
            if(entry.getValue().size() >= 3){
                return "Three of a Kind";
            }
            if(entry.getValue().size() == 2){
                return "Pair";
            }
        }
        return "High Card";
    }
}
# 2 HashMaps	
```
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of ranks
```
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer, Integer> rankMap = new HashMap();
        HashMap<Character, Integer> suitMap = new HashMap();
        for(char suit: suits){
            suitMap.put(suit, suitMap.getOrDefault(suit, 0) + 1);
        }
        for(int rank: ranks){
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        if(suitMap.containsValue(5)){
            return "Flush";
        }
        if(rankMap.containsValue(5) || rankMap.containsValue(4) || rankMap.containsValue(3)){
            return "Three of a Kind";
        }
        if(rankMap.containsValue(2)){
            return "Pair";
        }
        return "High Card";
    }
}
```