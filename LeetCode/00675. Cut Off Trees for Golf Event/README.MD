# BFS
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> paths = traverse(forest);    
        return getMinimumStep(paths, forest);
    }

    public int getMinimumStep(PriorityQueue<int[]> paths, List<List<Integer>> forest){
        int totalSteps = 0;
        int[] lastPosition = {0,0};
        while(!paths.isEmpty()){
            int[] node = paths.poll();
            int currentStep = bfs(paths, forest, node, lastPosition);
            if(currentStep == -1){
                return -1;
            }
            forest.get(node[0]).set(node[1], 1);
            totalSteps += currentStep;
            lastPosition = node;
        }
        return totalSteps;
        
    }

    public int bfs(PriorityQueue<int[]> paths, List<List<Integer>> forest, int[] srcNode, int[] destNode){
        int steps = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList();
        queue.offer(srcNode);
        visited[srcNode[0]][srcNode[1]] = true;
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int[] node = queue.poll();
                if(node[0] == destNode[0] && node[1] == destNode[1]){
                    return steps;
                }
                for(int[] dir: dirs){
                    int nextX = dir[0] + node[0],
                        nextY = dir[1] + node[1];
                    if(nextX < 0 || nextX == forest.size() || nextY < 0 || nextY == forest.get(0).size()){
                        continue;
                    }
                    if(forest.get(nextX).get(nextY) == 0 || visited[nextX][nextY]){
                        continue;
                    }
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    public PriorityQueue<int[]> traverse(List<List<Integer>> forest){
        PriorityQueue<int[]> res = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    res.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        return res;
    }
}
```