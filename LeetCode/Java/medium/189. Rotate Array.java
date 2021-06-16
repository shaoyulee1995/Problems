class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    
    public void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0){return;}
        int[] output = nums.clone();
        int index = 0;
        for(int i = nums.length - k; i < nums.length; i++){
            nums[index++] = output[i];
        }
        for(int i = 0; i < nums.length - k;i++){
            nums[index++] = output[i];
        }
        
    }
}