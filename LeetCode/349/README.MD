# Intersection of Two Arrays

# HashSet

- Time Complexity: O(Max(N, M))
- Space Complexity: O(Min(N, M))
  - N as length of nums1
  - M as length of nums2

```
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums1){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList();
        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
```
