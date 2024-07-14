# Array of Doubled Pairs

# PriorityQueue

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of arr

```java
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
            return Math.abs(a) - Math.abs(b);
        });
        for(int num: arr){
            pq.add(num);
        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            if(!pq.remove(2*num)){
                return false;
            }
        }
        return true;
    }
}
```

- Time Complexity: O(Nlog(K))
- Space Complexity: O(N)
  - K as different number of arr
  - N as length of arr

```java
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int key: map.keySet()){
            int freqKey = map.get(key),
                target = (key > 0)? key*2: key/2,
                freqTarget = map.getOrDefault(target, 0);
            if(map.get(key) == 0){
                continue;
            }
            if(key < 0 && key % 2 != 0 || freqKey > freqTarget){
                return false;
            }
            map.put(target, freqTarget - freqKey);
        }
        return true;
    }
}
```
