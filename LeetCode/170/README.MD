# Two Sum III - Data structure design

# HashMap

- Space Complexity: O(N)
  - N as added elements

## add

- Time Complexity: O(1)
- Space Complexity: O(1)

## find

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as added elements

```
class TwoSum {
    HashMap<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int curValue = it.next(),
                complement = value - curValue;
            if(curValue != complement){
                if(map.containsKey(complement)){
                    return true;
                }
            }else{
                if(map.get(complement) >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}

Your TwoSum object will be instantiated and called as such:
TwoSum obj = new TwoSum();
obj.add(number);
boolean param_2 = obj.find(value);
```
