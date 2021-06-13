class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int n: nums){
            if(map.containsKey(n))
                continue;
            int left = (map.containsKey(n-1))?map.get(n-1):0,
                right = (map.containsKey(n+1))?map.get(n+1):0,
                total = left + right + 1;
            
            map.put(n-left, total);
            map.put(n+right, total);
            map.put(n, total);
            ans = Math.max(ans, total);
        }
        return ans;
    }
}