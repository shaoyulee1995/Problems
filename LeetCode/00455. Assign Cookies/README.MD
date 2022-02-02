# Sliding Windows
* Time Complexity: O(Math(Nlog(N), Mlog(M))
* Space Complexity: O(1)
	* N as length of g
	* M as length of s
```
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        for(; i < g.length && j < s.length;){
            if(s[j] >= g[i]){
                j++;
                i++;
                res++;
				continue;
            }
			j++;
        }
        return res;
    }
}
```