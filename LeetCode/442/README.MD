# Find All Duplicates in an Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 1){
                list.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return list;
    }
}
```
