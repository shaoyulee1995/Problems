class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0,
            right = arr.length - 1;
        while(left < right){
            int m = left + (right-left) / 2;
            if(arr[m] < arr[m+1]){
                left = m + 1;
            }else{
                right = m;
            }
        }
        // System.gc();
        return left;
    }
}