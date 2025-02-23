# Find Median from Data Stream

- Time Complexity: O(NlogN)
- Space Complexity: O(N)

```java
class MedianFinder {
    PriorityQueue<Integer> small, large;
    boolean isEven;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        isEven = true;
    }
    
    public void addNum(int num) {
        if(isEven){
            large.add(num);
            small.add(large.poll());
        }else{
            small.add(num);
            large.add(small.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        return isEven? (small.peek() + large.peek())/2.0: small.peek();
    }
}
```

```
Your MedianFinder object will be instantiated and called as such:
MedianFinder obj = new MedianFinder();
obj.addNum(num);
double param_2 = obj.findMedian();
```
