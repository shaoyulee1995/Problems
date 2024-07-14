# Combination Sum III

- Time Complexity: O(c(9, k)\*k)
- Space Complexity: O(9)
  - c as combination
  - k as k

```java
class Solution{
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, 0);
        return res;
    }
    public void combinationSum3(int k, int n, int index, int sum){
        if(sum == n && path.size() == k){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = index; i <= 9; i++){
            if(sum + i > n){
                break;
            }
            path.add(i);
            combinationSum3(k, n, i+1, sum+i);
            path.removeLast();
        }
    }
}
```
