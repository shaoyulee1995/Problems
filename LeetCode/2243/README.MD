# Calculate Digit Sum of a String
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i += k){
                int len = Math.min(i+k, s.length()),
                    res = 0;
                String val = s.substring(i, len);
                for(char c: val.toCharArray()){
                    res += Character.getNumericValue(c);
                }
                sb.append(res);
            }
            s = sb.toString();
        }
        return s;
    }
}
```