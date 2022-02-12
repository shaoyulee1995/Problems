class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> list = buildTree(forest);
        
        //sort by the val
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });
        int minStep = 0;
        int curX = 0, curY = 0;
        
        while(!list.isEmpty()){
            int[] curCell = list.remove(0);
            int step = getDis(forest, curX, curY, curCell[0], curCell[1]);
            if(step == -1){
                return -1;
            }
            curX = curCell[0];
            curY = curCell[1];
            minStep += step;
            forest.get(curX).set(curY, 1);
        }
        return minStep;
    }
    
    private int getDis(List<List<Integer>> list, int curX, int curY, int srcX, int srcY){
        boolean[][] visited = new boolean[list.size()][list.get(0).size()];
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{curX, curY});
        visited[curX][curY] = true;
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curCell = q.poll();
                if(curCell[0] == srcX && curCell[1] == srcY){
                    return step;
                }
                for(int[] d: dirs){
                    int newX = d[0] + curCell[0],
                        newY = d[1] + curCell[1];
                    if(newX >= 0 && newX < list.size() && 
                       newY >= 0 && newY < list.get(0).size() &&
                       list.get(newX).get(newY) != 0 && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    public List<int[]> buildTree(List<List<Integer>> forest){
        List<int[]> list = new ArrayList();
        
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(forest.get(i).get(j) > 1){
                    //store row, col, val
                    int[] elements = {i, j, forest.get(i).get(j)};
                    list.add(elements);
                }
            }
        }
        return list;
    }
}