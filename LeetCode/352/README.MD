# Data Stream as Disjoint Intervals

# TreeSet

- Time Complexity:
  - addNum: O(logN)
  - getIntervals: O(N)
- Space Complexity:
  - addNum: O(1)
  - getIntervals: O(N)
    - N as length of intervals

```
class SummaryRanges {
    TreeSet<int[]> set;
    public SummaryRanges() {
        set = new TreeSet<int[]>((a,b) -> (a[0] == b[0])? a[1] - b[1]: a[0] - b[0]);
    }

    public void addNum(int val) {
        int[] interval = new int[]{val, val};
        if(set.contains(interval)){
            return;
        }
        int[] high = set.higher(interval),
              low = set.lower(interval);
        if(high != null && high[0] == val+1 && low != null && low[1] == val-1){
            high[0] = low[0];
            set.remove(low);
        }else if(high != null && high[0] == val+1){
            high[0] = val;
        }else if(low != null && low[1] == val-1){
            low[1] = val;
        }else if((high != null && high[0] == val)|| (low != null && low[1] >= val && low[0] <= val)){
            return;
        }else{
            set.add(interval);
        }
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList();
        for(int[] m: set){
            res.add(m);
        }
        return res.toArray(new int[0][]);
    }
}
```

```
/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
```
