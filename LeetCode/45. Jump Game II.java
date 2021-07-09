class Solution {
    public int jump(int[] nums) {
        int curEnd = 0, far = 0, jump = 0;
        for(int i = 0; i < nums.length - 1; i++){
            far = Math.max(far, i + nums[i]);
            if(curEnd == i){
                jump++;
                curEnd = far;
                if(curEnd >= nums.length - 1){
                    break;
                }
            }
        }
        return jump;
    }
}

/*
2 3 1 1 4
  ---
    -----
    ---
      ---
*/