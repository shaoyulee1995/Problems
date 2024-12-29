# Surrounded Regions

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - N as rows
  - M as cols

```java
class Solution {
    public void solve(char[][] board) {
        int n = board.length,
            m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y){
        if(x < 0 || x == board.length){
            return;
        }
        if(y < 0 || y == board[0].length){
            return;
        }
        if(board[x][y] == 'X' || board[x][y] == '*'){
            return;
        }
        board[x][y] = '*';
        dfs(board, x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y+1);
        dfs(board, x, y-1);
    }
}
```

- Time Complexity: O(MN)
- Space Complexity: O(MN)
  - N as rows
  - M as cols

```java
class Solution {
    class UnionFind{
        private int[] parents;
        public UnionFind(int totalNodes){
            parents = new int[totalNodes];
            for(int i = 0; i < totalNodes; i++){
                parents[i] = i;
            }
        }

        void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2){
                parents[root2] = root1;
            }
        }
        int find(int node){
            while(parents[node] != node){
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }
        boolean isConnected(int node1, int node2){
            return find(node1) == find(node2);
        }
    }
    int rows, cols;
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        rows = board.length;
        cols = board[0].length;
        UnionFind uf = new UnionFind(rows*cols+1);
        int dummy = rows*cols;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    if(i == 0 || i == rows - 1 || j == 0 || j == cols -1){
                        uf.union(node(i, j), dummy);
                    }else{
                        if(board[i-1][j] == 'O'){
                            uf.union(node(i, j), node(i-1, j));
                        }
                        if(board[i+1][j] == 'O'){
                            uf.union(node(i, j), node(i+1, j));
                        }
                        if(board[i][j-1] == 'O'){
                            uf.union(node(i, j), node(i, j-1));
                        }
                        if(board[i][j+1] == 'O'){
                            uf.union(node(i, j), node(i, j+1));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(uf.isConnected(node(i, j), dummy)){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public int node(int i, int j){
        return i*cols + j;
    }
}
```

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the number of nodes

```java
class Solution {
   class UnionFind{
        int[] weights;
        int[] parents;

        public UnionFind(int n){
            weights = new int[n+1];
            parents = new int[n+1];
            for(int i = 0; i <= n; i++){
                weights[i] = i;
                parents[i] = i;
            }
        }

        public boolean isConnected(int nodeA, int nodeB){
            return find(nodeA) == find(nodeB);
        }

        public int find(int x){
            while(x != parents[x]){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public void union(int nodeA, int nodeB){
            int rootA = find(nodeA),
                rootB = find(nodeB);
            if(rootA == rootB){
                return;
            }
            if(weights[rootA] > weights[rootB]){
                parents[rootB] = rootA;
                weights[rootA] += weights[rootB];
            }else{
                parents[rootA] = rootB;
                weights[rootB] += weights[rootA];
            }
        }
    }
    public int minimumCost(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int res = 0,   
            visited = 0;
        for(int[] connection: connections){
            int src = connection[0],
                dest = connection[1],
                cost = connection[2];
            if(uf.isConnected(src, dest)){
                continue;
            }
            uf.union(src, dest);
            res += cost;
            visited++;
            if(visited == n-1){
                return res;
            }
        }
    
        return visited == n-1? res: -1;
    }
}
```