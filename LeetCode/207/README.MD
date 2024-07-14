# Course Schedule

# BFS using List

- Time Complexity: O(V+E)
- Space Complexity: O(V+E)
  - V as numCourses
  - E as course relates to

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] pairs) {
        List<Integer>[] outGoingEdge = new LinkedList[numCourses];
        int[] inComingEdge = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            outGoingEdge[i] = new LinkedList();
        }
        for(int[] pair: pairs){
            inComingEdge[pair[0]]++;
            outGoingEdge[pair[1]].add(pair[0]);
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(inComingEdge[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int adj: outGoingEdge[cur]){
               if(--inComingEdge[adj] == 0){
                   q.add(adj);
               }
            }
        }
        return count == numCourses;
    }
}
```

# BFS using HashMap

- Time Complexity: O(V+E)
- Space Complexity: O(V+E)
  - V as numCourses
  - E as course relates to

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        int[] inDegree = new int[numCourses];
        for(int[] prerequisite: prerequisites){
            int end = prerequisite[0],
                start = prerequisite[1];
            map.computeIfAbsent(start, x -> new ArrayList()).add(end);
            inDegree[end]++;
        }
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int neighbor: map.getOrDefault(cur, new ArrayList<>())){
                if(--inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}
```
