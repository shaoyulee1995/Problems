class Solution {
    public int[] minOperations(String boxes) {
        int[] goRight = new int[boxes.length()];
        int[] goLeft = new int[boxes.length()];
        int[] output = new int[boxes.length()];
        
        int cnt = boxes.charAt(0) -'0';
        for(int i = 1; i < boxes.length(); i++){
            goRight[i] = goRight[i-1] + cnt;
            cnt += boxes.charAt(i) -'0';
        }
        
        cnt = boxes.charAt(boxes.length() - 1) -'0';
        for(int i = boxes.length() - 2; i >=0; i--){
            goLeft  [i] = goLeft[i+1] + cnt;
            cnt += boxes.charAt(i) -'0';
        }
        
        
        for(int i = 0; i < output.length; i++){
            output[i] = goLeft[i] + goRight[i];
        }
        return output;
    }
}