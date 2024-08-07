# Employee Free Time

```
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of schedule

```java
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for(List<Interval> period: schedule){
            for(Interval p: period){
                pq.add(p);
            }
        }
        Interval cur = pq.poll();
        while(!pq.isEmpty()){
            if(cur.end >= pq.peek().start){
                Interval out = pq.poll();
                cur.end = Math.max(cur.end, out.end);
            }else{
                res.add(new Interval(cur.end, pq.peek().start));
                cur = pq.poll();
            }
        }
        return res;
    }
}
```
