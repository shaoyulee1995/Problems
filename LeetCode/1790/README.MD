# Check if One String Swap Can Make Strings Equal

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        List<Integer> diff = new ArrayList();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff.add(i);
            }
        }
        if(diff.size() != 2){
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }
}
```
