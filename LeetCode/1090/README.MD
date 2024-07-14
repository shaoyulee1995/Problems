# Largest Values From Labels

# PriorityQueue

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of values

```java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Item> list = new ArrayList();
        for(int i = 0; i < values.length; i++){
            list.add(new Item(values[i], labels[i]));
        }
        PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        pq.addAll(list);
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        while(!pq.isEmpty() && numWanted > 0){
            Item item = pq.poll();
            map.put(item.label, map.getOrDefault(item.label, 0) + 1);
            if(map.get(item.label) <= useLimit){
                res += item.val;
                numWanted--;
            }
        }
        return res;
    }
}

class Item{
    int val, label;
    public Item(int val, int label){
        this.val = val;
        this.label = label;
    }
}
```
