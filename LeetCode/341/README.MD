# Flatten Nested List Iterator

```
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
```

- Time Complexity: O(N)
- Space Complexity: O(N)

```
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    public NestedIterator(List<NestedInteger> nestedList) {
        LinkedList<Integer> list = new LinkedList();
        for(NestedInteger curList: nestedList){
            traverse(curList, list);
        }
        this.it = list.iterator();
    }
    public void traverse(NestedInteger curList, LinkedList<Integer> list){
        if(curList.isInteger()){
            list.add(curList.getInteger());
            return;
        }
        for(NestedInteger child: curList.getList()){
            traverse(child, list);
        }
    }
    @Override
    public Integer next() {
        return this.it.next();
    }
    @Override
    public boolean hasNext() {
        return this.it.hasNext();
    }
}
```

```
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```
