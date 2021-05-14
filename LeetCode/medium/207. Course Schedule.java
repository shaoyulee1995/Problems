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