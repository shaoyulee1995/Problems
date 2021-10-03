class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer> > map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0; i < groupSizes.length; i++){
            int val = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(val)){
                temp = map.get(val);
            }
            temp.add(i);
            map.put(val, temp);
            
            if(val == temp.size()){
                ans.add(temp);
                map.remove(val);
            }
            
        }
        return ans;
    }
}