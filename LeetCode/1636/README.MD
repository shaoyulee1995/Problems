# Sort Array by Increasing Frequency
# PriorityQueue
* Time Complexity: O(KlogK)
* Space Complexity: O(N)
	* N as length of nums
	* K as key of map
```
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a) == map.get(b)? b-a: map.get(a) - map.get(b)));
        pq.addAll(map.keySet());
        int[] res = new int[nums.length];
        for(int i = 0; !pq.isEmpty();){
            int val = pq.poll(),
                freq = map.get(val);
            for(int j = 0; j < freq; i++, j++){
                res[i] = val;
            }
        }
        return res;
    }
}
```