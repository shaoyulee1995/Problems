boolean containsCloseNums(int[] nums, int k) {
    HashMap<Integer, ArrayList<Integer> > map = new HashMap();
    
    for(int i = 0; i < nums.length; i++){
        ArrayList<Integer> temp = new ArrayList();
        if(!map.containsKey(nums[i])){
            temp.add(i);
            map.put(nums[i], temp);
            continue;
        }
        temp = map.get(nums[i]);
        temp.add(i);
        map.put(nums[i], temp);
    }
    
    for(Integer num: map.keySet()){
        if(map.get(num).size() > 1){
            ArrayList<Integer> list = map.get(num);
            int diff = 0;
            for(int i = 0; i + 1< list.size(); i++){
                diff = Math.abs(list.get(i) - list.get(i+1));
                if(diff <= k){
                    return true;
                }
            }
            return false;
        }
    }
    return false;
}
