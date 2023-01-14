# String
* Time Complexity: O(N<sup>3</sup>)
* Space Complexity: O(N)
	* N as length of text
```
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList();
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        for(int i = 0; i < text.length(); i++){
            for(int j = i; j < text.length(); j++){
                String subWord = text.substring(i, j+1);
                if(set.contains(subWord)){
                    res.add(new int[]{i, j});
                }
            }
        }
        int[][] ans = new int[res.size()][];
        ans = res.toArray(ans);
        return ans;
    }
}
```