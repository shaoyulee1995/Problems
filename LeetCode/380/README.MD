# Insert Delete GetRandom O(1)

# HashMap, Swap

- insert
  - Time Complexity: O(1)
- remove
  - Time Complexity: O(1)
    \*getRandom \* Time Complexity: O(1)
- Space Complexity: O(N)
  - N as number of val in map

```
class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int position = map.get(val);
        if(position != list.size() - 1){
            int lastone = list.get(list.size() - 1);
            list.set(position, lastone);
            map.put(lastone, position);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
```

```
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```
