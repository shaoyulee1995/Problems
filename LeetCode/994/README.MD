# Rotting Oranges
# BFS HashSet
* Time Complexity: O(MN)
* Space Complexity: O(Min(M, N))
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int orangesRotting(int[][] grid) {
        HashSet<String> fresh = new HashSet(),
                        rotten = new HashSet();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh.add("" + i + j);
                }else if(grid[i][j] == 2){
                    rotten.add("" + i + j);
                }
            }
        }
        if(fresh.size() == 0){
            return 0;
        }
        if(rotten.size() == 0){
            return -1;
        }
        int res = 0;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(fresh.size() > 0){
            HashSet<String> infected = new HashSet();
            for(String rot: rotten){
                int x = rot.charAt(0) - '0',
                    y = rot.charAt(1) - '0';
                for(int[] dir: dirs){
                    int nextX = x + dir[0],
                        nextY = y + dir[1];
                    if(nextX < 0 || nextX == grid.length || nextY < 0 || nextY == grid[0].length){
                        continue;
                    }
                    if(grid[nextX][nextY] == 1){
                        grid[nextX][nextY] = 2;
                        infected.add("" + nextX + nextY);
                        fresh.remove("" + nextX + nextY);
                    }
                }
            }
            if(infected.size() == 0){
                return -1;
            }
            res++;
            rotten = infected;
        }
        return res;
    }
}
```
# BFS Queue
* Time Complexity: O(MN)
* Space Complexity: O(Min(M, N))
	* N as length of grid
	* M as length of grid[0]
```
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        if(queue.size() == 0){
            return -1;
        }
        int res = -1;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                int x = node[0],
                    y = node[1];
                for(int[] dir: dirs){
                    int nextX = dir[0] + x,
                        nextY = dir[1] + y;
                    if(nextX < 0 || nextY < 0 || nextX == grid.length || nextY == grid[0].length){
                        continue;
                    }
                    if(grid[nextX][nextY] == 1){
                        grid[nextX][nextY] = 2;
                        queue.offer(new int[]{nextX, nextY});
                        fresh--;
                    }
                }
            }
            res++;
        }
        return fresh != 0? -1: res;
    }
}
```