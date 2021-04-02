class Solution {
    public int xorOperation(int n, int start) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = start + 2*i;
        }
        
        int result = 0;
        for(int i: array){
            result = i ^ result;
        }
        return result;
    }
}