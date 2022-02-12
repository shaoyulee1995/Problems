# Bucket Sort
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        //key: num, val: freq
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //list array bucket
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(key);
        }
        
        int[] res = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0 && index < k; i--){
            if(bucket[i] == null){
                continue;
            }
            for(int j = 0; index < k && j < bucket[i].size(); j++){
                res[index] = bucket[i].get(j);
                index++;
            }
        }
        return res;
    }
}
```