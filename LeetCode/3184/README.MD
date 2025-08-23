# Count Pairs That Form a Complete Day I

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of hours

```java
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        int res = 0;
        for(int hour: hours){
            int remainder = hour%24;
            if(remainder == 0){
                res += map.get(0);
            }else{
                res += map.getOrDefault(24-remainder, 0);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
}
```
- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of hours

```java
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int res = 0;
        for(int i = 0; i+1 < hours.length; i++){
            for(int j = i+1; j < hours.length; j++){
                res += ((hours[i] + hours[j])%24 == 0)? 1: 0;
            }
        }
        return res;  
    }
}
```