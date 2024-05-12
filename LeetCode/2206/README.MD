# Divide Array Into Equal Pairs
# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(501)
	* N as length of nums
```
class Solution {
    public boolean divideArray(int[] nums) {
        int[] cnt = new int[501];
        for(int num: nums){
            cnt[num]++;
        }
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
```
# Set
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num: nums){
            if(!set.add(num)){
                set.remove(num);
            }
        }
        return set.isEmpty();
    }
}
```