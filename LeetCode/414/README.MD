# Third Maximum Number

# TreeSet

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums){
            set.add(num);
            if(set.size() > 3){
                set.pollFirst();
            }
        }
        if(set.size() < 3){
            while(set.size() > 1){
                set.pollFirst();
            }
        }
        return set.pollFirst();
    }
}
```
