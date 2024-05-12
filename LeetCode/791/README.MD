# Custom Sort String
# String
* Time Complexity: O(O+S)
* Space Complexity: O(26)
```
class Solution {
    public String customSortString(String order, String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while(j < order.length()){
            char c = order.charAt(j);
            for(int i = 0; i < arr[c-'a']; i++){
                sb.append(c);
            }
            arr[c-'a'] = 0;
            j++;
        }
        for(int i = 0; i < arr.length; i++){
            for(int k = 0; k < arr[i]; k++){
                sb.append(""+(char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
```