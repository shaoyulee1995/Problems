# Backtrack
* Time Complexity: O(N*2<sup>N</sup>)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return list;
    }
    public void subsets(int[] nums, int index){
        list.add(new ArrayList(path));
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            subsets(nums, i+1);
            path.removeLast();
        }
    }
}
```