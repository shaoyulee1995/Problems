# Backtrack
* Time Complexity: O(S)
* Space Complexity: O(T)
	* S as the possible sum length
	* T as target
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0);
        return list;
    }
    public void combinationSum(int[] candidates, int target, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                continue;
            }
            target -= candidates[i];
            path.add(candidates[i]);
            combinationSum(candidates, target, i);
            target += candidates[i];
            path.removeLast();
        }
    }
}
```