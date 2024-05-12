# Find the Town Judge
# Counting Sort
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] cnt = new int[N+1];
        for(int[] t: trust){
            cnt[t[0]]--;
            cnt[t[1]]++;
        }
        
        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}
```