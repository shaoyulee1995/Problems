int avoidObstacles(int[] nums) {
    boolean fail = true;
    int jump = 0;
    while(fail){
        fail = false;
        jump++;
        for(int num: nums){
            if(num % jump == 0){
                fail = true;
                break;
            }
        }
    }
    return jump;
}