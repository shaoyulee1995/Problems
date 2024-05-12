# Contains Duplicate
# Set
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums 
```
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
```
# Map
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums 
```
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > 1){
                return true;
            }
        }
        return false;
    }
}
```