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
# Two HashMaps
* Time Complexity: O(N+M)
* Space Complexity: O(N+M)
	* N as length of nums1
	* M as length of nums2
```
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> nums1Map = new HashMap(),
                                  nums2Map = new HashMap();
        for(int num: nums1){
            nums1Map.put(num, nums1Map.getOrDefault(num, 0) + 1);
        }
        for(int num: nums2){
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList();
        for(Map.Entry<Integer, Integer> m: nums1Map.entrySet()){
            int key = m.getKey(),
                value = m.getValue();
            if(nums2Map.containsKey(key)){
                while(nums2Map.get(key) > 0 && value > 0){
                    res.add(key);
                    nums2Map.put(key, nums2Map.get(key) - 1);
                    value--;
                }
            }
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for(int num: res){
            ans[idx++] = num;
        }
        return ans;
    }
}
```