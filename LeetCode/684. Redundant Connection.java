class Solution {
    class Union{
        int[] parent;
        public Union(int size){
            this.parent = new int[size + 1];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(x == parent[x]){
                return parent[x];
            }
            return parent[x] = find(parent[x]);
        }
        
        public boolean union(int x, int y){
            int uX = find(x),
                uY = find(y);
            if(uX == uY){
                return false;
            }
            parent[uX] = uY;
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        Union u = new Union(edges.length);
        for(int[] edge: edges){
            if(!u.union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }
}