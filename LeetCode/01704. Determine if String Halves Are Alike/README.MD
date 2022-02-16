# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int c1 = 0,
            c2 = 0;
        for(int i = 0, j = s.length() -1; i < j; i++, j--){
            c1 += set.contains(s.charAt(i))?1:0;
            c2 += set.contains(s.charAt(j))?1:0;
        }
        return c1==c2;
    }
}
```