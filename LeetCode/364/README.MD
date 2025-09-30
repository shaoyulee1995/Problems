# Nested List Weight Sum II

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
- Space Complexity: O(N)
  - N as length of linkedlist

```java
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int prevSum = 0,
            totalSum = 0;
        Deque<NestedInteger> queue = new ArrayDeque();
        for(NestedInteger currentList: nestedList){
            queue.add(currentList);
        }
        while(!queue.isEmpty()){
            int size = queue.size(),
                currentSum = 0;
            for(int i = 0; i < size; i++){
                NestedInteger current = queue.poll();
                if(current.isInteger()){
                    currentSum += current.getInteger();
                }else{
                    for(NestedInteger currentList: current.getList()){
                        queue.offerLast(currentList);
                    }
                }
            }
            prevSum += currentSum;
            totalSum += prevSum;
        }
        return totalSum;
    }
}
```