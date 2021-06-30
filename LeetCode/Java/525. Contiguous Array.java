class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int cnt = 0, max_length = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0){
                cnt--;
            }else{
                cnt++;
            }
            if(map.containsKey(cnt)){
                max_length = Math.max(max_length, i-map.get(cnt));
            }else{
               map.put(cnt, i);
            }
        }    
        return max_length;
    }
}