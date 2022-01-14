class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] cntA = new int[7],
              cntB = new int[7],
              cntSame = new int[7];
        
        for(int i = 0; i < A.length; i++){
            cntA[A[i]]++;
            cntB[B[i]]++;
            if(A[i] == B[i]){
                cntSame[A[i]]++;
            }
        }
        
        for(int i = 1; i < 7; i++){
            if(cntA[i] + cntB[i] - cntSame[i] == A.length){
                return A.length - Math.max(cntA[i], cntB[i]);
            }
        }
        return -1;
    }
}