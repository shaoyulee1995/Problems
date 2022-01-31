# Backtrack
* Time Complexity: O(2^N)
* Space Complexity: O(N)
	* N as length of candidates
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0);
        return list;
    }
    public void combinationSum2(int[] candidates, int target, int index){
        if(target == 0){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target - candidates[i] < 0){
                continue;
            }
            target -= candidates[i];
            path.add(candidates[i]);
            combinationSum2(candidates, target, i + 1);
            target += candidates[i];
            path.removeLast();
        }
    }
}
```