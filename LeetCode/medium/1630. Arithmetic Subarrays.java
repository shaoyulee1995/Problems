class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> valid = new ArrayList();
        for(int i = 0; i < l.length; i++){
            valid.add(helper(nums, l[i], r[i]));       
        }
        System.gc();
        return valid;
    }
    private boolean helper(int[] nums, int l, int r){
        int[] copy = Arrays.copyOfRange(nums, l, r+1);
        if(copy.length<2){
            return false;
        }    
        if(copy.length == 2){
            return true;
        }
        Arrays.sort(copy);
        int diff = copy[1] - copy[0];
        for(int i = 0; i + 1 < copy.length; i++){
            if(copy[i+1] - copy[i] != diff){
                return false;
            }
        }
        return true;
    }
}