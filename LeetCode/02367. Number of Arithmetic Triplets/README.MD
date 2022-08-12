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
            if(set.contains(num - diff) && set.contains(num - diff*2)){
                res++;
            }
            set.add(num);
        }
        return res;
    }
}
```