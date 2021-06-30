class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap();
        
        int i = 0, res = 0;
        
        for(int j = 0; j < tree.length; j++){
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            
            if(map.size() > 2){
                map.put(tree[i], map.get(tree[i])-1);
                if(map.get(tree[i]) == 0){
                    map.remove(tree[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
        
    }
}