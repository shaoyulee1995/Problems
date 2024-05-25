# Walls and Gates

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of rooms
  - M as lenthf of rooms[0]

```java
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for(int level = 1; !queue.isEmpty(); level++){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                for(int[] dir: dirs){
                    int x = node[0] + dir[0],
                        y = node[1] + dir[1];
                    if(x < 0 || x == rooms.length || y < 0 || y == rooms[0].length || rooms[x][y] != Integer.MAX_VALUE || rooms[x][y] == -1 || visited[x][y]){
                        continue;
                    }
                    rooms[x][y] = level;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
```
