# Find Median from Data Stream

- Time Complexity: O(NlogN)
- Space Complexity: O(N)

```java
class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }else{
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        return !even? small.peek(): (small.peek() + large.peek())/2.0;
    }
}
```

```
Your MedianFinder object will be instantiated and called as such:
MedianFinder obj = new MedianFinder();
obj.addNum(num);
double param_2 = obj.findMedian();
```
