# Roman to Integer
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s

```
class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'I':
                    nums[i] = 1;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'M':
                    nums[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        int sum = 0;
        for(int i = 0; i + 1< nums.length; i++){
            if(nums[i] < nums[i+1]){
                sum -= nums[i];
            }else{
                sum += nums[i];
            }
        }
        return sum + nums[nums.length - 1];
    }
}
```