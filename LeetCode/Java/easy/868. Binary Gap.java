class Solution {
    public int binaryGap(int n) {
        int count = 0;
        for(int i = -32; n > 0; n/=2, i++){
            if(n%2==1){
                count = Math.max(count, i);
                i = 0;
            }
        }
        return count;
    }
}