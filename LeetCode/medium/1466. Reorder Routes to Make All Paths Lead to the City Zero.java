class Solution {
    public int minReorder(int n, int[][] connections) {
        HashSet<Integer> set = new HashSet();
        int u, v; 
        int path = 0;
        set.add(0);//each city can visit the city 0
        while(set.size() < n){
            for(int[] c: connections){
                u = c[0];
                v = c[1];
                if(set.contains(u) && !set.contains(v)){
                    path++;
                    set.add(v);
                }else if(!set.contains(u) && set.contains(v)){
                    set.add(u);
                }
            }
        }
        return path;
    }
}