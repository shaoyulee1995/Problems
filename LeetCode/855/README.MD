# Exam Room

```java
Your ExamRoom object will be instantiated and called as such:
ExamRoom obj = new ExamRoom(n);
int param_1 = obj.seat();
obj.leave(p);
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the number of seats

```java
class ExamRoom {
    int N;
    PriorityQueue<Interval> pq;

    class Interval{
        int start, end, distance;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
            if(start == -1){
                this.distance = end;
            }else if(end == N){
                this.distance = end - 1 - start;
            }else{
                this.distance = (end - start)/2;
            }
        }
    }
    public ExamRoom(int n) {
        this.N = n;
        pq = new PriorityQueue<>((a, b) -> {
            if(a.distance == b.distance){
                return a.start - b.start;
            }
            return b.distance - a.distance;
        });
        pq.offer(new Interval(-1, n));
    }
    
    public int seat() {
        int seat = 0;
        Interval interval = pq.poll();
        if(interval.start == -1){
            seat = 0;
        }else if(interval.end == N){
            seat = N-1;
        }else{
            seat = (interval.start+interval.end)/2;
        }
        pq.offer(new Interval(interval.start, seat));
        pq.offer(new Interval(seat, interval.end));
        return seat;
    }
    
    public void leave(int p) {
        boolean foundLeft = false,
                foundRight = false;
        Interval left = null,
                 right = null;
        for(Interval interval: pq){
            if(interval.start == p){
                right = interval;
                foundRight = true;
            }
            if(interval.end == p){
                left = interval;
                foundLeft = true;
            }
            if(foundLeft && foundRight){
                break;
            }
        }
        pq.remove(left);
        pq.remove(right);
        pq.offer(new Interval(left.start, right.end));
    }
}
```
