# Sort the Students by Their Kth Score
# Array
* Time Complexity: O(NlogN)
* Space Complexity: O(1)
	* N as length of score
```
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
```
# Array
* Time Complexity: O(NlogN)
* Space Complexity: O(NM)
	* N as length of score
    * M as length of score[0]
```
class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < score.length; i++){
            pq.add(new int[]{score[i][k], i});
        }
        int[][] res = new int[score.length][score[0].length];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = score[pq.remove()[1]];
        }
        return res;
    }
}


```