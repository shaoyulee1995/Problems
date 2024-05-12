# Shortest Distance to a Character
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int[] shortestToChar(String s, char t) {
        int[] res = new int[s.length()];
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == t){
                set.add(i);
            }
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == t){
                continue;
            }
            int dis = Integer.MAX_VALUE;
            for(Integer v: set){
                dis = Math.min(dis, Math.abs(i-v));
            }
            res[i] = dis;
        }
        return res;
    }
}
```