# Nested List Weight Sum

```java
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger();

    // Constructor initializes a single integer.
    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nestedList

```java
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0,
            level = 1;
        while(!nestedList.isEmpty()){
            List<NestedInteger> next = new ArrayList();
            for(NestedInteger v: nestedList){
                if(v.isInteger()){
                    res += level * v.getInteger();
                }else{
                    next.addAll(v.getList());
                }
            }
            level++;
            nestedList = next;
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nestedList

```java

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    public int dfs(List<NestedInteger> nestedList, int level){
        int res = 0;
        for(NestedInteger v: nestedList){
            if(v.isInteger()){
                res += level * v.getInteger();
            }else{
                res += dfs(v.getList(), level+1);
            }
        }
        return res;
    }
}
```