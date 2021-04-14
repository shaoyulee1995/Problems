class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        
        while(i < j){

            //A[i] is odd and A[j] is even
            //move the the front
            if(A[i] % 2 > A[j] % 2){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            
            if(A[i] % 2==0){
                i++;
            }
            if(A[j] % 2 != 0){
                j--;
            }
        }
        return A;
    }
}