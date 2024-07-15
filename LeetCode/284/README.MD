# Peeking Iterator

```
Java Iterator interface reference:
https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
```
- Time Complexity
  - PeekingIterator: O(1)
  - peek: O(1)
  - next: O(1)
  - hasNext: O(1)
- Space Complexity
  - PeekingIterator: O(N)
  - peek: O(1)
  - next: O(1)
  - hasNext: O(1)
    - N as size of iterator
```java
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
        next = null;
        if(hasNext()){
            next = it.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer cur = next;
        if(it.hasNext()){
            next = it.next();
        }else{
            next = null;
        }
        return cur;
	}

	@Override
	public boolean hasNext() {
	    return next != null || it.hasNext();
	}

}
```
