class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0, count = 0;
        for(char c: s.toCharArray()){
            if(c == 'L'){
                balance -= 1;
            }else if(c == 'R'){
                balance += 1;
            }
            if(balance == 0){
                count++;
            }
        }
        return count;
    }
}