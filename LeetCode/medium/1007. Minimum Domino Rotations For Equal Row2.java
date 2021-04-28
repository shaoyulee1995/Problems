class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int minSwap = Math.min(
                      numSwap(A[0], A, B), Math.min(
                      numSwap(B[0], A, B), Math.min(
                      numSwap(A[0], B, A), 
                      numSwap(B[0], B, A))));
        return minSwap == Integer.MAX_VALUE? -1: minSwap;
    }
    
    public int numSwap(int val, int[] A, int[] B){
        int num = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != val && B[i] != val){
                return Integer.MAX_VALUE;
            }else if(A[i] != val){
                num++;
            }
        }
        
        return num;
    }
}