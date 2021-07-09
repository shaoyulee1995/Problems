class Solution {
    public int numberOfSteps (int num) {
        int step = 0;
        while(num>0){
            if(num%2 == 0){
                num /=2;
            }else{
                num -=1;
            }
            step++;
        }
        return step;
    }
}

class Solution {
    public int numberOfSteps (int num) {
        int step = 0;
        while(num>0){
            step++;
            if((num & 1) == 1){
                num -=1;
                continue;
            }
            num /=2;
        }
        return step;
    }
}