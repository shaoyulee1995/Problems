# Maximum Number of Pairs in Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            res[0] += entry.getValue()/2;
            res[1] += entry.getValue()%2;
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums){
            cnt[num]++;
        }
        int pair = 0,
            leftOver = 0;
        for(int c: cnt){
            pair += c/2;
            leftOver += c%2;
        }
        return new int[]{pair, leftOver};
    }
}
```
