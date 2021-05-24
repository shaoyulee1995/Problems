class Solution {
    final int mod = (int)1e9+7;
    HashMap<String, Integer> map = new HashMap();
    public int numRollsToTarget(int d, int f, int target) {
        if(target>d*f || target < d){
            return 0;
        }
        if(d==1){
            return target<=f?1:0;
        }
        final String key = "" + d + f + target;
        if(!map.containsKey(key)){
            int curSum = 0;
            for(int i = 1; i <= f; i++){
                curSum += numRollsToTarget(d-1, f, target-i);
                curSum %= mod;
            }
            map.put(key, curSum);
            System.out.println("key: " + key);
        }
        return map.get(key); 
    }
}