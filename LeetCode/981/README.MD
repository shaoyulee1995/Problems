# Time Based Key-Value Store

# TreeMap

- Space Complexity: O(1)
- set
  - Time Complexity: O(log(N))
    - N as number of timestamps
- get
  - Time Complexity: O(log(N))
    - N as number of timestamps

```
class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> timeMap = map.get(key);
        Integer t = timeMap.floorKey(timestamp);
        return t != null? timeMap.get(t): "";
    }
}
```

```
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```
