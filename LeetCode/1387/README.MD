# Sort Integers by The Power Value

# PriorityQueue

- Time Complexity: O(IDK)
- Space Complexity: O(N)
  - N as length of [lo, hi]
  - IDK as I don't know

```java
class Solution{
    HashMap<Integer, Integer> map;
    public int getKth(int lo, int hi, int k) {
        map = new HashMap();
        map.put(1,0);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> power(a) != power(b)?
                                                        power(b) - power(a):
                                                        b - a);
        for(int i = lo; i <= hi; i++){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public int power(int num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        int steps = 1 + ((num%2 == 0)? power(num/2): power(3*num+1));
        map.put(num, steps);
        return steps;
    }
}
```
