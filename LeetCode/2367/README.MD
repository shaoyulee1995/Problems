# Number of Arithmetic Triplets
# HashSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet();
        int res = 0;
        for(int num: nums){
            if(num >= 2*diff && set.contains(num-diff) && set.contains(num-2*diff)){
                res++;
            }
            set.add(num);
        }
        return res;
    }
}
```