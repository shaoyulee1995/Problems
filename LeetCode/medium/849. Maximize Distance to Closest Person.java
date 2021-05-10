class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1, maxDistance = 0;
        
        //000001 case1
        //100001 case2
        //100000 case3
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                continue;
            }
            //case 1&2
            if(left == -1){
                maxDistance = Math.max(maxDistance, i);    
            }else{
                maxDistance = Math.max(maxDistance, (i - left)/2);
            }
            left = i;
        }
        
        //case 3
        if(seats[seats.length - 1] == 0){
            maxDistance = Math.max(maxDistance, seats.length - 1 - left);
        }
        return maxDistance;
    }
}