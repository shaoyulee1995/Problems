# Task Scheduler

- Time Complexity: O(Max(T, FlogF))
- Space Complexity: O(1)
  - T as length of tasks
  - F as length of freqs

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for(char task: tasks){
            freqs[task-'A']++;
        }
        Arrays.sort(freqs);
        int i = 25;
        while(i >= 0 && freqs[i] == freqs[25]){
            i--;
        }
        return Math.max(tasks.length, (freqs[25]-1) *(n+1) + (25-i));
    }
}
```

- Time Complexity: O(Max(T, F))
- Space Complexity: O(1)
  - T as length of tasks
  - F as length of freqs

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        int maxFreq = 0,
            maxFreqCount = 0;
        for(char task: tasks){
            freqs[task-'A']++;
            maxFreq = Math.max(maxFreq, freqs[task-'A']);
        }
       for(int freq: freqs){
           maxFreqCount += (freq == maxFreq)? 1: 0;
       }
       return Math.max(tasks.length, (maxFreq-1)*(n+1) + maxFreqCount);
    }
}

```
