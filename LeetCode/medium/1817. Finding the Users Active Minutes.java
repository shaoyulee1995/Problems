class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        
        HashMap<Integer, Set<Integer> > map = new HashMap();
        
        for(int[] log: logs){
            map.putIfAbsent(log[0], new HashSet());
            map.get(log[0]).add(log[1]);
        }
        
        for(int num: map.keySet()){
            res[map.get(num).size() - 1]++;
        }
        System.gc();
        return res;
    }
}