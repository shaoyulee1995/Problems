# Maximum Number of Pairs in Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int pairs = 0,
            remain = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pairs += entry.getValue()/2;
            if(entry.getValue()%2 != 0){
                remain += 1;
            }
        }
        return new int[]{pairs, remain};
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums){
            cnt[num]++;
        }
        int pairs = 0,
            remain = 0;
        for(int num: cnt){
            pairs += num/2;
            remain += num%2;
        }
        return new int[]{pairs, remain};
    }
}
```
