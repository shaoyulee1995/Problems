# Moving Average from Data Stream

# List

- Space Complexity: O(N)
- double
  - Time Complexity: O(N)
    - N as length of res

```
class MovingAverage {
    int size;
    List<Integer> res = new ArrayList();
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        res.add(val);
        double ans = 0;
        for(int i = Math.max(0, res.size() - size); i < res.size(); i++){
            ans += res.get(i);
        }
        return ans/Math.min(size, res.size());
    }
}
```

# List

- Space Complexity: O(N)
- double
  - Time Complexity: O(1)
    - N as size of queue

```
class MovingAverage {
    LinkedList<Integer> queue = new LinkedList();
    double sum = 0;
    int size;
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == size){
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);
        return sum/queue.size();
    }
}
```
