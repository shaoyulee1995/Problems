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
# Iterator
* Time Complexity: O(N)
* Space Complexity: O(N)
```
public class NestedIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList();
        for(NestedInteger node: nestedList){
            traverse(node, list);
        }
        this.it = list.iterator();
    }
    public void traverse(NestedInteger node, List<Integer> list){
        if(node.isInteger()){
            list.add(node.getInteger());
            return;
        }    
        for(NestedInteger child: node.getList()){
            traverse(child, list);
        }
    }
    
    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
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