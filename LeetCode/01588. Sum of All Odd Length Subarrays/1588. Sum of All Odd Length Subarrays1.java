class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            int start = i + 1,
                end = arr.length - i,
                total = start * end,
                odd = total / 2;
            if(total % 2 == 1){
                odd ++;
            }
            cnt += odd * arr[i];
        }
        return cnt;
    }
}