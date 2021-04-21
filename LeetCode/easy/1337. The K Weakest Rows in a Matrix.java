class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        
        TreeMap<Integer, List<Integer> > map = new TreeMap();
        for(int i = 0; i < mat.length; i++){
            int cnt = 0;
            for(int man: mat[i]){
                if(man == 1){
                    cnt++;
                }
            }
            if(!map.containsKey(cnt)){
                map.put(cnt, new ArrayList());
            }
            
            map.get(cnt).add(i);
        }
        
        int index = 0;
        for(int num: map.keySet()){
            for(int val: map.get(num)){
                if(index == k){
                    return res;
                }
                res[index++] = val;
            }
        }
        return res;
    }
}