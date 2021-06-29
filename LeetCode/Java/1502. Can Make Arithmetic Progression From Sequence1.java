class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i = 1; i + 1< arr.length; i++){
            if(arr[i] - arr[i-1] != arr[i+1] - arr[i]){
                return false;
            }
        }
        return true;
    }
}