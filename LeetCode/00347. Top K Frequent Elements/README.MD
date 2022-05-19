# Bucket Sort
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){
            if(buckets[i] == null){
                continue;
            }
            for(int j = 0; index < k && j < buckets[i].size(); j++){
                res[index++] = buckets[i].get(j);
            }
        }
        return res;
    }
}
```