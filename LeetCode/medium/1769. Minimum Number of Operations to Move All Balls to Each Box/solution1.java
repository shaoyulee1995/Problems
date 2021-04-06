class Solution {
    public int[] minOperations(String boxes) {
        int[] output = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++){
            for(int j = 0; j < boxes.length(); j++){
                if(boxes.charAt(j) == '1'){
                    int diff = Math.abs(i-j);
                    output[i] += diff;
                }
            }
        }
        return output;
    }
}