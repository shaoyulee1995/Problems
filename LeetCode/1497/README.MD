# Check If Array Pairs Are Divisible by k

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in arr

```java
class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num: arr){
            int remainder = (num%k+k)%k,
                complementaryRemainder = (k-remainder)%k;
            if(map.containsKey(complementaryRemainder)){
                res++;
                map.put(complementaryRemainder, map.get(complementaryRemainder)-1);
                if(map.get(complementaryRemainder) == 0){
                    map.remove(complementaryRemainder);
                }
            }else{
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }
        }
        return res == arr.length/2;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as nodes in arr

```java
class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num: arr){
            int remainder = (num%k+k)%k;
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        for(int num: arr){
            int remainder = (num%k+k)%k;
            if(remainder == 0){
                if(map.get(remainder) % 2 == 1){
                    return false;
                }
            }else if(!map.get(remainder).equals(map.get(k - remainder))){
                return false;
            }
        }
        return true;
    }
}
```
