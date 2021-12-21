# Prefix Sum
* Time Complexity: O(N)
	* increment: O(1)
* Space Complexity: O(1001)
```
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        Difference df = new Difference(res);
        for(int[] trip: trips){
            int val = trip[0],
                from = trip[1],
                to = trip[2] - 1; //drop off the one before.
            df.increment(from, to, val);
        }
        res = df.result();
        for(int i = 0; i < res.length; i++){
            if(res[i] > capacity){
                return false;
            }
        }
        return true;
    }
    class Difference{
        int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }
        public void increment(int from, int to, int val){
            diff[from] += val;
            
            if(to + 1 < diff.length){
                diff[to + 1] -= val;
            }
        }
        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for(int i = 1; i < res.length; i++){
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
```