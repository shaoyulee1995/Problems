# Backtrack
* Time Complexity: O(c(n, k)*k)
* Space Complexity: O(k)
```
class Solution {
    List<List<Integer>> list;
    LinkedList<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        list = new LinkedList();
        path = new LinkedList();
        combine(n, k, 1);
        return list;
    }
    public void combine(int n, int k, int index){
        if(path.size() == k){
            list.add(new ArrayList(path));
            return;
        }
        for (int i = index; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combine(n, k, i + 1);
            path.removeLast();
        }
    }
}
```