# TreeSet
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for(char c: s.toCharArray()){
            if(c >='0' && c <='9'){
                set.add((Integer)(c-'0'));
            }
        }
        set = (TreeSet)set.descendingSet();
        if(set.size() <= 1){
            return -1;
        }
        set.pollFirst();
        return set.pollFirst();
    }
}
```