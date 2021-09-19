boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap();
    for(int i = 0; i < nums.length; i++){
        Integer index = map.get(nums[i]);
        
        if(index != null && Math.abs(i - index)<=k){
            return true;
        }
        map.put(nums[i], i);
    }
    return false;
}
