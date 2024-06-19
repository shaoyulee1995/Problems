# Jewels and Stones

# Counting Array

- Time Complexity: O(S)
- Space Complexity: O(1)
  - S as nodes in stones

```
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] cnt = new int['z'-'A'+1];
        for(char c: jewels.toCharArray()){
            cnt[c-'A']++;
        }
        int res = 0;
        for(char c: stones.toCharArray()){
            res += cnt[c-'A'];
        }
        return res;
    }
}
```

# Set

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as nodes in stones

```
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet();
        for(char c: jewels.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(char c: stones.toCharArray()){
            if(set.contains(c)){
                res++;
            }
        }
        return res;
    }
}
```

# Stream

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as nodes in stones

```
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewels_set = jewels
                                        .chars()
                                        .mapToObj(x -> (char) x)
                                        .collect(Collectors.toSet());
        return stones
                .chars()
                .reduce(0, (x, c) -> x + (jewels_set.contains((char) c)? 1: 0));
    }
}
```
