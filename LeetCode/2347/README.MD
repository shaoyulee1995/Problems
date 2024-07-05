# Best Poker Hand

# HashMap, PriorityQueue

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of ranks

```
class Solution {
    public String bestHand(int[] ranks, char[] s) {
        if(s[0] == s[1] && s[1] == s[2] && s[2] == s[3] && s[3] == s[4]){
            return "Flush";
        }
        int max = 0;
        HashMap<Integer, List<Character>> map = new HashMap();
        for(int i = 0; i < ranks.length; i++){
            map.computeIfAbsent(ranks[i], x -> new ArrayList<>()).add(s[i]);
            max = Math.max(max, map.get(ranks[i]).size());
        }
        if(max >= 3){
            return "Three of a Kind";
        }
        if(max == 2){
            return "Pair";
        }
        return "High Card";
    }
}
```

# HashMaps

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of ranks

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
        if(rankMap.containsValue(4) || rankMap.containsValue(3)){
            return "Three of a Kind";
        }
        if(rankMap.containsValue(2)){
            return "Pair";
        }
        return "High Card";
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of ranks

```
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if(suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3]&& suits[3] == suits[4]){
            return "Flush";
        }
        int[] cnt = new int[14];
        IntStream.of(ranks).forEach(x -> cnt[x]++);
        int max = IntStream.of(cnt).max().getAsInt();
        if(max >= 3){
            return "Three of a Kind";
        }
        if(max == 2){
            return "Pair";
        }
        return "High Card";
    }
}
```
