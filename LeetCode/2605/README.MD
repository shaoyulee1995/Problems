# Form Smallest Number From Two Digit Arrays

- Time Complexity: O(Max(N,M))
- Space Complexity: O(Max(N,M))
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = getHashSet(nums1),
                         s2 = getHashSet(nums2);
        s1.retainAll(s2);
        if(!s1.isEmpty()){
            return s1.stream().mapToInt(i->i).min().getAsInt();
        }
        int x = IntStream.of(nums1).min().getAsInt(),
            y = IntStream.of(nums2).min().getAsInt();
        return Math.min(x, y)*10 + Math.max(x, y);
    }

    public HashSet<Integer> getHashSet(int[] nums){
        HashSet<Integer> res = new HashSet();
        for(int num: nums){
            res.add(num);
        }
        return res;
    }
}
```
