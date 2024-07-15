# Course Schedule II

- Time Complexity: O(V+E)
- Space Complexity: O(V+E)
  - V as numCourses
  - E as course relates to

```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] inDegree = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            int start = prerequisite[1],
                end = prerequisite[0];
            map.computeIfAbsent(start, x -> new ArrayList()).add(end);
            inDegree[end]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0, idx = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[idx++] = cur;
            count++;
            for(int neighbor: map.getOrDefault(cur, new ArrayList<>())){
                if(--inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        return (count == numCourses)? res: new int[0];
    }
}
```
