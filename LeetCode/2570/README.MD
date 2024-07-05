# Merge Two 2D Arrays by Summing Values

- Time Complexity: O(Min(N, M))
- Space Complexity: O(N+M)
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0,
            j = 0;
        List<int[]> res = new ArrayList();
        while(i < nums1.length && j < nums2.length){
            int[] a = nums1[i],
                  b = nums2[j];
            if(a[0] == b[0]){
                res.add(new int[]{a[0], a[1] + b[1]});
                i++;
                j++;
            }else if(a[0] < b[0]){
                res.add(a);
                i++;
            }else{
                res.add(b);
                j++;
            }
        }
        while(i < nums1.length){
            res.add(nums1[i++]);
        }
        while(j < nums2.length){
            res.add(nums2[j++]);
        }
        return res.toArray(int[][]:: new);
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N+M)
  - N as length of nums1
  - M as length of nums2

```java
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int[] num: nums1){
            map.put(num[0], num[1]);
        }
        for(int[] num: nums2){
            if(map.containsKey(num[0])){
                map.put(num[0], map.get(num[0]) + num[1]);
            }else{
                map.put(num[0], num[1]);
            }
        }
        List<int[]> res = new ArrayList();
        for(int key: map.keySet()){
            res.add(new int[]{key, map.get(key)});
        }
        return res.toArray(int[][]:: new);
    }
}
```
