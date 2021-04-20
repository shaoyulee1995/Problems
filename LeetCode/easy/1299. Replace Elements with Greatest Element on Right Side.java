class Solution {
    public int[] replaceElements(int[] arr) {
        
        int max = arr[arr.length - 1];
        
        for(int i = arr.length - 2; i >= 0; i--){
            int cur = arr[i];
            arr[i] = max;
            max = Math.max(max, cur);
        }
        
        arr[arr.length - 1] = -1;
        
        return arr;
    }
}