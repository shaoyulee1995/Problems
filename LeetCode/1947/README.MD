# Maximum Compatibility Score Sum

- Time Complexity: O(N!\*M)
- Space Complexity: O(N)
  - N as length of students
    - M as length of mentors

```
class Solution {
    int res;
    boolean[] visited;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        visited = new boolean[students.length];
        res = 0;
        dfs(students, 0, mentors, 0);
        return res;
    }

    public void dfs(int[][] students, int s, int[][] mentors, int score){
        if(s == students.length){
            res = Math.max(res, score);
            return;
        }
        for(int i = 0; i < mentors.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(students, s+1, mentors, score+getScore(students[s], mentors[i]));
            visited[i] = false;
        }
    }

    public int getScore(int[] student, int[] mentor){
        int res = 0;
        for(int i = 0; i < student.length; i++){
            res += (student[i] == mentor[i])? 1: 0;
        }
        return res;
    }
}
```
