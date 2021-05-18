class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = arr[0], win = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>cur){
                win = 0;
                cur = arr[i];
            }
            if(++win == k){
                break;
            }
        }
        return cur;
    }
}