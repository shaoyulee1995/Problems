# Number of Good Pairs

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int pairs = 0;
        for(int n:nums){
            pairs += count[n]++;
        }
        return pairs;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for(int key: map.keySet()){
            int n = map.get(key);
            if(n > 1){
                res += (n*(n-1))/2;
            }
        }
        return res;
    }
}
```
