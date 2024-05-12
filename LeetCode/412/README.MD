# Fizz Buzz
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of n
```
class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(FIZZ).append(BUZZ);
        while(i <= n){
            if(i % 3 == 0 && i % 5 == 0){
                res.add(sb.toString());
            }else if(i % 3 == 0){
                res.add(FIZZ);
            }else if(i % 5 == 0){
                res.add(BUZZ);
            }else{
                res.add(String.valueOf(i));
            }
            i++;
        }
        return res;
    }
}
```