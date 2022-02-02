# HashMap
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of nums1
	* M as length of nums2
```
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList();
        for(int num: nums2){
            if(map.get(num) != null && map.get(num) > 0){
                map.put(num, map.get(num) - 1);
                list.add(num);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
```