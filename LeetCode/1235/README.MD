# Maximum Profit in Job Scheduling

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of startTime

```java
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(0, 0);
        for(Job job: jobs){
            int curMoney = map.floorEntry(job.startTime).getValue() + job.profit;
            if(curMoney > map.lastEntry().getValue()){
                map.put(job.endTime, curMoney);
            }
        }
        return map.lastEntry().getValue();
    }

    class Job{
        int startTime, endTime, profit;
        public Job(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of startTime

```java
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(jobs[j][1] <= jobs[i][0]){
                    dp[i] += dp[j];
                    break;
                }
            }
            dp[i] += jobs[i][2];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[n-1];
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of startTime

```java
class Solution {
    Integer[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        dp = new Integer[n];
        int[][] jobs = new int[n][3];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        return dfs(0, jobs);
    }

    public int dfs(int cur, int[][] jobs){
        if(cur == jobs.length){
            return 0;
        }
        if(dp[cur] != null){
            return dp[cur];
        }
        int includeProfit = jobs[cur][2] + dfs(findNext(cur, jobs), jobs),
            excludePorfit = dfs(cur+1, jobs);
        dp[cur] = Math.max(includeProfit, excludePorfit);
        return dp[cur];
    }

    public int findNext(int cur, int[][] jobs){
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;
            }
        }
        return jobs.length;
    }
}
```
