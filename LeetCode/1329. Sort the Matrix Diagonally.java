class Solution {
    public int[][] diagonalSort(int[][] matrix) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap();
        
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                map.putIfAbsent(i - j, new PriorityQueue());
                map.get(i-j).add(matrix[i][j]);
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = map.get(i-j).poll();
            }
        }
        return matrix;
    }
}