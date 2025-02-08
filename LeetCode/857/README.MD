# Minimum Cost to Hire K Workers

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the length of the array

```java
class Worker{
    int quality, wage;
    double ratio;
    public Worker(int quality, int wage){
        this.quality = quality;
        this.wage = wage;
        ratio = 1d * wage /quality;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[wage.length];
        for(int i = 0; i < wage.length; i++){
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        double res = Double.MAX_VALUE;
        int sumQuality = 0;

        for(Worker worker: workers){
            sumQuality += worker.quality;
            pq.offer(worker.quality);

            if(pq.size() > k){
                sumQuality -= pq.poll();
            }
            if(pq.size() == k){
                res = Math.min(res, worker.ratio*sumQuality);
            }
        }
        return res;
    }
}
```
