# Prefix Sum
* Time Complexity: O(N)
	* increment: O(1)
* Space Complexity: O(N)
```
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference df = new Difference(res);
        for(int[] booking: bookings){
		    //if the index isn't start from 0
            int i = booking[0] - 1,
                j = booking[1] - 1,
                k = booking[2];
            df.increment(i, j, k);
        }
        return df.result();
    }
    class Difference{
        private int[] diff;
        public Difference(int[] nums){
            diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                diff[i] = nums[i] - nums[i-1];
            }
        }
        public void increment(int i, int j, int val){
            diff[i] += val;
            if(j + 1 < diff.length){
                diff[j+1] -= val;
            }
        }
        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for(int i = 1; i < diff.length; i++){
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
```