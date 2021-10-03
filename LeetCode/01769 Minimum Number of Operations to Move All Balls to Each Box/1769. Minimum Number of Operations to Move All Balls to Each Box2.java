class Solution {
    public int[] minOperations(String boxes) {
        int[] goRight = new int[boxes.length()];
        int[] goLeft = new int[boxes.length()];
        int[] output = new int[boxes.length()];
        int cnt = 0, sum = 0;
        for(int i = 0; i  < boxes.length(); i++){
            goRight[i] = sum;
            if(boxes.charAt(i) =='1'){
                cnt++;
            }
            sum += cnt; 
        }
        
        cnt = 0; sum = 0;
        for(int i = boxes.length() - 1; i>=0; i--){
            goLeft[i] = sum;
            if(boxes.charAt(i) == '1'){
                cnt++;
            }
            sum += cnt;
        }
        
        for(int i = 0; i < output.length; i++){
            output[i] = Math.abs(goLeft[i] + goRight[i]);
        }
        return output;
    }
}