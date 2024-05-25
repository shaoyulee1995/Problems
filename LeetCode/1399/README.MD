# Count Largest Group

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public int countLargestGroup(int n) {
        int[] dp = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 1; i <= n; i++){
            dp[i] = i%10 + dp[i/10];
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }
        int res = 0,
            maxFreq = 0;
        for(int key: map.keySet()){
            if(map.get(key) > maxFreq){
                maxFreq = map.get(key);
                res = 1;
            }else if(map.get(key) == maxFreq){
                res++;
            }
        }
        return res;
    }
}
```
