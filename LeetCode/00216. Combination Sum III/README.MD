# Backtrack
* Time Complexity: O(c(9, k)*k)
* Space Complexity: O(9)
```
class Solution {
    List<List<Integer>> list = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, 0);
        return list;
    }
    public void combinationSum3(int k, int n, int index, int sum){
        if(path.size() > k || sum > n){
            return;
        }
        if(sum == n && k == path.size()){
            list.add(new ArrayList(path));
            return;
        }
        for(int i = index; i <= 9; i++){
            sum += i;
            path.add(i);
            combinationSum3(k, n, i+1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
```