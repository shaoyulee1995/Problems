int[] extractEachKth(int[] nums, int k) {
    int cnt = 0;
    for(int i = 0; i < nums.length; i++){
        if((i+1) % k == 0){
            cnt++;
        }
    }
    
    int[] output = new int[nums.length - cnt];
    int index = 0;
    for(int i = 0; i < nums.length; i++){
        if((i+1)%k != 0){
            output[index++] = nums[i];
        }
    }
    return output;
}
